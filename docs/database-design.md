# Database Design

## Overview

The system uses PostgreSQL as the primary relational database.

The database is organized into the following domains:

* User Management
* Classroom Management
* Enrollment Management
* Attendance Management
* Grade Management

---

# Entity Relationship Overview

```text
User
 ├── Classroom (Teacher)
 ├── Enrollment
 ├── EnrollmentRequest
 ├── Attendance
 └── Grade

Classroom
 ├── ClassSession
 ├── Enrollment
 ├── EnrollmentRequest
 └── GradeComponent

ClassSession
 └── Attendance

GradeComponent
 └── Grade
```

---

# Users

Stores all system users.

## Table: users

| Column        | Type         | Constraints           |
| ------------- | ------------ | --------------------- |
| id            | BIGSERIAL    | PK                    |
| email         | VARCHAR(255) | UNIQUE, NOT NULL      |
| password      | VARCHAR(255) | NOT NULL              |
| full_name     | VARCHAR(255) | NOT NULL              |
| date_of_birth | DATE         | NOT NULL              |
| avatar_url    | TEXT         | NULL                  |
| role          | VARCHAR(20)  | NOT NULL              |
| active        | BOOLEAN      | NOT NULL DEFAULT TRUE |
| created_at    | TIMESTAMP    | NOT NULL              |
| updated_at    | TIMESTAMP    | NOT NULL              |

### Role Values

```text
ADMIN
TEACHER
STUDENT
```

---

# Classrooms

Stores classroom information.

## Table: classrooms

| Column              | Type         | Constraints   |
| ------------------- | ------------ | ------------- |
| id                  | BIGSERIAL    | PK            |
| name                | VARCHAR(255) | NOT NULL      |
| description         | TEXT         | NULL          |
| thumbnail_url       | TEXT         | NULL          |
| teacher_id          | BIGINT       | FK → users.id |
| total_sessions      | INTEGER      | NOT NULL      |
| max_students        | INTEGER      | NOT NULL      |
| enrollment_deadline | DATE         | NULL          |
| archived            | BOOLEAN      | DEFAULT FALSE |
| created_at          | TIMESTAMP    | NOT NULL      |
| updated_at          | TIMESTAMP    | NOT NULL      |

### Relationships

* One teacher can teach many classrooms.
* One classroom has one teacher.

---

# Classroom Sessions

Stores individual teaching sessions.

## Table: class_sessions

| Column         | Type      | Constraints        |
| -------------- | --------- | ------------------ |
| id             | BIGSERIAL | PK                 |
| classroom_id   | BIGINT    | FK → classrooms.id |
| session_number | INTEGER   | NOT NULL           |
| session_date   | DATE      | NOT NULL           |
| start_time     | TIME      | NOT NULL           |
| end_time       | TIME      | NOT NULL           |
| created_at     | TIMESTAMP | NOT NULL           |
| updated_at     | TIMESTAMP | NOT NULL           |

### Constraints

Unique:

```text
(classroom_id, session_number)
```

---

# Enrollment Requests

Stores student requests awaiting teacher approval.

## Table: enrollment_requests

| Column           | Type        | Constraints        |
| ---------------- | ----------- | ------------------ |
| id               | BIGSERIAL   | PK                 |
| student_id       | BIGINT      | FK → users.id      |
| classroom_id     | BIGINT      | FK → classrooms.id |
| status           | VARCHAR(20) | NOT NULL           |
| rejection_reason | TEXT        | NULL               |
| rejected_at      | TIMESTAMP   | NULL               |
| created_at       | TIMESTAMP   | NOT NULL           |
| updated_at       | TIMESTAMP   | NOT NULL           |

### Status Values

```text
PENDING
APPROVED
REJECTED
```

---

# Enrollments

Stores approved classroom memberships.

## Table: enrollments

| Column       | Type      | Constraints        |
| ------------ | --------- | ------------------ |
| id           | BIGSERIAL | PK                 |
| student_id   | BIGINT    | FK → users.id      |
| classroom_id | BIGINT    | FK → classrooms.id |
| created_at   | TIMESTAMP | NOT NULL           |
| updated_at   | TIMESTAMP | NOT NULL           |

### Constraints

Unique:

```text
(student_id, classroom_id)
```

A student can only be enrolled once in a classroom.

---

# Attendance

Stores attendance for a specific classroom session.

## Table: attendance

| Column           | Type        | Constraints            |
| ---------------- | ----------- | ---------------------- |
| id               | BIGSERIAL   | PK                     |
| student_id       | BIGINT      | FK → users.id          |
| class_session_id | BIGINT      | FK → class_sessions.id |
| status           | VARCHAR(20) | NOT NULL               |
| created_at       | TIMESTAMP   | NOT NULL               |
| updated_at       | TIMESTAMP   | NOT NULL               |

### Status Values

```text
PRESENT
LATE
ABSENT
EXCUSED
```

### Constraints

Unique:

```text
(student_id, class_session_id)
```

A student may only have one attendance record per session.

---

# Grade Components

Defines grading structure for a classroom.

## Table: grade_components

| Column         | Type         | Constraints        |
| -------------- | ------------ | ------------------ |
| id             | BIGSERIAL    | PK                 |
| classroom_id   | BIGINT       | FK → classrooms.id |
| component_name | VARCHAR(255) | NOT NULL           |
| weight         | DECIMAL(5,2) | NOT NULL           |
| created_at     | TIMESTAMP    | NOT NULL           |
| updated_at     | TIMESTAMP    | NOT NULL           |

### Example

```text
Assignment 1  -> 20%
Midterm       -> 30%
Final Exam    -> 50%
```

---

# Grades

Stores student grades.

## Table: grades

| Column             | Type         | Constraints              |
| ------------------ | ------------ | ------------------------ |
| id                 | BIGSERIAL    | PK                       |
| student_id         | BIGINT       | FK → users.id            |
| grade_component_id | BIGINT       | FK → grade_components.id |
| score              | DECIMAL(5,2) | NOT NULL                 |
| comment            | TEXT         | NULL                     |
| created_at         | TIMESTAMP    | NOT NULL                 |
| updated_at         | TIMESTAMP    | NOT NULL                 |

### Constraints

Unique:

```text
(student_id, grade_component_id)
```

A student can only have one grade per component.

---

# Recommended Indexes

## Users

```text
email
role
active
```

---

## Classrooms

```text
teacher_id
archived
enrollment_deadline
```

---

## Enrollment Requests

```text
student_id
classroom_id
status
```

---

## Enrollments

```text
student_id
classroom_id
```

---

## Attendance

```text
student_id
class_session_id
```

---

## Grades

```text
student_id
grade_component_id
```

---

# Business Rules

## Classroom

* Classroom capacity cannot exceed max_students.
* Archived classrooms cannot accept enrollments.
* Archived classrooms remain readable.

---

## Enrollment

* Students cannot enroll twice in the same classroom.
* Enrollment deadline must be respected.
* Rejected students must wait for cooldown expiration.

---

## Attendance

* Attendance is linked to a specific classroom session.
* Attendance can only be recorded once per student per session.
* Attendance may only be modified on the session date.

---

## Grades

* Grade component weights within a classroom must total 100%.
* Grades belong to grade components.
* Final grades are calculated dynamically and are not stored.
