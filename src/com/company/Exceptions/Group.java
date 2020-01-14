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
        double average = 0;
        try {
            average = gradeSum / count;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        if (count != 0) {
            System.out.println("The GPA for Group " + groupName + " from" + curSubject + "is" + (gradeSum / count));
        } else
            System.out.println("No students were found in " + groupName + " studying " + curSubject);


    }
}
