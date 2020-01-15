package com.company.university.models;

import com.company.university.customExceptions.InvalidGradeException;
import com.company.university.customExceptions.NoFacultyException;
import com.company.university.customExceptions.NoStudentException;
import com.company.university.services.GpaStrategy;

import java.util.Scanner;

public class University implements GpaStrategy {
    public static Scanner input = new Scanner(System.in);
    private String[] universitySubjects = {"English", "Essay Writing", "History", "Discrete Mathematics"};
    private Faculty[] faculties;

    public University(Faculty[] faculties) {
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
    public void calculateGPA() throws RuntimeException{
        System.out.println("Which subject do you want to calculate the GPA for?\nPlease enter the name of the subject");
        for (int i = 0; i < universitySubjects.length; i++) {
            System.out.println((i + 1) + ": " + universitySubjects[i]);
        }
        String curSubject = input.nextLine();

        int gradeSum = 0, count = 0, subjectIndex = 0;
        if (faculties == null) {
            throw new NoFacultyException("No faculties in the university");
        } else {
            for (int i = 0; i < faculties.length; i++) {
                if (faculties[i].getGroups() == null) {
                    throw new NoFacultyException("No groups in the faculty");
                } else {
                    for (int j = 0; j < faculties[i].getGroups().length; j++) {
                        if (faculties[i].getGroups()[j].getStudents() == null) {
                            throw new NoStudentException("No Students in the group");
                        } else {
                            for (int k = 0; k < faculties[i].getGroups()[j].getStudents().length; k++) {
                                subjectIndex = faculties[i].getGroups()[j].getStudents()[k].getSubjectIndex(curSubject);
                                if (subjectIndex != -1) {
                                    if (faculties[i].getGroups()[j].getStudents()[k].getGrades() == null || faculties[i].getGroups()[j].getStudents()[k].getGrades()[subjectIndex] < 0 || faculties[i].getGroups()[j].getStudents()[k].getGrades()[subjectIndex] > 10) {
                                        throw new InvalidGradeException("Invalid grade");
                                    } else {

                                        count++;
                                        gradeSum += faculties[i].getGroups()[j].getStudents()[k].getGrades()[subjectIndex];
                                    }
                                }
                            }
                        }
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
        if(count!=0) {
            System.out.println(String.format("The GPA for University from %s is %f", curSubject, average));
        } else {
            System.out.println(String.format("No students were found in  university studying  %s",  curSubject));

        }


    }
    public Faculty[] getFaculties(){
        return this.faculties;
    }
}