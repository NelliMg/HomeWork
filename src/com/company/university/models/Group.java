package com.company.university.models;

import com.company.university.customExceptions.InvalidGradeException;
import com.company.university.customExceptions.NoStudentException;
import com.company.university.services.GpaStrategy;

import java.util.Scanner;

public class Group implements GpaStrategy {
    public static Scanner input = new Scanner(System.in);
     private String groupName;
     private Student[] students;

    public Group(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;

    }

    public void addStudent(Student newStudent) {
        if (students == null) {
            students = new Student[1];
            students[0] = newStudent;
        } else {
            Student[] curStudents = new Student[students.length + 1];
            for (int i = 0; i < students.length; i++) {
                curStudents[i] = students[i];
            }
            curStudents[students.length] = newStudent;
            this.students = curStudents;
        }
    }
    public Student [] getStudents(){
        return this.students;
    }

    @Override
    public void calculateGPA() throws RuntimeException {
        System.out.println("Which subject do you want to calculate the GPA for?\nPlease enter the name of the subject");
        String curSubject = input.nextLine();
        int gradeSum = 0, count = 0, subjectIndex = 0;
        if (students == null) {
            throw new NoStudentException("No students in the group");
        } else {
            for (int k = 0; k < students.length; k++) {
                subjectIndex = students[k].getSubjectIndex(curSubject);
                if (subjectIndex != -1) {
                    count++;
                    if (students[k].getGrades() == null || students[k].getGrades()[subjectIndex] < 0 || students[k].getGrades()[subjectIndex] > 10) {
                        throw new InvalidGradeException("Invalid gardes");
                    } else {
                        gradeSum += students[k].getGrades()[subjectIndex];
                    }
                }

            }
        }

        double average = 0;
        try {
            average = gradeSum / count;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        if (count != 0) {
            System.out.println(String.format("The GPA for the Group %s from %s is %f", groupName, curSubject, average));

        } else {
            System.out.println(String.format("No students were found in  %s studying  %s", groupName, curSubject));

        }
    }
}
