package com.company.Exceptions;

import java.util.Scanner;

class NoStudentException extends Exception {
    public NoStudentException(String message) {
        super(message);
    }
}

public class Group implements gpaStrategy {
    public static Scanner input = new Scanner(System.in);
    String groupName;
    Student[] students;
    String[] groupSubjects;

    public Group(String groupName, Student[] students, String[] groupSubjects) throws NoStudentException, NoSubjectException {
        this.groupName = groupName;
        if (students == null) {
            throw new NoStudentException("No students were added to group " + groupName);
        }
        this.students = students;
        if (groupSubjects == null) {
            throw new NoSubjectException("No subjects were added to group " + groupName);
        }
        this.groupSubjects = groupSubjects;

    }

    public void addSubject(String newSubject) {
        if (groupSubjects == null) {
            groupSubjects = new String[1];
            groupSubjects[0] = newSubject;
        } else {
            String[] curSubjects = new String[groupSubjects.length + 1];
            for (int i = 0; i < groupSubjects.length; i++) {
                curSubjects[i] = groupSubjects[i];
            }
            curSubjects[groupSubjects.length] = newSubject;
            this.groupSubjects = curSubjects;
            for (int i = 0; i < students.length; i++) {
                students[i].addSubject(newSubject);
            }
        }
    }

    public void addStudent(Student newStudent) {
        boolean sameSubjects = true;
        for (int i = 0; i < newStudent.studentSubjects.length; i++) {
            if (!newStudent.studentSubjects[i].equals(groupSubjects[i]) || newStudent.studentSubjects.length != groupSubjects.length) {
                sameSubjects = false;
                break;
            }
        }
        if (sameSubjects) {
            if (students == null) {
                students = new Student[1];
                students[0] = newStudent;
            } else {
                Student[] curStudents = new Student[students.length + 1];
                for (int i = 0; i < students.length; i++) {
                    curStudents[i] = students[i];
                }
                curStudents[groupSubjects.length] = newStudent;
                this.students = curStudents;
            }
        }
    }

    public boolean subjectExists(String curSubject) {
        for (int i = 0; i < groupSubjects.length; i++) {
            if (curSubject.toLowerCase().equals(groupSubjects[i].toLowerCase())) {
                return true;
            }
        }
        System.out.println("No subject " + curSubject + " Was faound in " + groupName);
        return false;
    }

    public int getSubjectIndex(String subject) {
        for (int j = 0; j < groupSubjects.length; j++) {
            if (groupSubjects[j].toLowerCase().equals(subject.toLowerCase())) {
                return j;
            }
        }
        System.out.println("No subject" + subject + "Was faound in " + groupName);
        return -1;
    }

    @Override
    public void calculateGPA() {
        System.out.println("Which subject do you want to calculate the GPA for?\n Please enter the name of the subject");
        for (int i = 0; i < groupSubjects.length; i++) {
            System.out.println((i + 1) + ": " + groupSubjects[i]);
        }
        boolean subExists = false;
        String curSubject = "";
        while (!subExists) {
            curSubject = input.nextLine();
            if (subjectExists(curSubject)) {
                subExists = true;

            } else {
                System.out.println("You have entered a wrong subject, please try again");
            }
        }
        int gradeSum = 0, count = 0, subjectIndex = 0;
        try {
            for (int k = 0; k < students.length; k++) {
                count++;
                gradeSum += students[k].grades[subjectIndex];


            }
        } catch (Exception e) {
            System.out.println(" An error occured during calculation the GPA for a group.");
        }
        try {
            System.out.println("The GPA for University from" + curSubject + "is" + (gradeSum / count));
        } catch (ArithmeticException e) {
            System.out.println("divion to zero");
        }


    }
}
