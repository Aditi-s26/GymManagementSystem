
package model;

import java.time.LocalDate;

public class Member extends GymRecord {

    private int memberId;
    private String membershipPlan;
    private LocalDate startDate;
    private LocalDate expiryDate;
    private String trainerName;

    // Constructor
    public Member(int memberId, String name, String phone) {
        super(name, phone);
        this.memberId = memberId;
        this.membershipPlan = "Not Selected";
        this.trainerName = "Not Assigned";
    }

    // Getters and setters
    public int getMemberId() {
        return memberId;
    }

    public String getMembershipPlan() {
        return membershipPlan;
    }

    public void setMembershipPlan(String membershipPlan) {
        this.membershipPlan = membershipPlan;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    // Display member details
    @Override
    public void displayDetails() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Membership Plan: " + membershipPlan);
        System.out.println("Start Date: " + startDate);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Trainer: " + trainerName);
    }
}
