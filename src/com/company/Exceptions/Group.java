package com.company.Exceptions;

import java.util.Scanner;

public class Group implements gpaStrategy {
    public static Scanner input = new Scanner(System.in);
    String groupName;
    Student[] students;
    String[] groupSubjects;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public void addSubject(String newSubject) {
        String[] curSubjects = new String[groupSubjects.length + 1];
        for (int i = 0; i < groupSubjects.length; i++) {
            curSubjects[i] = groupSubjects[i];
        }
        curSubjects[groupSubjects.length] = newSubject;
        this.groupSubjects = curSubjects;
        for (int i = 0; i < students.length; i++) {
            students[i].addSubject(newSubject);
        }
    }

    public void addStudent(Student newStudent) {
        Student[] curStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            curStudents[i] = students[i];
        }
        curStudents[groupSubjects.length] = newStudent;
        this.students = curStudents;
    }

    public boolean subjectExists(String curSubject) {
        for (int i = 0; i < groupSubjects.length; i++) {
            if (curSubject.toLowerCase().equals(groupSubjects[i].toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int getSubjectIndex(String subject) {
        for (int j = 0; j < groupSubjects.length; j++) {
            if (groupSubjects[j].equals(subject)) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public void calculateGPA() {
        System.out.println("Which subject do you want to calculate the GPA for?\n Please enter the name of the subject");
        for (int i = 0; i < groupSubjects.length; i++) {
            System.out.println((i + 1) + ": " + groupSubjects[i]);
        }
        boolean subExists = false;
        String curSubject = "";
        while (!subExists) {
            curSubject = input.nextLine();
            if (subjectExists(curSubject)) {
                subExists = true;

            } else {
                System.out.println("You have entered a wrong subject ,please try again");
            }
        }
        int gradeSum = 0, count = 0, subjectIndex = 0;
        for (int k = 0; k < students.length; k++) {
            count++;
            gradeSum += students[k].grades[subjectIndex];


        }
        System.out.println("The GPA for University from" + curSubject + "is" + (gradeSum / count));


    }
}
