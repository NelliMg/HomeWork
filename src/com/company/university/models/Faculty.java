package com.company.university.models;

import com.company.university.customExceptions.InvalidGradeException;
import com.company.university.customExceptions.NoGroupException;
import com.company.university.customExceptions.NoStudentException;
import com.company.university.services.GpaStrategy;

import java.util.Scanner;

public class Faculty implements GpaStrategy {
    public static Scanner input = new Scanner(System.in);
    private String facultyName;
     private Group[] groups;

    public Faculty(String facultyName, Group[] groups){
        this.facultyName = facultyName;
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

    public Group [] getGroups(){
        return  this.groups;
    }
    @Override
    public void calculateGPA()  throws RuntimeException{
        System.out.println("Which subject do you want to calculate the GPA for?\nPlease enter the name of the subject");


        String curSubject = input.nextLine();

        int gradeSum = 0, count = 0, subjectIndex = 0;

        if (groups == null) {
            throw new NoGroupException("No groups in the Faculty");
        } else {
            for (int j = 0; j < groups.length; j++) {
                if (groups[j].getStudents() == null) {
                    throw new NoStudentException("No students in the group");
                } else {
                    for (int k = 0; k < groups[j].getStudents().length; k++) {
                        subjectIndex = groups[j].getStudents()[k].getSubjectIndex(curSubject);
                        if(subjectIndex!=-1){
                        if (groups[j].getStudents()[k].getGrades() == null || groups[j].getStudents()[k].getGrades()[subjectIndex] < 0 || groups[j].getStudents()[k].getGrades()[subjectIndex] > 10) {
                            throw new InvalidGradeException("Invalid grade");
                        } else {

                            count++;
                            gradeSum += groups[j].getStudents()[k].getGrades()[subjectIndex];
                        }}

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
            System.out.println(String.format("The GPA for Faculty from %s is %f", curSubject, average));

        } else {
            System.out.println(String.format("No students were found in  %s studying  %s", facultyName, curSubject));

        }

    }
}

