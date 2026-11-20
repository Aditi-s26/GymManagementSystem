
import java.util.*;
import java.time.LocalDate;

class Member {
    int id;
    String name, phone, plan, trainer;
    LocalDate startDate, endDate;

    Member(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.plan = "Not Selected";
        this.trainer = "Not Assigned";
    }
}

class Trainer {
    int id;
    String name, specialization;

    Trainer(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
}

public class GymManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Trainer> trainers = new ArrayList<>();
    static ArrayList<String> attendance = new ArrayList<>();

    static int memberId = 1;
    static int trainerId = 1;

    static String[] plans = {
        "Monthly - Rs.1000",
        "Quarterly - Rs.2500",
        "Half Yearly - Rs.4500",
        "Yearly - Rs.8000"
    };

    static int[] durations = {30, 90, 180, 365};

    // Find member using ID
    static Member findMember(int id) {
        for (Member m : members) {
            if (m.id == id) {
                return m;
            }
        }
        return null;
    }

    // Register new member
    static void registerMember() {
        System.out.print("Enter member name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Member m = new Member(memberId++, name, phone);
        members.add(m);

        System.out.println("Member registered successfully!");
        System.out.println("Member ID: " + m.id);
    }

    // View all members
    static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        for (Member m : members) {
            System.out.println("\nMember ID: " + m.id);
            System.out.println("Name: " + m.name);
            System.out.println("Phone: " + m.phone);
            System.out.println("Plan: " + m.plan);
            System.out.println("Trainer: " + m.trainer);
            System.out.println("Start Date: " + m.startDate);
            System.out.println("Expiry Date: " + m.endDate);
        }
    }

    // Search member using ID
    static void searchMember() {
        System.out.print("Enter Member ID to search: ");
        int id = Integer.parseInt(sc.nextLine());

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.println("\nMEMBER DETAILS");
        System.out.println("Member ID: " + m.id);
        System.out.println("Name: " + m.name);
        System.out.println("Phone: " + m.phone);
        System.out.println("Plan: " + m.plan);
        System.out.println("Trainer: " + m.trainer);
        System.out.println("Start Date: " + m.startDate);
        System.out.println("Expiry Date: " + m.endDate);
    }

    // Update member details
    static void updateMember() {

        System.out.print("Enter Member ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.println("Current Name: " + m.name);
        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        System.out.println("Current Phone: " + m.phone);
        System.out.print("Enter new phone number: ");
        String newPhone = sc.nextLine();

        m.name = newName;
        m.phone = newPhone;

        System.out.println("Member details updated successfully!");
    }

    // View membership plans
    static void viewPlans() {
        System.out.println("\nAVAILABLE MEMBERSHIP PLANS");

        for (int i = 0; i < plans.length; i++) {
            System.out.println((i + 1) + ". " + plans[i]);
        }
    }

    // Select membership plan
    static void selectPlan() {
        System.out.print("Enter Member ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        viewPlans();

        System.out.print("Select plan (1-4): ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid plan!");
            return;
        }

        m.plan = plans[choice - 1];
        m.startDate = LocalDate.now();
        m.endDate = m.startDate.plusDays(durations[choice - 1]);

        System.out.println("Membership activated successfully!");
        System.out.println("Expiry Date: " + m.endDate);
    }

    // Renew membership
    static void renewMembership() {
        System.out.print("Enter Member ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        viewPlans();

        System.out.print("Select renewal plan (1-4): ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid plan!");
            return;
        }

        LocalDate today = LocalDate.now();

        LocalDate baseDate = (m.endDate != null &&
                m.endDate.isAfter(today))
                ? m.endDate : today;

        m.plan = plans[choice - 1];
        m.startDate = today;
        m.endDate = baseDate.plusDays(durations[choice - 1]);

        System.out.println("Membership renewed successfully!");
        System.out.println("New Expiry Date: " + m.endDate);
    }

    // Mark attendance
    static void markAttendance() {
        System.out.print("Enter Member ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        if (m.endDate == null ||
                m.endDate.isBefore(LocalDate.now())) {
            System.out.println("Membership expired or not selected!");
            return;
        }

        String record = "Member: " + m.name +
                " | ID: " + id +
                " | Date: " + LocalDate.now();

        attendance.add(record);

        System.out.println("Attendance marked successfully!");
    }

    // View attendance
    static void viewAttendance() {
        if (attendance.isEmpty()) {
            System.out.println("No attendance records.");
            return;
        }

        for (String record : attendance) {
            System.out.println(record);
        }
    }

    // Add trainer
    static void addTrainer() {
        System.out.print("Enter trainer name: ");
        String name = sc.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();

        Trainer t = new Trainer(
            trainerId++, name, specialization
        );

        trainers.add(t);

        System.out.println("Trainer added successfully!");
        System.out.println("Trainer ID: " + t.id);
    }

    // Allot trainer to member
    static void allotTrainer() {
        System.out.print("Enter Member ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Member m = findMember(id);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        if (trainers.isEmpty()) {
            System.out.println("No trainers available!");
            return;
        }

        for (Trainer t : trainers) {
            System.out.println(
                t.id + ". " + t.name +
                " - " + t.specialization
            );
        }

        System.out.print("Enter Trainer ID: ");
        int tid = Integer.parseInt(sc.nextLine());

        for (Trainer t : trainers) {
            if (t.id == tid) {
                m.trainer = t.name;
                System.out.println("Trainer allotted successfully!");
                return;
            }
        }

        System.out.println("Trainer not found!");
    }

    // View trainers
    static void viewTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers available.");
            return;
        }

        for (Trainer t : trainers) {
            System.out.println("\nTrainer ID: " + t.id);
            System.out.println("Name: " + t.name);
            System.out.println("Specialization: " +
                    t.specialization);
        }
    }

    // Main method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n================================");
            System.out.println(" GYM MEMBERSHIP MANAGEMENT SYSTEM");
            System.out.println("================================");
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
            System.out.println("12. Update Member Details");
            System.out.println("13. Exit");

            System.out.print("\nEnter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        registerMember();
                        break;

                    case 2:
                        viewMembers();
                        break;

                    case 3:
                        viewPlans();
                        break;

                    case 4:
                        selectPlan();
                        break;

                    case 5:
                        renewMembership();
                        break;

                    case 6:
                        markAttendance();
                        break;

                    case 7:
                        viewAttendance();
                        break;

                    case 8:
                        addTrainer();
                        break;

                    case 9:
                        allotTrainer();
                        break;

                    case 10:
                        viewTrainers();
                        break;

                    case 11:
                        searchMember();
                        break;

                    case 12:
                        updateMember();
                        break;

                    case 13:
                        System.out.println("Thank you for using Gym Management System!");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}