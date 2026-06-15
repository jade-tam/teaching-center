# System Architecture

## Overview

The system follows a standard three-tier architecture:

```text
┌───────────────┐
│   Next.js     │
│   Frontend    │
└───────┬───────┘
        │ HTTPS / REST
        ▼
┌───────────────┐
│ Spring Boot   │
│ Backend API   │
└───────┬───────┘
        │
 ┌──────┴──────┐
 ▼             ▼
PostgreSQL   Redis
```

Responsibilities are separated between presentation, business logic, and data storage layers.

---

# Frontend

Technology:

* Next.js
* TypeScript
* Tailwind CSS

Responsibilities:

### Authentication

* Login
* Registration
* Token refresh handling
* Route protection

### Student Features

* Browse classrooms
* Submit enrollment requests
* View enrollment status
* View attendance records
* View grades
* Manage profile

### Teacher Features

* View assigned classrooms
* Approve/reject enrollment requests
* Record attendance
* Manage grades
* View classroom statistics

### Admin Features

* User management
* Teacher management
* Classroom management
* Session management
* Grade component management

The frontend communicates only with the REST API and never accesses the database directly.

---

# Backend

Technology:

* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* Bean Validation

Responsibilities:

### Authentication & Authorization

* User login
* User registration
* JWT generation and validation
* Refresh token management
* Role-based access control

### Business Logic

* Enrollment workflow
* Attendance management
* Grade calculation
* Classroom management
* User management

### Validation

* Request validation
* Business rule enforcement
* Permission checks

### API Layer

REST endpoints grouped by role:

```text
/api/auth/**
/api/users/**
/api/student/**
/api/teacher/**
/api/admin/**
```

---

# PostgreSQL

Primary persistent storage.

Stores:

### User Domain

* users

### Classroom Domain

* classrooms
* class_sessions

### Enrollment Domain

* enrollments
* enrollment_requests

### Attendance Domain

* attendance

### Grade Domain

* grade_components
* grades

### Audit Domain

* audit_logs (optional future enhancement)

PostgreSQL is the source of truth for all business data.

---

# Redis

Used for short-lived and frequently accessed data.

Stores:

### Refresh Tokens

* JWT refresh tokens
* Token rotation support
* Token revocation on logout

### Cache

Potential cache targets:

* Classroom details
* Classroom statistics
* Dashboard summaries

Redis is not used as the primary database.

---

# Security

Implemented using Spring Security.

Authentication:

```text
Login
  ↓
JWT Access Token (15 min)
JWT Refresh Token (7 days)
  ↓
Refresh Token stored in Redis
```

Authorization:

### Roles

* ADMIN
* TEACHER
* STUDENT

### Access Rules

ADMIN

* Full system access

TEACHER

* Manage assigned classrooms
* Manage attendance
* Manage grades
* Manage enrollment requests

STUDENT

* Manage own profile
* Request enrollment
* View own attendance
* View own grades

Security Features:

* BCrypt password hashing
* JWT authentication
* Refresh token rotation
* Endpoint authorization
* Method-level security (@PreAuthorize)

---

# Core Business Modules

## User Management

Responsibilities:

* Registration
* Authentication
* Profile management
* Teacher creation
* User activation/deactivation

---

## Classroom Management

Responsibilities:

* Create classrooms
* Assign teachers
* Manage classroom sessions
* Archive classrooms

Key entities:

```text
Classroom
 └── ClassSession
```

---

## Enrollment Management

Workflow:

```text
Student
   ↓
Enrollment Request
   ↓
Teacher Review
   ↓
Approved / Rejected
   ↓
Enrollment Created
```

Business rules:

* Capacity limit
* Enrollment deadline
* Re-enrollment cooldown after rejection

---

## Attendance Management

Workflow:

```text
Classroom
   ↓
Class Session
   ↓
Attendance Record
```

Rules:

* Attendance tied to a specific session
* Only assigned teacher can record attendance
* Attendance can only be modified on the session date

---

## Grade Management

Workflow:

```text
Classroom
   ↓
Grade Component
   ↓
Student Grade
```

Examples:

* Assignment
* Quiz
* Midterm
* Final Exam

Final grade is calculated automatically using component weights.

---

# Logging

## Application Logs

Recorded events:

* Login/logout
* Enrollment requests
* Enrollment approvals/rejections
* Attendance submissions
* Grade updates

---

## Audit Logs

Sensitive actions:

* User role changes
* User activation/deactivation
* Classroom creation
* Classroom archiving
* Enrollment decisions
* Grade modifications

Captured fields:

* Actor ID
* Action
* Resource Type
* Resource ID
* Timestamp

---

# Error Handling

Centralized exception handling using:

```text
@ControllerAdvice
```

Common responses:

* 400 Bad Request
* 401 Unauthorized
* 403 Forbidden
* 404 Not Found
* 409 Conflict
* 422 Business Rule Violation

Consistent JSON error format is returned across all endpoints.
