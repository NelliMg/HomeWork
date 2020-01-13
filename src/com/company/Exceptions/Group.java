package com.company.Exceptions;

import java.util.Scanner;

public class Group implements gpaStrategy {
    public static Scanner input = new Scanner(System.in);
    String groupName;
    Student[] students;

    public Group(String groupName, Student[] students) throws RuntimeException {
        this.groupName = groupName;
        if (students == null) {
            throw new RuntimeException("No students were added to group " + groupName);
        }
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


    @Override
    public void calculateGPA() {
        System.out.println("Which subject do you want to calculate the GPA for?\n Please enter the name of the subject");
        String curSubject = input.nextLine();
        int gradeSum = 0, count = 0, subjectIndex = 0;
        try {
            for (int k = 0; k < students.length; k++) {
                subjectIndex = students[k].getSubjectIndex(curSubject);
                if (subjectIndex != -1) {
                    count++;
                    gradeSum += students[k].grades[subjectIndex];
                }

            }
        } catch (Exception e) {
            System.out.println(" An error occured during calculation the GPA for a group.");
        }
        double average = gradeSum / count;
        try {
            System.out.println("The GPA for University from" + curSubject + "is" + average);
        } catch (ArithmeticException e) {
            System.out.println("division to zero");
        }


    }
}
