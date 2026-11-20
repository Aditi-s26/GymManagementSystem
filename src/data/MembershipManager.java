
package data;

import java.time.LocalDate;
import java.util.Scanner;

import model.Member;
import exception.MemberNotFoundException;
import exception.InvalidMembershipPlanException;

public class MembershipManager {

    // Get membership plan duration
    public static int getPlanDuration(int choice)
            throws InvalidMembershipPlanException {

        switch (choice) {
            case 1:
                return 30;

            case 2:
                return 90;

            case 3:
                return 180;

            case 4:
                return 365;

            default:
                throw new InvalidMembershipPlanException(
                    "Invalid membership plan selected!"
                );
        }
    }

    // Get membership plan name
    public static String getPlanName(int choice)
            throws InvalidMembershipPlanException {

        switch (choice) {
            case 1:
                return "Monthly";

            case 2:
                return "Quarterly";

            case 3:
                return "Half Yearly";

            case 4:
                return "Yearly";

            default:
                throw new InvalidMembershipPlanException(
                    "Invalid membership plan selected!"
                );
        }
    }

    // Select membership plan for a member
    public static void selectMembership(Scanner sc) {

        System.out.println("\n--- SELECT MEMBERSHIP PLAN ---");

        try {
            System.out.print("Enter Member ID: ");
            int memberId = sc.nextInt();

            Member member = MemberManager.findMemberById(memberId);

            MemberManager.displayMembershipPlans();

            System.out.print("Choose a plan (1-4): ");
            int choice = sc.nextInt();

            String planName = getPlanName(choice);
            int duration = getPlanDuration(choice);

            LocalDate startDate = LocalDate.now();
            LocalDate expiryDate = startDate.plusDays(duration);

            member.setMembershipPlan(planName);
            member.setStartDate(startDate);
            member.setExpiryDate(expiryDate);

            System.out.println("\nMembership selected successfully!");
            System.out.println("Plan: " + planName);
            System.out.println("Start Date: " + startDate);
            System.out.println("Expiry Date: " + expiryDate);

        } catch (MemberNotFoundException |
                 InvalidMembershipPlanException e) {

            System.out.println(e.getMessage());

        } catch (java.util.InputMismatchException e) {

            System.out.println("Please enter numbers only.");
        }

        sc.nextLine();
    }

    // Renew an existing membership
    public static void renewMembership(Scanner sc) {

        System.out.println("\n--- RENEW MEMBERSHIP ---");

        try {
            System.out.print("Enter Member ID: ");
            int memberId = sc.nextInt();

            Member member = MemberManager.findMemberById(memberId);

            MemberManager.displayMembershipPlans();

            System.out.print("Choose a renewal plan (1-4): ");
            int choice = sc.nextInt();

            String planName = getPlanName(choice);
            int duration = getPlanDuration(choice);

            LocalDate today = LocalDate.now();
            LocalDate startDate = today;

            // Continue from the previous expiry date if still active
            if (member.getExpiryDate() != null &&
                member.getExpiryDate().isAfter(today)) {

                startDate = member.getExpiryDate();
            }

            LocalDate expiryDate = startDate.plusDays(duration);

            member.setMembershipPlan(planName);
            member.setStartDate(startDate);
            member.setExpiryDate(expiryDate);

            System.out.println("\nMembership renewed successfully!");
            System.out.println("Plan: " + planName);
            System.out.println("Renewal Start Date: " + startDate);
            System.out.println("New Expiry Date: " + expiryDate);

        } catch (MemberNotFoundException |
                 InvalidMembershipPlanException e) {

            System.out.println(e.getMessage());

        } catch (java.util.InputMismatchException e) {

            System.out.println("Please enter numbers only.");
        }

        sc.nextLine();
    }
}
