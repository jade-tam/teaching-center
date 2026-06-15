#!/bin/bash
set -e

# =====================
# CONFIG (can override via args)
# =====================
SERVER_USER="${1:-your-user}"
SERVER_IP="${2:-your-server-ip}"
TARGET_DIR="/srv/teaching-center-app"

REMOTE="$SERVER_USER@$SERVER_IP"

# =====================
# PATH RESOLUTION (IMPORTANT FIX)
# =====================
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"

echo "=================================="
echo "Deploying to $REMOTE"
echo "Project root: $ROOT_DIR"
echo "=================================="

# =====================
# 1. BUILD BACKEND JAR LOCALLY
# =====================
echo "Building backend with Maven..."

mvn -f "$ROOT_DIR/teaching-center-backend/pom.xml" clean package -DskipTests

JAR_FILE=$(ls "$ROOT_DIR/teaching-center-backend/target/"*.jar | head -n 1)

echo "Built JAR: $JAR_FILE"

# =====================
# 2. PREP SERVER FOLDER
# =====================
echo "Creating remote directories..."

ssh "$REMOTE" << EOF
mkdir -p "$TARGET_DIR/backend"
mkdir -p "$TARGET_DIR/deploy"
EOF

# =====================
# 3. COPY JAR ONLY
# =====================
echo "Uploading backend JAR..."

scp "$JAR_FILE" "$REMOTE:$TARGET_DIR/backend/app.jar"

# =====================
# 4. COPY DEPLOY CONFIG (docker-compose + Dockerfile)
# =====================
echo "Uploading deploy configs..."

scp -r "$ROOT_DIR/deploy/backend.Dockerfile" "$REMOTE:$TARGET_DIR/backend/Dockerfile"
scp -r "$ROOT_DIR/deploy/compose.yaml" "$REMOTE:$TARGET_DIR/deploy/compose.yaml"

# =====================
# 5. RESTART CONTAINERS
# =====================
echo "Restarting services..."

ssh "$REMOTE" << EOF
cd "$TARGET_DIR/deploy"
docker compose down
docker compose up -d --build
EOF

echo "=================================="
echo "Deployment complete!"
echo "=================================="
