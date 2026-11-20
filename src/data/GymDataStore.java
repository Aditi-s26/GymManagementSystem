
package data;

import java.util.ArrayList;
import model.Member;
import model.Trainer;
import model.Attendance;

public class GymDataStore {

    // Store all registered members
    public static ArrayList<Member> members = new ArrayList<>();

    // Store all registered trainers
    public static ArrayList<Trainer> trainers = new ArrayList<>();

    // Store attendance records
    public static ArrayList<Attendance> attendanceRecords =
            new ArrayList<>();

    // Generate the next member ID
    public static int getNextMemberId() {
        return members.size() + 1;
    }

    // Generate the next trainer ID
    public static int getNextTrainerId() {
        return trainers.size() + 1;
    }
}
