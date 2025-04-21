# Project Description

## 1. Basic Description

This is an ***individual project for one student***.

## 2.  Learning Objectives

An individual project will be assigned to the students with predefined deliverables where students need to adhere to the rules and need to show their progression during various phases
of the project to the teachers. The students will be asked to design, implement, and deploy an application that highlights:
* Implementing class hierarchy that incorporates diverse variables and equipped with methods of different signatures.
* Integrating interfaces featuring a minimum of one-member method.
* Demonstrating polymorphism method overloading and method overriding.
* Leveraging diverse data structures (Array, List, Set, Queue, or Map) to efficiently store and process program data.
* Handling exceptions and use File systems for data I/O.
* Utilize Stream processing (with Lambda expressions or method reference).
* Collaborate through a Git repository for version control.
* Follow a Test-Driven Development (TDD) approach.

## 3. Design Requirements

The project MUST contain

* Appropriate data structures that best fit the data.
* At least two hierarchies of classes, each one has two layers (such as `User`, `Teacher`, `Student`) is required for the project.
* At least one user-defined interface with at least one abstract method in it.
* At least one runtime-polymorphism
* At least one textIO (reading and writing)
* At least one class implement `Comparable`, and at least one `Comparator` class.
* Unit testing for user defined methods (if applicable)

## 5. Steps to follow

1. Design the project and create UML class diagrams.
2. Create classes with all fields and methods (headers only).
3. Write JavaDoc (documentation) for all user-defined methods
5. Write test class(es) using JUnit to test methods.
6. Complete `//TODO` comment in each method to split the work
7. Create Unit testing test cases for each user-defined method
8. Write the body of methods and

## 6. Project Deliverables

### 6.1 Deliverable 1 - Project Description:

Submit a project idea, addressing the following points:
* Scenario: Explain the scenario under which your project will operate.
* Design Paradigm: List the functionalities you plan to demonstrate.
* Expected Output: Describe the expected results and the actions the user can perform with your application.
* Specify the hierarchies (at least two) of the project
* Specify the what the interface is and why do you need it in your project
* Specify which methods apply runtime-polymorphism
* Specify in which class and for what purpous textIO will be used.
* Specify in which class(es) `Comparable` will be implemented, and what class(es) need `Comparator`
* A class diagram to show the classes and interfaces of the project and their relationship.
* Specify which part (class, interface and methods) will be implemented for deliverable 2 (50%)
* Git Repository: Initialize a Maven project with valid `.gitignore`, and a `README.md` file for a project description. Create a `doc` folder which contains Deliverable 1 PDF.

### 6.2 Deliverable 2 - 50% Checkpoint:

Submit the source code as a `.zip` file. The application structure must be in place, with:
* Implementation of 50% of the project proposed in deliverable 1.
* All usre-defined methods (including the unfinished ones) must contains Java doc and Junit testing.
* Updated Git repository (Git repo will be evaluated).

### 6.3 Deliverable 3 - Final Submission:

Submit the complete application, including:
* Project source code (as a `.zip` file) with 100% implementation.
* Updated Git repository (Git repo will be evaluated).

### 6.4 Project Report:

Submit a project report consisting of:
* Cover page with your name, project title, and course name.
* Outline/Table of Contents.
* Project Description (same as Deliverable 1).
* Program Features and Screenshots (showing how the project meets the requirements, with output and execution examples).
* Challenges (any unimplemented features or issues faced during development).
* Learning Outcomes (what you gained from the project).
* Oral presentation (The project will be demoed in class, about 5 mins per each person)
* The report MUST be uploaded to both Lea and Git repository (in the `doc` folder)

## 7. Submission Requirements

1. Deliverable 1 and 4 should be submitted as PDF files via the Lea system.
2.	Deliverables 2 and 3 should be uploaded to the Git repository.
3.	Deliverables 2 and 3 must also be zipped and submitted via Lea.

## 8. Grading Criteria

The following criteria will be used to evaluate the project:

The project will be evaluated based on the following:

