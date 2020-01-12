package com.company.Exceptions;

import java.io.IOException;

import com.company.Exceptions.InvalidGradeException;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void initFaculties(Faculty[] faculties) {


    }

    public static void main(String[] args) {
        String[] subjects = {"English", "Essay Writing", "History", "Discrete Mathematics"};
        Faculty[] faculties = new Faculty[2];
        faculties = new Faculty[2];
        Group[] groups1 = new Group[1];
        Student[] students = new Student[2];
        Student s1 = null, s2 = null, s3 = null, s4 = null;
        String[] subjects1 = {"English", "Essay Writing", "History",};
        int[] grades = {5, 7, 8};
        try {
            s1 = new Student("Lili", "Mardoyan", grades, subjects1);
        } catch (InvalidGradeException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        grades[0] = 10;
        try {
            s2 = new Student("Armenuhi", "Mkhoyan", grades, subjects1);
        } catch (InvalidGradeException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("couldn't build the student  1" + e);
        }
        students[0] = s1;
        students[1] = s2;
        try {
            groups1[0] = new Group("Group N1", students, subjects1);
        } catch (NoStudentException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

        String[] subjects2 = {"History", "Discrete Mathematics"};
        Group[] groups2 = new Group[1];
        try {
            s3 = new Student("Armen", "Khachatryan", grades, subjects2);
        } catch (InvalidGradeException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("couldn't build the student  1" + e);
        }
        grades[1] = 2;
        try {
            s4 = new Student("Ani", "Dodoryan", grades, subjects1);
        } catch (InvalidGradeException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("couldn't build the student  1" + e);
        }
        students[0] = s3;
        students[1] = s4;
        try {
            groups2[0] = new Group("Group N2", students, subjects2);
        } catch (NoStudentException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            faculties[0] = new Faculty("Linguistics", groups1, subjects1);
        } catch (NoGroupException e) {
            System.out.println(e);
        } catch (NoSubjectException e) {
            System.out.println(e);
        }
        try {
            faculties[1] = new Faculty("Informatics", groups2, subjects2);
        } catch (NoGroupException e) {
            System.out.println(e);
        } catch (NoSubjectException e) {
            System.out.println(e);
        }

        System.out.println(faculties[0].facultyName);
        University university = null;
        try {
            university = new University(faculties);
        } catch (NoFacultyException e) {
            e.printStackTrace();
        }
        gpaService.calculateGPA(university);
        gpaService.calculateGPA(university.faculties[0]);
        gpaService.calculateGPA(university.faculties[1].groups[0]);
        gpaService.calculateGPA(university.faculties[0].groups[0].students[0]);


    }
}
