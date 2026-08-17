# Appointment Service

A Java application developed for my **CS 320: Software Test, Automation, and Quality Assurance** course. The project demonstrates object-oriented programming, input validation, service-layer operations, and unit testing with JUnit.

## Project Overview

The Appointment Service manages appointment records using in-memory data structures. It allows appointments to be created, updated, and deleted while enforcing specific requirements for appointment IDs, dates, and descriptions.

The project does not use a database or user interface. Its main focus is validating application requirements through automated unit testing.

## Features

* Create new appointments
* Store appointments using unique appointment IDs
* Update appointment descriptions
* Update appointment dates
* Delete appointments by ID
* Prevent duplicate appointment IDs
* Validate appointment information
* Automated testing using JUnit 5

## Appointment Requirements

Each appointment must meet the following requirements:

* Appointment ID cannot be null
* Appointment ID cannot exceed 10 characters
* Appointment IDs must be unique
* Appointment date cannot be null
* Appointment date cannot be in the past
* Description cannot be null
* Description cannot exceed 50 characters

## Project Structure

```text
AppointmentService/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── appointment/
│   │           ├── Appointment.java
│   │           └── AppointmentService.java
│   └── test/
│       └── java/
│           └── appointment/
│               ├── AppointmentTest.java
│               └── AppointmentServiceTest.java
└── .gitignore
```

## Technologies Used

* Java
* JDK 21
* Maven
* JUnit 5
* IntelliJ IDEA
* Git
* GitHub

## Testing

JUnit tests are included to verify that the `Appointment` and `AppointmentService` classes meet the required specifications.

Tests cover areas such as:

* Valid appointment creation
* Invalid appointment IDs
* Invalid appointment dates
* Invalid descriptions
* Adding appointments
* Preventing duplicate IDs
* Updating appointments
* Deleting appointments

## Running the Tests

Make sure Java and Maven are installed.

From the project directory, run:

```bash
mvn test
```

Maven will compile the project and execute the JUnit tests.

## What I Learned

This project helped me practice writing maintainable Java code and creating unit tests based on software requirements. It also reinforced the importance of input validation, test coverage, and verifying that software behaves correctly under both valid and invalid conditions.

## Author

**Ramon Baez**

Computer Science Student
Software Development
