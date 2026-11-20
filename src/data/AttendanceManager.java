
package data;

import java.util.Scanner;

import model.Member;
import model.Attendance;
import exception.MemberNotFoundException;
import ds.AttendanceQueue;

public class AttendanceManager {

    // Custom Queue to store attendance records
    private static AttendanceQueue attendanceQueue =
            new AttendanceQueue();

    // Mark attendance for a gym member
    public static void markAttendance(Scanner sc) {

        System.out.println("\n--- MARK ATTENDANCE ---");

        try {
            System.out.print("Enter Member ID: ");

            int memberId = Integer.parseInt(sc.nextLine().trim());

            // Find the member
            Member member = MemberManager.findMemberById(memberId);

            // Create attendance record
            Attendance attendance =
                    new Attendance(member.getMemberId(), member.getName());

            // Add record to the custom Queue
            attendanceQueue.enqueue(attendance);

            System.out.println("\nAttendance marked successfully!");
            System.out.println("Member: " + member.getName());
            System.out.println("Member ID: " + memberId);

        } catch (NumberFormatException e) {

            System.out.println("Invalid input! Please enter a valid number.");

        } catch (MemberNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }
}
