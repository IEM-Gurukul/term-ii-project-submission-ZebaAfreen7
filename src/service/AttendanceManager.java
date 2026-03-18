package service;

import java.util.ArrayList;
import java.io.*;
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

    public void viewStudents() {
        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }

    public void viewAttendance(int studentId) {
        if (!studentExists(studentId)) {
            System.out.println("Error: Student ID " + studentId + " not found!");
            return;
        }

        for (AttendanceRecord r : records) {
            if (r.getStudentId() == studentId) {
                System.out.println(r);
            }
        }
    }

    private boolean studentExists(int studentId) {
        for (Student s : students) {
            if (s.getId() == studentId) return true;
        }
        return false;
    }

    // ✅ 9th commit starts here (FILE HANDLING)

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (AttendanceRecord r : records) {
                writer.write(r.getStudentId() + "," + r.getDate() + "," + r.isPresent());
                writer.newLine();
            }
            System.out.println("Attendance saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        records.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int studentId = Integer.parseInt(parts[0]);
                String date = parts[1];
                boolean isPresent = Boolean.parseBoolean(parts[2]);

                records.add(new AttendanceRecord(studentId, date, isPresent));
            }
            System.out.println("Attendance loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}