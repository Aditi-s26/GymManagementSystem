# Gym Membership Management System

## 1. Project Overview

The Gym Membership Management System is a console-based Java application developed to manage gym members, membership plans, trainers, and attendance records.

The application provides a menu-driven interface that allows users to perform common gym management operations.

## 2. Technologies Used

- Java 21
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Data Structures and Algorithms (DSA)
- Visual Studio Code
- Git and GitHub

## 3. Main Features

1. Register New Member
2. View All Members
3. View Membership Plans
4. Select Membership Plan
5. Renew Membership
6. Mark Attendance
7. View Attendance
8. Add Trainer
9. Allot Trainer
10. View Trainers
11. Search Member

## 4. Membership Plans

| Plan | Price | Duration |
|---|---:|---:|
| Monthly | ₹1,000 | 30 Days |
| Quarterly | ₹2,500 | 90 Days |
| Half Yearly | ₹4,500 | 180 Days |
| Yearly | ₹8,000 | 365 Days |

## 5. OOP Concepts

- **Encapsulation:** Private data members with getters and setters.
- **Inheritance:** Member and Trainer inherit from the abstract GymRecord class.
- **Polymorphism:** The displayDetails() method is overridden in different model classes.
- **Abstraction:** GymRecord defines a common abstract method for its subclasses.

## 6. Exception Handling

The application uses custom exceptions:

- MemberNotFoundException
- InvalidMembershipPlanException

Try-catch blocks handle errors such as invalid member IDs and membership plan selections.

## 7. Data Structures

- **ArrayList:** Stores member and trainer information.
- **Custom Queue:** A manually implemented linked-list-based queue stores attendance records.

## 8. Project Structure

```text
GymManagementSystem/
│
├── src/
│   ├── GymManagementSystem.java
│   ├── model/
│   │   ├── GymRecord.java
│   │   ├── Member.java
│   │   ├── Trainer.java
│   │   └── Attendance.java
│   ├── data/
│   │   ├── GymDataStore.java
│   │   ├── MemberManager.java
│   │   ├── MembershipManager.java
│   │   ├── AttendanceManager.java
│   │   └── TrainerManager.java
│   ├── exception/
│   │   ├── MemberNotFoundException.java
│   │   └── InvalidMembershipPlanException.java
│   ├── util/
│   │   └── InputValidator.java
│   └── ds/
│       └── AttendanceQueue.java
│
├── .gitignore
└── README.md
```

## 9. How to Compile and Run

Open the terminal in the project root directory.

Compile the application:

```powershell
javac -d out -sourcepath src src\GymManagementSystem.java
```

Run the application:

```powershell
java -cp out GymManagementSystem
```

## 10. Data Storage

The application currently stores information using in-memory collections such as ArrayList and the custom attendance queue.

Data is available