
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // this creates the auditorium with 3 rows and 5 columns
        Auditorium auditorium = new Auditorium("November 30, 2026", "2:00 PM", 3, 5
        );

        // this stores the students using their student ID
        Map<String, Student> students = new HashMap<>();

        boolean running = true;

        System.out.println("==================================");
        System.out.println("   AUDITORIUM RESERVATION SYSTEM");
        System.out.println("==================================");
        System.out.println("Meeting Date: " + auditorium.getMeetingDate());
        System.out.println("Meeting Time: " + auditorium.getMeetingTime());

        while (running) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Reserve a Seat");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. View Seating Arrangement");
            System.out.println("4. Check Available Seats");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":

                    System.out.println("\n--- STUDENT CHECK-IN ---");

                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine().trim();

                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine().trim();

                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine().trim();

                    if (firstName.isEmpty() || lastName.isEmpty() || studentId.isEmpty()) {
                        System.out.println("Please enter all student information.");
                        break;
                    }

                    Student student = students.get(studentId);

                    // a reuse of the existing student record if it is even found
                    if (student != null) {

                        if (!student.getFirstName().equalsIgnoreCase(firstName) || !student.getLastName().equalsIgnoreCase(lastName)) {

                            System.out.println("That student ID is already registered " + "to another name.");
                            break;
                        }

                    } else {
                        student = new Student(
                                firstName,
                                lastName,
                                studentId
                        );

                        students.put(studentId, student);
                    }

                // this try block attempts the reservation, but if the auditorium 
                // is already full, then it throws the custom exception
                    try {

                        // this is an attempt to reserve a seat
                        String reservationInfo = auditorium.StudentReserveSeat(student);

                        System.out.println("\n" + reservationInfo);

                    } catch (NoSeatAvailable exception) {

                        // handle the custom exception
                        System.out.println("\n" + exception.getMessage());

                    } catch (IllegalArgumentException exception) {

                        System.out.println("\nReservation Error: " + exception.getMessage());
                    }

                    break;

                case "2":

                    System.out.println("\n--- CANCEL RESERVATION ---");

                    System.out.print("Enter your student ID: ");
                    String cancelId = scanner.nextLine().trim();

                    Student studentToCancel = students.get(cancelId);

                    if (studentToCancel == null) {

                        System.out.println("No student was found with that ID.");

                    } else if (auditorium.cancelReservation(studentToCancel)) {

                        System.out.println("Reservation successfully cancelled.");

                        System.out.println("Student: " + studentToCancel.getFullName());

                    } else {

                        System.out.println("This student does not have an active reservation.");
                    }

                    break;

                case "3":

                    // this is to display the auditorium seating chart
                    auditorium.displaySeating();

                    break;

                case "4":

                    // shows the number of available seats
                    System.out.println("\nAvailable Seats: " + auditorium.getAvailableSeatCount());

                    System.out.println("Total Seats: " + (auditorium.getRows() * auditorium.getColumns()));

                    System.out.println("Auditorium Full: " + (auditorium.auditoriumFull() ? "Yes" : "No"));

                    break;

                case "5":

                    System.out.println("\nThank you for using the Auditorium " + "Reservation System!");

                    running = false;

                    break;

                default:

                    System.out.println("Invalid choice. Please select a number from 1 to 5.");

                    break;
            }
        }

        scanner.close();
    }
}
