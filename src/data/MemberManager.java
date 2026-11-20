
package data;

import java.util.Scanner;

import model.Member;
import exception.MemberNotFoundException;
import util.InputValidator;

public class MemberManager {

    // Register a new gym member
    public static void registerMember(Scanner sc) {

        System.out.println("\n--- REGISTER NEW MEMBER ---");

        String name;

        // Validate member name
        while (true) {
            System.out.print("Enter Member Name: ");
            name = sc.nextLine().trim();

            if (InputValidator.isValidName(name)) {
                break;
            }

            System.out.println(
                "Invalid name! Enter letters and spaces only."
            );
        }

        String phone;

        // Validate phone number
        while (true) {
            System.out.print("Enter Phone Number: ");
            phone = sc.nextLine().trim();

            if (InputValidator.isValidPhone(phone)) {
                break;
            }

            System.out.println(
                "Invalid phone number! Enter exactly 10 digits."
            );
        }

        int memberId = GymDataStore.getNextMemberId();

        Member member = new Member(memberId, name, phone);

        GymDataStore.members.add(member);

        System.out.println("\nMember registered successfully!");
        System.out.println("Member ID: " + memberId);
    }

    // Find member using member ID
    public static Member findMemberById(int memberId)
            throws MemberNotFoundException {

        for (Member member : GymDataStore.members) {

            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        throw new MemberNotFoundException(
            "Member with ID " + memberId + " not found!"
        );
    }

    // Search member
    public static void searchMember(Scanner sc) {

        System.out.println("\n--- SEARCH MEMBER ---");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        try {
            Member member = findMemberById(memberId);
            member.displayDetails();

        } catch (MemberNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
