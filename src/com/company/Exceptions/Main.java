package com.company.Exceptions;

public class Main {


    public static void main(String[] args) {
        String[] subjects = {"English", "Essay Writing", "History", "Discrete Mathematics"};
        University university = null;
        university = Service.initUniversity(university);
        gpaService.calculateGPA(university);
        gpaService.calculateGPA(university.faculties[0]);
        gpaService.calculateGPA(university.faculties[1].groups[0]);
        gpaService.calculateGPA(university.faculties[0].groups[0].students[0]);


    }
}
