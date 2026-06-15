# Requirements Specification

## 1. Project Overview

### Purpose

The Classroom Management System is a web application that allows administrators, teachers, and students to manage classrooms, enrollments, attendance, and grades.

### Goals

* Centralize classroom management
* Simplify student enrollment workflows
* Track attendance per classroom session
* Manage student grades using configurable grading components
* Provide secure role-based access control

---

# 2. User Roles

## Administrator

Responsibilities:

* Manage users
* Create teacher accounts
* Manage classrooms
* Assign teachers to classrooms
* Define grade components
* Archive classrooms

---

## Teacher

Responsibilities:

* Manage assigned classrooms
* Approve or reject enrollment requests
* Record attendance
* Record grades
* View enrolled students

---

## Student

Responsibilities:

* Register account
* Browse available classrooms
* Request enrollment
* View attendance records
* View grades
* Manage personal profile

---

# 3. Functional Requirements

## FR-1 Authentication

### FR-1.1 User Registration

The system shall allow students to register using:

* Email
* Password
* Full name
* Date of birth

### FR-1.2 Login

The system shall authenticate users using email and password.

### FR-1.3 Logout

The system shall allow authenticated users to logout.

### FR-1.4 Token Refresh

The system shall issue a new access token using a valid refresh token.

### FR-1.5 Password Change

The system shall allow authenticated users to change their password.

---

## FR-2 User Management

### FR-2.1 Create Teacher Account

The system shall allow administrators to create teacher accounts.

### FR-2.2 View Users

The system shall allow administrators to view all users.

### FR-2.3 Update User

The system shall allow administrators to update user information.

### FR-2.4 Activate/Deactivate User

The system shall allow administrators to activate or deactivate user accounts.

### FR-2.5 Profile Management

The system shall allow users to view and update their own profile information.

---

## FR-3 Classroom Management

### FR-3.1 Create Classroom

The system shall allow administrators to create classrooms.

### FR-3.2 Update Classroom

The system shall allow administrators to update classroom information.

### FR-3.3 Archive Classroom

The system shall allow administrators to archive classrooms.

### FR-3.4 Assign Teacher

The system shall allow administrators to assign a teacher to a classroom.

### FR-3.5 View Assigned Classrooms

The system shall allow teachers to view classrooms assigned to them.

### FR-3.6 View Enrolled Classrooms

The system shall allow students to view classrooms in which they are enrolled.

### FR-3.7 Browse Available Classrooms

The system shall allow students to browse classrooms available for enrollment.

---

## FR-4 Classroom Session Management

### FR-4.1 Create Sessions

The system shall allow administrators to create classroom sessions.

### FR-4.2 View Sessions

The system shall allow users to view classroom sessions relevant to their role.

### FR-4.3 Session Validation

The system shall ensure session numbers are unique within a classroom.

---

## FR-5 Enrollment Management

### FR-5.1 Submit Enrollment Request

The system shall allow students to submit enrollment requests.

### FR-5.2 View Enrollment Requests

The system shall allow students to view their enrollment request history.

### FR-5.3 Review Requests

The system shall allow teachers to review enrollment requests.

### FR-5.4 Approve Request

The system shall allow teachers to approve enrollment requests.

### FR-5.5 Reject Request

The system shall allow teachers to reject enrollment requests.

### FR-5.6 Enrollment Capacity

The system shall prevent enrollments beyond classroom capacity.

### FR-5.7 Enrollment Deadline

The system shall prevent enrollment after the enrollment deadline.

### FR-5.8 Rejection Cooldown

The system shall prevent students from immediately reapplying after rejection.

---

## FR-6 Attendance Management

### FR-6.1 Record Attendance

The system shall allow teachers to record attendance for classroom sessions.

### FR-6.2 Update Attendance

The system shall allow teachers to update attendance records on the session date.

### FR-6.3 View Attendance

The system shall allow students to view their attendance records.

### FR-6.4 Attendance Status

The system shall support:

* PRESENT
* LATE
* ABSENT
* EXCUSED

---

## FR-7 Grade Management

### FR-7.1 Create Grade Components

The system shall allow administrators to define grading components.

### FR-7.2 Update Grade Components

The system shall allow administrators to update grading components.

### FR-7.3 Delete Grade Components

The system shall allow administrators to delete grading components when no grades exist.

### FR-7.4 Record Grades

The system shall allow teachers to record grades.

### FR-7.5 Update Grades

The system shall allow teachers to update grades.

### FR-7.6 View Grades

The system shall allow students to view their grades.

### FR-7.7 Calculate Final Grade

The system shall automatically calculate final grades using component weights.

---

## FR-8 Authorization

### FR-8.1 Role-Based Access Control

The system shall restrict functionality based on user roles.

### FR-8.2 Resource Ownership

The system shall ensure users can only access resources they are authorized to view.

---

# 4. Non-Functional Requirements

## NFR-1 Security

* Passwords shall be stored using BCrypt hashing.
* Authentication shall use JWT.
* Refresh tokens shall be securely stored.
* Sensitive information shall never be exposed.

---

## NFR-2 Performance

* API responses should complete within 2 seconds under normal load.
* Pagination shall be used for large datasets.
* Frequently accessed data may be cached.

---

## NFR-3 Reliability

* The system shall prevent data corruption.
* Business rules shall be validated before persistence.
* Audit information shall be retained.

---

## NFR-4 Usability

* The user interface shall be responsive.
* Validation errors shall provide meaningful messages.
* Navigation shall be role-specific.

---

## NFR-5 Maintainability

* The system shall follow layered architecture.
* Business logic shall be separated from controllers.
* Code shall follow established coding standards.

---

# 5. Assumptions and Constraints

## Assumptions

* Each classroom has one assigned teacher.
* Students may enroll in multiple classrooms.
* Attendance is tracked per classroom session.
* Grades are calculated from weighted grade components.

## Constraints

* Access tokens expire after 15 minutes.
* Refresh tokens expire after 7 days.
* Attendance can only be modified on the session date.
* Classroom capacity cannot be exceeded.
