public class Auditorium {

    private String meetingDate;
    private String meetingTime;

    private int rows;
    private int columns;

    // this is a array of seats, 
    // and each position stores a seat, 
    // if the position is null that means 
    // the seat is available and free
    private Student[][] seats;

    // this constructor is what initializes the entire audtorium/meeting
    public Auditorium(String meetingDate, String meetingTime, int rows, int columns) {

        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException(
                "Rows and columns must be greater than 0"
            )
        }

        this.meetingDate = meetingDate;
        this.meetingTime = meetingTime;
        this.rows = rows;
        this.columns = columns;

        seats = new Student[rows][columns];
    }

    // this checks whether every seat has been reserved
    public boolean audtoriumFull() {

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                if (seats[row][column] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    // this reserves the first available seat for a student
    public String StudentReserveSeat(Student student)
            throws NoSeatAvailable {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }

        if (student.hasReservation()) {
            throw new IllegalArgumentException("This student already has a reservation.");
        }

        // if no seats remain, throw the custom exception
        if (auditoriumFull()) {
            throw new NoSeatAvailable(meetingDate, meetingTime);
        }

        // this is a block of code to search for the first available seat
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                if (seats[row][column] == null) {

                    // this assigns the student to this seat
                    seats[row][column] = student;

                    // and store the seat number in the Student object
                    student.setReservation(row + 1, column + 1);

                    return "Reservation Successful!"
                            + "\nStudent: " + student.getFullName()
                            + "\nStudent ID: " + student.getStudentId()
                            + "\nMeeting Date: " + meetingDate
                            + "\nMeeting Time: " + meetingTime
                            + "\nSeat Number: Row " + (row + 1)
                            + ", Column " + (column + 1);
                }
            }
        }

        // and this is a safety check in case no available seat was found
        throw new NoSeatAvailable(meetingDate, meetingTime);
    }

    
    // this cancels a student's reservation
    public boolean cancelReservation(Student student) {

        if (student == null || !student.hasReservation()) {
            return false;
        }

        int row = student.getReservedRow() - 1;
        int column = student.getReservedColumn() - 1;

        // this is to make sure the student's seat is valid and belongs to them
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            return false;
        }

        if (seats[row][column] == student) {

            // and this makes the seat available again
            seats[row][column] = null;

            // clear the student's reservation information
            student.cancelReservation();

            return true;
        }

        return false;
    }

    // this if for returning the number of seats currently available
    public int getAvailableSeatCount() {

        int availableSeats = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                if (seats[row][column] == null) {
                    availableSeats++;
                }
            }
        }

        return availableSeats;
    }

    // display of info of the current seating arrangement
    public void displaySeating() {

        System.out.println("\n===== AUDITORIUM SEATING =====");
        System.out.println("Meeting Date: " + meetingDate);
        System.out.println("Meeting Time: " + meetingTime);

        System.out.println("\nLegend: [X] = Reserved | [ ] = Available\n");

        for (int row = 0; row < rows; row++) {

            System.out.print("Row " + (row + 1) + ": ");

            for (int column = 0; column < columns; column++) {

                if (seats[row][column] == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[X] ");
                }
            }

            System.out.println();
        }

        System.out.println("\nAvailable Seats: " + getAvailableSeatCount());

        System.out.println("Reserved Seats: " + (rows * columns - getAvailableSeatCount()));
    }

    // getters
    public String getMeetingDate() {
        return meetingDate;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}