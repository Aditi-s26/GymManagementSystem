
package ds;

import java.util.ArrayList;
import java.util.List;
import model.Attendance;

public class AttendanceQueue {

    // Node represents one attendance record
    private static class Node {
        Attendance data;
        Node next;

        Node(Attendance data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Add attendance record to the rear of the queue
    public void enqueue(Attendance attendance) {

        Node newNode = new Node(attendance);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Remove and return the front attendance record
    public Attendance dequeue() {

        if (front == null) {
            return null;
        }

        Attendance attendance = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return attendance;
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return all attendance records without removing them
    public List<Attendance> getAll() {

        List<Attendance> records = new ArrayList<>();

        Node current = front;

        while (current != null) {
            records.add(current.data);
            current = current.next;
        }

        return records;
    }
}
