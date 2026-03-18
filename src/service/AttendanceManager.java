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
        if (!studentExists(studentId)) {
            System.out.println("Error: Student ID " + studentId + " not found!");
            return;
        }
        AttendanceRecord record = new AttendanceRecord(studentId, date, isPresent);
        records.add(record);
    }

    public void viewAttendance(int studentId) {
        if (!studentExists(studentId)) {
            System.out.println("Error: Student ID " + studentId + " not found!");
            return;
        }
        System.out.println("Attendance for student ID: " + studentId);
        for (AttendanceRecord r : records) {
            if (r.getStudentId() == studentId) {
                System.out.println(r.getDate() + " : " + (r.isPresent() ? "Present" : "Absent"));
            }
        }
    }

    public void viewStudents() {
        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }

    private boolean studentExists(int studentId) {
        for (Student s : students) {
            if (s.getId() == studentId) return true;
        }
        return false;
    }
}