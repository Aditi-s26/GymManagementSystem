
package model;

public class Trainer extends GymRecord {

    private int trainerId;
    private String specialization;

    public Trainer(int trainerId, String name, String phone,
                   String specialization) {
        super(name, phone);
        this.trainerId = trainerId;
        this.specialization = specialization;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        System.out.println("Trainer ID: " + trainerId);
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Specialization: " + specialization);
    }
}
