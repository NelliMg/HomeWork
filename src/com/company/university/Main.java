package com.company.university;

import com.company.university.models.University;
import com.company.university.services.GpaService;
import com.company.university.services.UniversityService;

public class Main {


    public static void main(String[] args) {
        String[] subjects = {"English", "Essay Writing", "History", "Discrete Mathematics"};
        University university =UniversityService.initUniversity();
        GpaService.calculateGPA(university);
        GpaService.calculateGPA(university.getFaculties()[0]);
        GpaService.calculateGPA(university.getFaculties()[1].getGroups()[0]);
        GpaService.calculateGPA(university.getFaculties()[0].getGroups()[0].getStudents()[0]);


    }
}
