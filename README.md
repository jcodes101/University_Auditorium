# Auditorium Seat Reservation System

## Project Overview

For this project, I created a Java program that allows students to reserve seats for a scheduled meeting. The program keeps track of each student's information, assigns available seats, and allows students to cancel their reservations if needed.

The auditorium is set up with 3 rows and 5 columns, which gives it a total of 15 seats. I used this smaller setup to demonstrate how the reservation system works.

## Features

- Reserve a seat for a student.
- Automatically assign the next available seat.
- Keep track of student names and student IDs.
- View the current seating arrangement.
- Check how many seats are still available.
- Cancel an existing reservation.
- Make cancelled seats available for other students.
- Handle situations where all seats have been reserved using a custom exception.

---

## Classes and Their Purpose

**Main.java**

This is where the program starts. It contains the main menu and allows users to choose what they want to do, such as making a reservation, cancelling a reservation, or checking the seating arrangement.

**Student.java**

This class keeps track of each student's information, including their first name, last name, student ID, and the seat they have reserved.

**Auditorium.java**

This class handles most of the reservation process. It keeps track of which seats are available, assigns seats to students, checks if the auditorium is full, and handles cancellations.

**NoSeatAvailable.java**

This is my custom exception class. It gets called when a student tries to reserve a seat but all the seats have already been taken. It also displays the meeting date and time.

**TestAuditorium.java**

This file contains the tests I created to make sure the reservation system works correctly. I tested seat availability, reservations, cancellations, and what happens when the auditorium is full.

## How to Compile and Run

Make sure Java is installed before running the program.

Open PowerShell in the project folder and compile the Java files using:

```powershell
javac -d out src/*.java
```

After compiling, start the program with:

```powershell
java -cp out Main
```

## Running the Tests

To compile both the source files and the test file, run:

```powershell
javac -d out src/*.java tests/*.java
```

Then run the tests using:

```powershell
java -cp out TestAuditorium
```

## Testing Results

I created six tests to check the different parts of the program:

1. Checking the number of available seats when the program starts.
2. Making a successful seat reservation.
3. Reserving all 15 seats in the auditorium.
4. Making sure the NoSeatAvailable exception works when someone tries to reserve a 16th seat.
5. Cancelling an existing reservation.
6. Making sure a cancelled seat can be reserved again.

All six tests passed when I ran the test program.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Two-dimensional arrays
- Exception handling
- HashMap
- PowerShell

## Project Configuration

- Auditorium Capacity: 15 seats
- Number of Rows: 3
- Number of Columns: 5
- Program Interface: Console-based
