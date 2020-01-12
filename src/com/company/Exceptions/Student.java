package com.company.Exceptions;

class InvalidGradeException extends Exception {
    public InvalidGradeException(String s) {
        // super(s);
        System.out.println(s);
    }
}

class NoSubjectException extends Exception {
    public NoSubjectException(String s) {
        super(s);
    }
}

public class Student implements gpaStrategy {
    private String firstName;
    private String lastName;
    String[] studentSubjects;
    int[] grades;

    public Student(String firstName, String lastName, int[] grades, String[] subjects) throws InvalidGradeException, NoSubjectException {
        this.firstName = firstName;
        this.lastName = lastName;
        if (subjects == null) {
            throw new NoSubjectException(" 0 subjects were added to the student");
        }
        this.studentSubjects = subjects;

        if (grades == null) {
            throw new InvalidGradeException("Invalid Grade");
        } else {
            this.grades = new int[grades.length];
            for (int i = 0; i < grades.length; i++) {
                if (grades[i] > 10 || grades[i] < 0) {
                    throw new InvalidGradeException("Invalid Grade");
                }
            }
        }
        this.grades = grades;

    }

    public void addSubject(String newSubject) {
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
