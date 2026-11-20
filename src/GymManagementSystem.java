
import java.util.Scanner;

import data.MemberManager;
import data.MembershipManager;
import data.AttendanceManager;
import data.TrainerManager;

public class GymManagementSystem {

    // Display the main menu
    public static void displayMenu() {

        System.out.println("\n====================================");
        System.out.println("   GYM MEMBERSHIP MANAGEMENT SYSTEM");
        System.out.println("====================================");
        System.out.println("1. Register New Member");
        System.out.println("2. View All Members");
        System.out.println("3. View Membership Plans");
        System.out.println("4. Select Membership Plan");
        System.out.println("5. Renew Membership");
        System.out.println("6. Mark Attendance");
        System.out.println("7. View Attendance");
        System.out.println("8. Add Trainer");
        System.out.println("9. Allot Trainer");
        System.out.println("10. View Trainers");
        System.out.println("11. Search Member");
        System.out.println("12. Exit");
        System.out.println("====================================");
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice = 0;

        System.out.println("\nWelcome to Gym Management System!");

        do {

            displayMenu();

            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();

            try {
                choice = Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input! Please enter a number."
                );

                continue;
            }

            switch (choice) {

                case 1:
                    MemberManager.registerMember(sc);
                    break;

                case 2:
                    MemberManager.viewAllMembers();
                    break;

                case 3:
                    MemberManager.displayMembershipPlans();
                    break;

                case 4:
                    MembershipManager.selectMembership(sc);
                    break;

                case 5:
                    MembershipManager.renewMembership(sc);
                    break;

                case 6:
                    AttendanceManager.markAttendance(sc);
                    break;

                case 7:
                    AttendanceManager.viewAttendance();
                    break;

                case 8:
                    TrainerManager.addTrainer(sc);
                    break;

                case 9:
                    TrainerManager.allotTrainer(sc);
                    break;

                case 10:
                    TrainerManager.viewAllTrainers();
                    break;

                case 11:
                    MemberManager.searchMember(sc);
                    break;

                case 12:
                    System.out.println(
                        "\nThank you for using Gym Management System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please select between 1 and 12."
                    );
            }

        } while (choice != 12);

        sc.close();
    }
}
