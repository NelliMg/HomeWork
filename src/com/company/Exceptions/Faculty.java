package com.company.Exceptions;

import java.util.Scanner;

public class Faculty implements gpaStrategy {
    public static Scanner input = new Scanner(System.in);
    String facultyName;
    public Group[] groups;

    public Faculty(String facultyName, Group[] groups) throws RuntimeException {
        this.facultyName = facultyName;
        if (groups == null) {
            throw new RuntimeException("no groups in the faculty  " + facultyName);
        }
        this.groups = groups;

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


    @Override
    public void calculateGPA() {
        System.out.println("Which subject do you want to calculate the GPA for?\n Please enter the name of the subject");


        String curSubject = input.nextLine();

        int gradeSum = 0, count = 0, subjectIndex = 0;
        for (int j = 0; j < groups.length; j++) {

            for (int k = 0; k < groups[j].students.length; k++) {
                subjectIndex = groups[j].students[k].getSubjectIndex(curSubject);
                if (subjectIndex != -1) {
                    count++;
                    gradeSum += groups[j].students[k].grades[subjectIndex];
                }

            }
        }
        if (count != 0) {
            System.out.println("The GPA for University from" + curSubject + "is" + (gradeSum / count));
        } else
            System.out.println("No sudents were found in " + facultyName + " studying " + curSubject);
    }


}

