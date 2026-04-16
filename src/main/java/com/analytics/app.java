package com.analytics;

import java.util.*;

class Student {
    String name;
    double cat, assignment, fat, total, cgpa;
    String grade;

    public Student(String name, double cat, double assignment, double fat) {
        this.name = name;
        this.cat = cat;
        this.assignment = assignment;
        this.fat = fat;
        this.total = cat + assignment + fat;
        this.cgpa = this.total / 10.0; // 10-point scale
        this.grade = calculateGrade(this.total);
    }

    private String calculateGrade(double total) {
        if (total >= 90) return "S (Excellent)";
        if (total >= 80) return "A (Very Good)";
        if (total >= 70) return "B (Good)";
        if (total >= 60) return "C (Average)";
        if (total >= 50) return "D (Pass)";
        return "F (Fail)";
    }
}

public class App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Student_1", 28, 18, 45));
        students.add(new Student("Student_2", 22, 15, 38));
        students.add(new Student("Student_3", 29, 19, 48));
        students.add(new Student("Student_4", 25, 17, 40));
        students.add(new Student("Student_5", 20, 14, 32));

        System.out.println("--- STUDENT PERFORMANCE ANALYTICS ---");
        Student topper = students.get(0);

        for (Student s : students) {
            System.out.printf("Name: %-10s | Total: %-5.2f | CGPA: %-4.1f | Grade: %s%n", 
                               s.name, s.total, s.cgpa, s.grade);
            if (s.total > topper.total) topper = s;
        }

        System.out.println("-------------------------------------");
        System.out.println("TOPPER IDENTIFIED: " + topper.name + " with " + topper.total + " marks.");
        System.out.println("-------------------------------------");
    }
}