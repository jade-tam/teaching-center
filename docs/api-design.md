# API Design

## Overview

The system exposes a RESTful API consumed by the Next.js frontend.

Base URL:

```text
/api
```

Authentication is performed using JWT Bearer Tokens.

---

# Authentication

Protected endpoints require:

```http
Authorization: Bearer <access_token>
```

Roles:

* ADMIN
* TEACHER
* STUDENT

Access control is enforced by Spring Security.

---

# API Conventions

## HTTP Methods

| Method | Purpose          |
| ------ | ---------------- |
| GET    | Retrieve data    |
| POST   | Create resources |
| PUT    | Replace resource |
| PATCH  | Partial update   |
| DELETE | Remove resource  |

---

## Pagination

List endpoints support:

```http
?page=1&size=20
```

Response:

```json
{
  "content": [],
  "page": 1,
  "size": 20,
  "totalElements": 100,
  "totalPages": 5
}
```

---

## Success Response

```json
{
  "data": {}
}
```

---

## Error Response

```json
{
  "status": 400,
  "message": "Validation failed",
  "errors": [
    {
      "field": "email",
      "message": "must be a valid email"
    }
  ]
}
```

---

# Authentication API

## Register Student

```http
POST /api/auth/register
```

Creates a student account.

---

## Login

```http
POST /api/auth/login
```

Authenticates user and returns tokens.

---

## Refresh Token

```http
POST /api/auth/refresh
```

Returns a new access token.

---

## Logout

```http
POST /api/auth/logout
```

Invalidates refresh token.

---

# User API

## Get Current User

```http
GET /api/users/me
```

Returns current authenticated user.

---

## Update Profile

```http
PATCH /api/users/me
```

Updates profile information.

---

## Change Password

```http
POST /api/users/me/change-password
```

Changes user password.

---

# Admin API

## Teacher Management

### Create Teacher

```http
POST /api/admin/teachers
```

### Get Teachers

```http
GET /api/admin/teachers
```

### Get Teacher

```http
GET /api/admin/teachers/{id}
```

### Update Teacher

```http
PUT /api/admin/teachers/{id}
```

---

## User Management

### Get Users

```http
GET /api/admin/users
```

Supports:

```http
?role=STUDENT
?active=true
```

### Get User

```http
GET /api/admin/users/{id}
```

### Update User

```http
PATCH /api/admin/users/{id}
```

### Change User Status

```http
PATCH /api/admin/users/{id}/status
```

---

# Classroom API

## Admin Endpoints

### Create Classroom

```http
POST /api/admin/classrooms
```

### Get Classrooms

```http
GET /api/admin/classrooms
```

### Get Classroom

```http
GET /api/admin/classrooms/{id}
```

### Update Classroom

```http
PUT /api/admin/classrooms/{id}
```

### Archive Classroom

```http
PATCH /api/admin/classrooms/{id}/archive
```

### Assign Teacher

```http
POST /api/admin/classrooms/{id}/assign-teacher
```

---

## Classroom Session API

### Create Sessions

```http
POST /api/admin/classrooms/{id}/sessions
```

Bulk creation of classroom sessions.

### Get Sessions

```http
GET /api/classrooms/{id}/sessions
```

### Get Session

```http
GET /api/classrooms/{id}/sessions/{sessionId}
```

---

# Enrollment Request API

## Student Endpoints

### Create Enrollment Request

```http
POST /api/student/enrollment-requests
```

### View Requests

```http
GET /api/student/enrollment-requests
```

---

## Teacher Endpoints

### View Pending Requests

```http
GET /api/teacher/enrollment-requests
```

Optional filters:

```http
?classroomId=1
```

### Approve Request

```http
POST /api/teacher/enrollment-requests/{id}/approve
```

### Reject Request

```http
POST /api/teacher/enrollment-requests/{id}/reject
```

---

# Enrollment API

## Teacher

### View Classroom Enrollments

```http
GET /api/teacher/classrooms/{id}/enrollments
```

Returns approved students.

---

## Student

### View Enrolled Classrooms

```http
GET /api/student/classrooms
```

---

# Attendance API

## Teacher Endpoints

### Create Attendance

```http
POST /api/teacher/attendance
```

Supports bulk attendance submission.

### Update Attendance

```http
PUT /api/teacher/attendance/{id}
```

### View Session Attendance

```http
GET /api/teacher/classrooms/{classroomId}/sessions/{sessionId}/attendance
```

---

## Student Endpoints

### View Attendance

```http
GET /api/student/attendance
```

Supports:

```http
?classroomId=1
```

---

# Grade Component API

## Admin Endpoints

### Create Components

```http
POST /api/admin/classrooms/{id}/grade-components
```

### Get Components

```http
GET /api/admin/classrooms/{id}/grade-components
```

### Update Component

```http
PUT /api/admin/classrooms/{id}/grade-components/{componentId}
```

### Delete Component

```http
DELETE /api/admin/classrooms/{id}/grade-components/{componentId}
```

---

# Grade API

## Teacher Endpoints

### Create Grade

```http
POST /api/teacher/grades
```

### Update Grade

```http
PUT /api/teacher/grades/{id}
```

### View Classroom Grades

```http
GET /api/teacher/classrooms/{id}/grades
```

Supports:

```http
?studentId=1
```

---

## Student Endpoints

### View Grades

```http
GET /api/student/grades
```

Supports:

```http
?classroomId=1
```

---

# Public Classroom API

## Browse Available Classrooms

```http
GET /api/student/classrooms/available
```

Returns classrooms available for enrollment.

---

# HTTP Status Codes

| Code | Meaning                 |
| ---- | ----------------------- |
| 200  | Success                 |
| 201  | Resource Created        |
| 204  | No Content              |
| 400  | Validation Error        |
| 401  | Unauthorized            |
| 403  | Forbidden               |
| 404  | Resource Not Found      |
| 409  | Conflict                |
| 422  | Business Rule Violation |
| 500  | Internal Server Error   |

---

# Future Enhancements

Potential future APIs:

* Notification API
* Dashboard Statistics API
* File Upload API
* Email Verification API
* Password Reset API
* Reporting API
