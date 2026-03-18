package service;

import java.util.ArrayList;
import model.Student;
import model.AttendanceRecord;

public class AttendanceManager {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<AttendanceRecord> records = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void markAttendance(int studentId, String date, boolean isPresent) {
        AttendanceRecord record = new AttendanceRecord(studentId, date, isPresent);
        records.add(record);
    }

    public void viewStudents() {
        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }

    public void viewAttendance(int studentId) {
        System.out.println("Attendance for student ID: " + studentId);
        for (AttendanceRecord r : records) {
            if (r.getStudentId() == studentId) {
                System.out.println(r.getDate() + " : " + (r.isPresent() ? "Present" : "Absent"));
            }
        }
    }
}