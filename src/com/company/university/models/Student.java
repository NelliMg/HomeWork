package com.company.university.models;


import com.company.university.customExceptions.InvalidGradeException;
import com.company.university.customExceptions.NoSubjectException;
import com.company.university.services.GpaStrategy;

public class Student implements GpaStrategy {
    private String firstName;
    private String lastName;
    private String[] studentSubjects;
    private int[] grades;

    public Student(String firstName, String lastName, int[] grades, String[] subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentSubjects = subjects;
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
            curGrades[grades.length] = grade;
            grades = curGrades;
        }
    }

    public int getSubjectIndex(String subject) {
        if(studentSubjects==null){
            throw new NoSubjectException("The Student has no subjects");
        }else{
        for (int j = 0; j < studentSubjects.length; j++) {
            if (studentSubjects[j].toLowerCase().equals(subject.toLowerCase())) {
                return j;
            }
        }}
        return -1;
    }
    public int [] getGrades(){
        return this.grades;
    }

    @Override
    public void calculateGPA() throws RuntimeException {

        if (grades == null) {
            throw new InvalidGradeException("No gardes were added");
        } else {
            int gradeSum = 0;
            for (int i = 0; i < grades.length; i++) {
                if (grades[i] < 0 || grades[i] > 10) {
                    throw new InvalidGradeException("Grade was lower then 0 or higher then 10");
                } else {

                    gradeSum += grades[i];
                }
            }
            double average = 0;
            try {
                average = gradeSum / (grades.length - 1);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }
            System.out.println(String.format(" %s %s's GPA is %f", lastName, firstName, average));
        }

    }
}