* Functionality (accuracy of output, performance, etc.)
* Robustness (handling edge cases, exceptions, and invalid inputs)
* Adherence to project specifications
* Appropriate use of data structures and the Collections API
* Correct application of design patterns, I18N, MVC, Lambda expressions, and OOP principles (e.g., information hiding, polymorphism)
* Code documentation
* Thorough testing
* Quality of presentation and completeness of output
* Appropriate use of Git for commits and collaboration
* A recentable code testing coverage
* Git repository is appropriated used.

## 9. Example Project Ideas

Here are a few sample ideas for your final project. Feel free to be creative and add unique features to make your project more engaging.

### 9.1 Airline Reservation System

* Users can search, reserve, and book airline tickets.
* Booked tickets can be managed (e.g., changed or deleted).
* Admins handle booking requests and confirmation.
* Admins maintain passenger records and generate transaction reports.

### 9.2 Course Management System

* Administrator Module: Manages administrative functions like creating student and instructor accounts, curriculum setup, employee management, etc.
* Student Module: Students can log in to view coursework, submit assignments, and receive feedback.
* Instructor Module: Instructors can log in to check assignments, communicate with students, and provide guidance.

### 9.3 Library Management System

* Librarians can maintain book records.
* Students can search for books and reserve them.
* The system tracks borrowed, issued, and returned books.

### 9.4 Online Banking System

* Customers can view account details, such as account type, balance, loan interest rates, and transaction history.
* Customers can review credit and debit transactions, including deposit and withdrawal amounts with corresponding dates.
* Managers maintain customer records.

### 9.5 Online Medical Management System

* Patients can book appointments with doctors, receive e-prescriptions, and view medical records and lab reports.
* Doctors can offer healthcare suggestions and consult patient records.
* The system can also connect users with blood and eye donors.*

### 9.6 Online Quiz Management System

* A discussion platform with quizzes on a wide range of topics.
* Users can practice quizzes before taking the actual test.
* Admins manage grades and user accounts.

### 9.7 Food Ordering System

* Users can search for, order, and pay for food.
* Admins process orders and manage requests.
* An optional driver role (e.g., Uber Eats driver) can accept and deliver food orders.

## 10. Detailed Example: Library Management System

### 10.1 Introduction

The Limited Library Management System (LLMS) is a small-scale application where librarians can add books to the catalog, issue and return books, view the catalog, and see a list of issued books. To issue a book, the librarian verifies the student’s roll number and checks the book’s availability. After issuing, the book’s information is updated in the database. Books can be searched by title, author, or publication year.

### 10.2 Functional Requirements
The system provides different services based on the user type (Student or Librarian).

1. Librarian
    1. Add a book to the catalog
    2. Issue a book
    3. Return a book
    4. View the catalog (issued and available books)
    5. View the list of issued books and the students who borrowed them.
2. Student
    1. Search books by title
    2. Search by author.
    3. Search by publication year.
    4. View the catalogue (issued and available books)
    5. Borrow a book
    6. Return a book

### 10.3 Implementation Details

1. Methods specifications
    1. `addBook(Book)`: Adds a new book to the catalog by creating an entry in the Books table, setting the `“Issued”` attribute to zero, and recording the current date as the addedDate.
    2. `issueBook(b: Book, s: Student)` and `borrow(b: Book)`: These methods are responsible for issuing a book to a student. First, student details are verified. If the book is available (i.e., the `“Issued”` value is greater than `0` in the Books table), the number of available copies (Quantity) is decreased by one, and the number of issued copies (Issued) is increased by one. A new record is then created in the IssuedBooks table. Both methods return true if the book is successfully issued.
    3. `returnBook(b: Book, s: Student)` and `return(b: Book)`: These methods handle the return of books. After verifying the student’s ID, the number of available copies is increased by one, and the number of issued copies is decreased by one. The corresponding entry in the IssuedBooks table is removed. Both methods return true if the book is successfully returned.
    4. `viewCatalog()`: Retrieves and returns a map of all books from the Books table. The map’s key is the book’s serial number (SN), and all books are sorted by `sn`.
    5. `viewIssuedBooks()`: Fetches all data from the IssuedBooks table and returns it as a sorted list by `sn`.
    6. `Search` Methods: These methods retrieve records from the Books table that meet specific search criteria, such as by title, author, or year of publication. The results are returned as a sorted list by `sn`.
