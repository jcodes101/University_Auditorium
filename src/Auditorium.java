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
    
}