
public class TestAuditorium {

    public static void main(String[] args) {

        // Create a small auditorium for testing.
        Auditorium auditorium = new Auditorium(
                "November 30, 2026",
                "2:00 PM",
                3,
                5
        );

        System.out.println("===== AUDITORIUM TESTS =====");

        // TEST 1: Check the initial available seats.
        System.out.println("\nTEST 1: Initial seat availability");

        if (auditorium.getAvailableSeatCount() == 15
                && !auditorium.auditoriumFull()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        // TEST 2: Reserve the first seat.
        System.out.println("\nTEST 2: Reserve a seat");

        Student firstStudent = new Student(
                "Jadin", "Hutchinson", "950572676"
        );

        try {
            auditorium.StudentReserveSeat(firstStudent);

            if (firstStudent.hasReservation()
                    && firstStudent.getReservedRow() == 1
                    && firstStudent.getReservedColumn() == 1) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }

        } catch (NoSeatAvailable exception) {
            System.out.println("FAILED: " + exception.getMessage());
        }

        // TEST 3: Fill the remaining seats.
        System.out.println("\nTEST 3: Fill all 15 seats");

        try {
            for (int i = 2; i <= 15; i++) {

                Student student = new Student(
                        "Student",
                        String.valueOf(i),
                        "ID" + i
                );

                auditorium.StudentReserveSeat(student);
            }

            if (auditorium.auditoriumFull()
                    && auditorium.getAvailableSeatCount() == 0) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }

        } catch (NoSeatAvailable exception) {
            System.out.println("FAILED: " + exception.getMessage());
        }

        // TEST 4: Attempt to reserve a 16th seat.
        System.out.println("\nTEST 4: NoSeatAvailable exception");

        Student sixteenthStudent = new Student(
                "Extra", "Student", "ID16"
        );

        try {

            auditorium.StudentReserveSeat(sixteenthStudent);

            System.out.println("FAILED: No exception was thrown.");

        } catch (NoSeatAvailable exception) {

            if (exception.getMessage().contains("November 30, 2026")
                    && exception.getMessage().contains("2:00 PM")) {

                System.out.println("PASSED");
                System.out.println(exception.getMessage());

            } else {
                System.out.println(
                        "FAILED: Exception did not contain meeting details.");
            }
        }

        // TEST 5: Cancel a reservation.
        System.out.println("\nTEST 5: Cancel a reservation");

        if (auditorium.cancelReservation(firstStudent)
                && !firstStudent.hasReservation()
                && auditorium.getAvailableSeatCount() == 1) {

            System.out.println("PASSED");

        } else {
            System.out.println("FAILED");
        }

        // TEST 6: Reserve the newly available seat.
        System.out.println("\nTEST 6: Reuse a cancelled seat");

        Student replacementStudent = new Student(
                "Replacement", "Student", "ID17"
        );

        try {

            auditorium.StudentReserveSeat(replacementStudent);

            if (replacementStudent.getReservedRow() == 1
                    && replacementStudent.getReservedColumn() == 1
                    && auditorium.auditoriumFull()) {

                System.out.println("PASSED");

            } else {
                System.out.println("FAILED");
            }

        } catch (NoSeatAvailable exception) {
            System.out.println("FAILED: " + exception.getMessage());
        }

        System.out.println("\n===== TESTING COMPLETE =====");

    }
}
