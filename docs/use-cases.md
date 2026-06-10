# Use Cases

## UC-01 Student Registration

Actor: Student

Flow:

1. Student opens registration page
2. Student enters information
3. System validates data
4. System creates account

Result:

Student account created

---

## UC-02 Login

Actor:

* Admin
* Teacher
* Student

Flow:

1. User enters credentials
2. System validates credentials
3. JWT token generated

Result:

Authenticated session

---

## UC-03 Create Class

Actor: Admin

Flow:

1. Admin creates class
2. System stores class

Result:

Class available

---

## UC-04 Assign Teacher

Actor: Admin

Flow:

1. Admin selects class
2. Admin selects teacher
3. System assigns teacher

Result:

Teacher linked to class

---

## UC-05 Enrollment Request

Actor: Student

Flow:

1. Student requests enrollment
2. Request status = PENDING

Result:

Teacher can review request

---

## UC-06 Approve Enrollment

Actor: Teacher

Flow:

1. Teacher reviews request
2. Teacher approves request
3. Student added to class

Result:

Enrollment completed

---

## UC-07 Record Attendance

Actor: Teacher

Flow:

1. Teacher selects class session
2. Teacher marks attendance
3. System stores attendance

Result:

Attendance saved

---

## UC-08 Record Grade

Actor: Teacher

Flow:

1. Teacher selects student
2. Teacher enters score
3. System stores grade

Result:

Grade updated
