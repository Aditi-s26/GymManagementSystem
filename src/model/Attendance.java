
package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {

    private int memberId;
    private String memberName;
    private LocalDate attendanceDate;
    private LocalTime attendanceTime;

    public Attendance(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.attendanceDate = LocalDate.now();
        this.attendanceTime = LocalTime.now();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public LocalTime getAttendanceTime() {
        return attendanceTime;
    }

    public void displayAttendance() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + memberName);
        System.out.println("Date: " + attendanceDate);
        System.out.println("Time: " + attendanceTime);
    }
}
