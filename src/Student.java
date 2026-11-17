// this is a student class that will contain 
// all students identification info and their own reservation details

public class Student {

    private String firstName;
    private String lastName;
    private String studentId;

    private int reservedRow
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
}