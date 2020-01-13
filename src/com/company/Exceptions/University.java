package com.company.Exceptions;

import java.util.Scanner;

public class University implements gpaStrategy {
    public static Scanner input = new Scanner(System.in);
    public String[] universitySubjects = {"English", "Essay Writing", "History", "Discrete Mathematics"};
    Faculty[] faculties;

    public University(Faculty[] faculties) throws RuntimeException {
        if (faculties == null) {
            throw new RuntimeException("No faculties in the University");
        }
        this.faculties = faculties;
    }

    public void addFaculty(Faculty newFacutly) {
        if (faculties == null) {
            faculties = new Faculty[1];
            faculties[0] = newFacutly;
        } else {
            Faculty[] curFaculty = new Faculty[faculties.length + 1];
            for (int i = 0; i < faculties.length; i++) {
                curFaculty[i] = faculties[i];
            }
            curFaculty[faculties.length] = newFacutly;
            this.faculties = curFaculty;
        }
    }

    @Override
    public void calculateGPA() {
        System.out.println("Which subject do you want to calculate the GPA for?\n Please enter the name of the subject");
        for (int i = 0; i < universitySubjects.length; i++) {
            System.out.println((i + 1) + ": " + universitySubjects[i]);
        }
        boolean subExists = false;
        String curSubject = input.nextLine();

        int gradeSum = 0, count = 0, subjectIndex = 0;
        try {
            for (int i = 0; i < faculties.length; i++) {

                for (int j = 0; j < faculties[i].groups.length; j++) {
                    for (int k = 0; k < faculties[i].groups[j].students.length; k++) {
                        subjectIndex = faculties[i].groups[j].students[k].getSubjectIndex(curSubject);
                        if (subjectIndex != -1) {
                            count++;
                            gradeSum += faculties[i].groups[j].students[k].grades[subjectIndex];
                        }
                    }


                }
            }
        } catch (
                NullPointerException ex) {
            System.out.println("Something went wrong while calculation the GPA of " + curSubject + " in the University");
        }
        try {
            System.out.println("The GPA for University from" + curSubject + "is" + (gradeSum / count));
        } catch (
                ArithmeticException e) {
            System.out.println(e);
        }


    }
}