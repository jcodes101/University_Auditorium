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
}