Start with these entities:

```
User
Class
EnrollmentRequest
Enrollment
Attendance
Grade
```

Relationship overview:

```
User
 ├── Admin
 ├── Teacher
 └── Student

Class
 └── Teacher

EnrollmentRequest
 ├── Student
 └── Class

Enrollment
 ├── Student
 └── Class

Attendance
 ├── Student
 └── Class

Grade
 ├── Student
 └── Class
 ```

Initial tables:

```
users
------

id
email
password_hash
full_name
role
active
created_at

classes
--------

id
name
description
teacher_id
created_at

enrollment_requests
-------------------

id
student_id
class_id
status
created_at

enrollments
-----------

id
student_id
class_id
created_at

attendance
----------

id
student_id
class_id
attendance_date
status

grades
------

id
student_id
class_id
score
comment
created_at
```
