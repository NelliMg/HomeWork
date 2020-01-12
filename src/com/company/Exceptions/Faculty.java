package com.company.Exceptions;

import java.util.Scanner;

class NoGroupException extends Exception {
    public NoGroupException(String message) {
        super(message);
    }
}

public class Faculty implements gpaStrategy {
    public static Scanner input = new Scanner(System.in);
    String facultyName;
    public Group[] groups;
    String[] facultySubjects;

    public Faculty(String facultyName, Group[] groups, String[] facultySubjects) throws NoGroupException, NoSubjectException {
        this.facultyName = facultyName;
        if (groups == null) {
            throw new NoGroupException("no groups in the faculty  " + facultyName);
        }
        this.groups = groups;
        if (facultySubjects == null) {
            throw new NoSubjectException("No subjects in the faculty");
        }
        this.facultySubjects = facultySubjects;
    }

    public void addSubject(String newSubject) {
        if (facultySubjects == null) {
            facultySubjects = new String[1];
            facultySubjects[0] = newSubject;
        } else {
            String[] curSubjects = new String[facultySubjects.length + 1];
            for (int i = 0; i < facultySubjects.length; i++) {
                curSubjects[i] = facultySubjects[i];
            }
            curSubjects[facultySubjects.length] = newSubject;
            this.facultySubjects = curSubjects;
        }
    }

    public void addGroup(Group newGroup) {
        if (groups == null) {
            groups = new Group[1];
            groups[0] = newGroup;
        } else {
            Group[] curGroups = new Group[groups.length + 1];
            for (int i = 0; i < groups.length; i++) {
                curGroups[i] = groups[i];
            }
            curGroups[groups.length] = newGroup;
            this.groups = curGroups;
        }
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
        if (facultySubjects == null) {
            System.out.println("faculty subjects were null");
        }
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
