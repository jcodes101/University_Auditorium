/*
 this is a custom exception class, and this means it
 is able to handle something unexpected so that this
 program does not crash.

 so in this case an unexpected situation is a student
 attempting to reserve a seat when all the seats are taken.
*/

// - this class extends exception to make a custom exception,
// - super() passes the custom message to the built in exception class 
public class NoSeatAvailable extends Exception {

    public NoSeatAvailable(String meetingDate, String meetingTime) {
        super("There Are No Seats Available\n"
        + "Meeting Date: " + meetingDate + "\n"
        + "Meeting Time: " + meetingTime);
    }
}

