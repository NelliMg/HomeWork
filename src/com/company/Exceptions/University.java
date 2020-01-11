package com.company.Exceptions;

import java.util.Scanner;

public class University implements gpaStrategy {
    public static Scanner input = new Scanner(System.in);
    public String[] universitySubjects = {"English", "Essay Writing", "History", "Discrete Mathematics"};
    Faculty[] faculties;

    public University() {

    }

    public void addSubject(String newSubject) {
        String[] curSubjects = new String[universitySubjects.length + 1];
        for (int i = 0; i < universitySubjects.length; i++) {
            curSubjects[i] = universitySubjects[i];
        }
        curSubjects[universitySubjects.length] = newSubject;
        this.universitySubjects = curSubjects;
    }

    public void addFaculty(Faculty newFacutly) {
        Faculty[] curFaculty = new Faculty[faculties.length + 1];
        for (int i = 0; i < faculties.length; i++) {
            curFaculty[i] = faculties[i];
        }
        curFaculty[faculties.length] = newFacutly;
        this.faculties = curFaculty;
    }

    private boolean subjectExists(String curSubject) {
        for (int i = 0; i < universitySubjects.length; i++) {
            if (curSubject.toLowerCase().equals(universitySubjects[i].toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void calculateGPA() {
        System.out.println("Which subject do you want to calculate the GPA for?\n Please enter the name of the subject");
        for (int i = 0; i < universitySubjects.length; i++) {
            System.out.println((i + 1) + ": " + universitySubjects[i]);
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
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].subjectExists(curSubject)) {
                for (int j = 0; j < faculties[i].groups.length; j++) {
                    if (faculties[i].groups[j].subjectExists(curSubject)) {
                        subjectIndex = faculties[i].groups[j].getSubjectIndex(curSubject);
                        for (int k = 0; k < faculties[i].groups[j].students.length; k++) {
                            count++;
                            gradeSum += faculties[i].groups[j].students[k].grades[subjectIndex];

                        }
                    }
                }
            }
        }
        System.out.println("The GPA for University from" + curSubject + "is" + (gradeSum / count));

    }
}
