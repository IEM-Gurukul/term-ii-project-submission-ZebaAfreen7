package model;

public class AttendanceRecord {

    private int studentId;
    private String date;
    private boolean isPresent;

    // Constructor
    public AttendanceRecord(int studentId, String date, boolean isPresent) {
        this.studentId = studentId;
        this.date = date;
        this.isPresent = isPresent;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getDate() {
        return date;
    }

    public boolean isPresent() {
        return isPresent;
    }

     @Override
    public String toString() {
        return "Student ID: " + studentId + ", Date: " + date + ", " +
               (isPresent ? "Present" : "Absent");
    }
}
