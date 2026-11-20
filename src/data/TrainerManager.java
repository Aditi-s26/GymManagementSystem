
package data;

import java.util.Scanner;

import model.Trainer;
import model.Member;
import exception.MemberNotFoundException;
import util.InputValidator;

public class TrainerManager {

    // Add a new trainer
    public static void addTrainer(Scanner sc) {

        System.out.println("\n--- ADD NEW TRAINER ---");

        String name;

        // Validate trainer name
        while (true) {
            System.out.print("Enter Trainer Name: ");
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

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine().trim();

        if (specialization.isEmpty()) {
            System.out.println("Specialization cannot be empty.");
            return;
        }

        int trainerId = GymDataStore.getNextTrainerId();

        Trainer trainer = new Trainer(
            trainerId, name, phone, specialization
        );

        GymDataStore.trainers.add(trainer);

        System.out.println("\nTrainer added successfully!");
        System.out.println("Trainer ID: " + trainerId);
    }

    // Allot a trainer to a member
    public static void allotTrainer(Scanner sc) {

        System.out.println("\n--- ALLOT TRAINER ---");

        try {
            System.out.print("Enter Member ID: ");
            int memberId = Integer.parseInt(sc.nextLine().trim());

            Member member = MemberManager.findMemberById(memberId);

            if (GymDataStore.trainers.isEmpty()) {
                System.out.println("No trainers available.");
                return;
            }

            viewAllTrainers();

            System.out.print("Enter Trainer ID: ");
            int trainerId = Integer.parseInt(sc.nextLine().trim());

            Trainer selectedTrainer = null;

            for (Trainer trainer : GymDataStore.trainers) {

                if (trainer.getTrainerId() == trainerId) {
                    selectedTrainer = trainer;
                    break;
                }
            }

            if (selectedTrainer == null) {
                System.out.println("Trainer not found!");
                return;
            }

            member.setTrainerName(selectedTrainer.getName());

            System.out.println("\nTrainer allotted successfully!");
            System.out.println("Member: " + member.getName());
            System.out.println("Trainer: " + selectedTrainer.getName());

        } catch (MemberNotFoundException e) {

            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Please enter valid numeric IDs.");
        }
    }

    // Display all registered trainers
    public static void viewAllTrainers() {

        System.out.println("\n--- ALL GYM TRAINERS ---");

        if (GymDataStore.trainers.isEmpty()) {
            System.out.println("No trainers registered yet.");
            return;
        }

        for (Trainer trainer : GymDataStore.trainers) {

            System.out.println("-------------------------");
            trainer.displayDetails();
        }
    }
}
