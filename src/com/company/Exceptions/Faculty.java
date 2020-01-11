package com.company.Exceptions;

import java.util.Scanner;

public class Faculty implements gpaStrategy {
    public static Scanner input = new Scanner(System.in);
    String facultyName;
    public Group[] groups;
    String[] facultySubjects;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public void addSubject(String newSubject) {
        String[] curSubjects = new String[facultySubjects.length + 1];
        for (int i = 0; i < facultySubjects.length; i++) {
            curSubjects[i] = facultySubjects[i];
        }
        curSubjects[facultySubjects.length] = newSubject;
        this.facultySubjects = curSubjects;
    }

    public void addGroup(Group newGroup) {
        Group[] curGroups = new Group[groups.length + 1];
        for (int i = 0; i < groups.length; i++) {
            curGroups[i] = groups[i];
        }
        curGroups[groups.length] = newGroup;
        this.groups = curGroups;

    }

    public boolean subjectExists(String curSubject) {
        for (int i = 0; i < facultySubjects.length; i++) {
            if (curSubject.toLowerCase().equals(facultySubjects[i].toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void calculateGPA() {
        System.out.println("Which subject do you want to calculate the GPA for?\n Please enter the name of the subject");
        for (int i = 0; i < facultySubjects.length; i++) {
            System.out.println((i + 1) + ": " + facultySubjects[i]);
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
        for (int j = 0; j < groups.length; j++) {
            if (groups[j].subjectExists(curSubject)) {
                subjectIndex = groups[j].getSubjectIndex(curSubject);
                for (int k = 0; k < groups[j].students.length; k++) {
                    count++;
                    gradeSum += groups[j].students[k].grades[subjectIndex];

                }
            }
        }

        System.out.println("The GPA for University from" + curSubject + "is" + (gradeSum / count));


    }
}
