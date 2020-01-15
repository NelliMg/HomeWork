package com.company.university.services;

import com.company.university.models.Faculty;
import com.company.university.models.Group;
import com.company.university.models.Student;
import com.company.university.models.University;

public class UniversityService {
    public static University initUniversity() {
        System.out.println("in init");
        Faculty[] faculties = new Faculty[2];
        faculties = new Faculty[2];
        Group[] groups1 = new Group[1];
        Student[] students = new Student[2];
        Student s1 = null, s2 = null, s3 = null, s4 = null;
        String[] subjects1 = {"English", "Essay Writing", "History"};
        int[] grades = {5, 7, 8};
        s1 = new Student("Lili", "Mardoyan", grades, subjects1);
        grades[0] = 10;
        s2 = new Student("Armenuhi", "Mkhoyan", grades, subjects1);

        students[0] = s1;
        students[1] = s2;

        groups1[0] = new Group("Group N1", students);
        String[] subjects2 = {"History", "Discrete Mathematics"};
        Group[] groups2=new Group[1] ;

        s3 = new Student("Armen", "Khachatryan", grades, subjects2);

        grades[1] = 2;
        s4 = new Student("Ani", "Dodoryan", grades, subjects1);
        students[0] = s3;
        students[1] = s4;
        groups2[0] = new Group("Group N2", students);


        faculties[0] = new Faculty("Linguistics", groups1);
        faculties[1] = new Faculty("Informatics", groups2);

       University university = new University(faculties);
        return university;

    }
}
