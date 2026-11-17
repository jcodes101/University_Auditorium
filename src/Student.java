// this is a student class that will contain 
// all students identification info and their own reservation details

public class Student {

    private String firstName;
    private String lastName;
    private String studentId;

    private int reservedRow;
    private int reservedColumn;

    // this constructor initializes student info
    public Student(String firstName, String lastName, String student) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;

        // the purpose of the -1 here is because the Student does not current have their own seat.
        this.reservedRow = -1;
        this.reservedColumn = -1;
    }

    // = getters & setters =

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getReservedRow() {
        return reservedRow;
    }

    public int getReservedColumn() {
        return reservedColumn;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    // this is a check to see if the student has a reservation already
    public boolean hasReservation() {
        return reservedRow != -1 && reservedColumn != -1;
    }

    // and then this updates that specific student's assigned seat
    public void setReservation(int row, int column) {
        this.reservedRow = row;
        this.reservedColumn = column;
    }

    // this cancels teh students reservation
    public void cancelReservation() {
        this.reservedRow = -1;
        this.reservedColumn = -1;
    }

    // ^ doing things this way both the Student & Auditorium class 
    // will get updated when a reseveration happens

}
