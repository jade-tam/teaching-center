# Use Cases

## 1. Actors

### Administrator

The administrator manages users, classrooms, teachers, and grading structures.

### Teacher

The teacher manages enrollment requests, attendance, and grades for assigned classrooms.

### Student

The student enrolls in classrooms, views attendance records, and views grades.

---

# 2. Use Case Diagram Overview

## Administrator Use Cases

* Login
* Create Teacher Account
* View Users
* Update User
* Activate/Deactivate User
* Create Classroom
* Update Classroom
* Archive Classroom
* Assign Teacher
* Create Classroom Sessions
* Create Grade Components
* Update Grade Components
* Delete Grade Components

## Teacher Use Cases

* Login
* View Assigned Classrooms
* View Enrollment Requests
* Approve Enrollment Request
* Reject Enrollment Request
* Record Attendance
* Update Attendance
* Record Grade
* Update Grade
* View Classroom Grades

## Student Use Cases

* Register Account
* Login
* Update Profile
* Change Password
* Browse Classrooms
* Submit Enrollment Request
* View Enrollment Requests
* View Enrolled Classrooms
* View Attendance
* View Grades

---

# 3. Detailed Use Cases

---

## UC-01 Register Student Account

### Primary Actor

Student

### Preconditions

* User does not already have an account.

### Main Flow

1. Student opens registration page.
2. Student enters required information.
3. Student submits registration form.
4. System validates input.
5. System creates account.
6. System returns authentication tokens.

### Postconditions

* Student account is created.
* Student is authenticated.

---

## UC-02 Login

### Primary Actor

Administrator, Teacher, Student

### Preconditions

* User account exists.
* User account is active.

### Main Flow

1. User enters email and password.
2. System validates credentials.
3. System generates access token.
4. System generates refresh token.
5. User is logged in.

### Postconditions

* User gains access to authorized features.

---

## UC-03 Create Classroom

### Primary Actor

Administrator

### Preconditions

* Administrator is authenticated.

### Main Flow

1. Administrator opens classroom management page.
2. Administrator enters classroom details.
3. Administrator submits form.
4. System validates data.
5. System creates classroom.

### Postconditions

* New classroom exists in the system.

---

## UC-04 Assign Teacher to Classroom

### Primary Actor

Administrator

### Preconditions

* Classroom exists.
* Teacher account exists.

### Main Flow

1. Administrator selects classroom.
2. Administrator selects teacher.
3. Administrator confirms assignment.
4. System validates teacher role.
5. System assigns teacher.

### Postconditions

* Classroom is assigned to the selected teacher.

---

## UC-05 Create Classroom Sessions

### Primary Actor

Administrator

### Preconditions

* Classroom exists.

### Main Flow

1. Administrator selects classroom.
2. Administrator enters session schedule.
3. Administrator submits sessions.
4. System validates session information.
5. System creates session records.

### Postconditions

* Classroom sessions are available.

---

## UC-06 Submit Enrollment Request

### Primary Actor

Student

### Preconditions

* Student is authenticated.
* Classroom is open for enrollment.

### Main Flow

1. Student views available classrooms.
2. Student selects a classroom.
3. Student submits enrollment request.
4. System validates business rules.
5. System creates enrollment request.

### Alternative Flows

* Enrollment deadline has passed.
* Classroom is full.
* Student is in cooldown period.
* Student already enrolled.

### Postconditions

* Enrollment request is created with status PENDING.

---

## UC-07 Approve Enrollment Request

### Primary Actor

Teacher

### Preconditions

* Enrollment request exists.
* Request status is PENDING.

### Main Flow

1. Teacher views pending requests.
2. Teacher selects a request.
3. Teacher approves request.
4. System validates classroom capacity.
5. System creates enrollment record.
6. System updates request status.

### Postconditions

* Student becomes enrolled in the classroom.

---

## UC-08 Reject Enrollment Request

### Primary Actor

Teacher

### Preconditions

* Enrollment request exists.
* Request status is PENDING.

### Main Flow

1. Teacher selects request.
2. Teacher enters rejection reason.
3. Teacher confirms rejection.
4. System updates request status.

### Postconditions

* Request status becomes REJECTED.
* Cooldown period begins.

---

## UC-09 Record Attendance

### Primary Actor

Teacher

### Preconditions

* Teacher is assigned to classroom.
* Session date is today.

### Main Flow

1. Teacher opens attendance page.
2. Teacher selects classroom session.
3. Teacher records attendance statuses.
4. Teacher submits attendance.
5. System validates records.
6. System saves attendance data.

### Postconditions

* Attendance records are stored.

---

## UC-10 Update Attendance

### Primary Actor

Teacher

### Preconditions

* Attendance record exists.
* Session date is today.

### Main Flow

1. Teacher selects attendance record.
2. Teacher modifies attendance status.
3. Teacher submits changes.
4. System updates record.

### Postconditions

* Attendance record is updated.

---

## UC-11 Create Grade Components

### Primary Actor

Administrator

### Preconditions

* Classroom exists.

### Main Flow

1. Administrator opens grading setup.
2. Administrator defines grade components.
3. Administrator assigns weights.
4. System validates total weight equals 100%.
5. System saves grade components.

### Postconditions

* Classroom grading structure is available.

---

## UC-12 Record Grade

### Primary Actor

Teacher

### Preconditions

* Student is enrolled.
* Grade component exists.

### Main Flow

1. Teacher selects classroom.
2. Teacher selects student.
3. Teacher enters grade.
4. Teacher submits form.
5. System validates score.
6. System saves grade.

### Postconditions

* Grade record exists.

---

## UC-13 View Grades

### Primary Actor

Student

### Preconditions

* Student is enrolled in a classroom.

### Main Flow

1. Student opens grades page.
2. Student selects classroom.
3. System retrieves grade records.
4. System calculates final grade.
5. System displays results.

### Postconditions

* Student can view grades and final result.

---

## UC-14 View Attendance

### Primary Actor

Student

### Preconditions

* Student is enrolled in a classroom.

### Main Flow

1. Student opens attendance page.
2. Student selects classroom.
3. System retrieves attendance records.
4. System displays attendance summary.

### Postconditions

* Student can view attendance history.

---

## UC-15 Manage User Account

### Primary Actor

Administrator

### Main Flow

1. Administrator views user list.
2. Administrator selects a user.
3. Administrator updates user information.
4. System validates changes.
5. System saves updates.

### Postconditions

* User information is updated.

---

## UC-16 Archive Classroom

### Primary Actor

Administrator

### Preconditions

* Classroom exists.

### Main Flow

1. Administrator selects classroom.
2. Administrator chooses archive action.
3. System confirms action.
4. System marks classroom as archived.

### Postconditions

* Classroom is hidden from active listings.
* Historical data remains accessible.
