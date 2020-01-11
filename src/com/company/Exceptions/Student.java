package com.company.Exceptions;

public class Student implements gpaStrategy {
    private String firstName;
    private String lastName;
    String[] studentSubjects;
    int[] grades;

    public Student(String firstName, String lastName, int[] grades, String[] subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
        this.studentSubjects = subjects;
    }

    public void addSubject(String newSubject) {
        String[] curSubjects = new String[studentSubjects.length + 1];
        int[] curGrades = new int[grades.length + 1];
        for (int i = 0; i < studentSubjects.length; i++) {
            curSubjects[i] = studentSubjects[i];
        }
        curSubjects[studentSubjects.length] = newSubject;
        this.studentSubjects = curSubjects;
        for (int i = 0; i < grades.length; i++) {
            curGrades[i] = grades[i];
        }
        curGrades[grades.length] = 10;
        grades = curGrades;
    }

    @Override
    public void calculateGPA() {
        int gradeSum = 0;
        for (int i = 0; i < grades.length; i++) {
            gradeSum += grades[i];
        }
        System.out.println(firstName + lastName + "'s GPA is" + (gradeSum / (grades.length - 1)));
    }
}
