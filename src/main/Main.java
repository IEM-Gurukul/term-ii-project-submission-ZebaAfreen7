package main;

import model.Student;
import service.AttendanceManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Student Attendance Management System Started");

        // Create manager
        AttendanceManager manager = new AttendanceManager();

        // Add students
        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(2, "Bob");
        manager.addStudent(s1);
        manager.addStudent(s2);

        // Mark attendance
        manager.markAttendance(1, "2026-03-18", true);
        manager.markAttendance(2, "2026-03-18", false);

        // Save and load
        manager.saveToFile("attendance.txt");
        manager.loadFromFile("attendance.txt");

        // View students
        System.out.println("\nStudents:");
        manager.viewStudents();

        // View attendance
        System.out.println("\nAttendance Records:");
        manager.viewAttendance(1);
        manager.viewAttendance(2);
    }
}