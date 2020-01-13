package com.company.Exceptions;


public class Student implements gpaStrategy {
    private String firstName;
    private String lastName;
    String[] studentSubjects;
    int[] grades;

    public Student(String firstName, String lastName, int[] grades, String[] subjects) throws RuntimeException {
        this.firstName = firstName;
        this.lastName = lastName;
        if (subjects == null) {
            throw new RuntimeException(" 0 subjects were added to the student");
        }
        this.studentSubjects = subjects;

        if (grades == null) {
            throw new RuntimeException("Invalid Grade");
        } else {
            this.grades = new int[grades.length];
            for (int i = 0; i < grades.length; i++) {
                if (grades[i] > 10 || grades[i] < 0) {
                    throw new RuntimeException("Invalid Grade");
                }
            }
        }
        this.grades = grades;

    }

    public void addSubject(String newSubject, int grade) {
        if (studentSubjects == null) {
            studentSubjects = new String[1];
            studentSubjects[0] = newSubject;
        } else {
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
    }

    public int getSubjectIndex(String subject) {
        for (int j = 0; j < studentSubjects.length; j++) {
            if (studentSubjects[j].toLowerCase().equals(subject.toLowerCase())) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public void calculateGPA() {
        int gradeSum = 0;
        try {
            for (int i = 0; i < grades.length; i++) {
                gradeSum += grades[i];
            }
        } catch (NullPointerException e) {
            System.out.println(lastName + "  " + firstName + " had no grades");
        }
        System.out.println(firstName + lastName + "'s GPA is" + (gradeSum / (grades.length - 1)));
    }
}
