package student.customImplementations;

import student.models.Student;

import java.util.Comparator;

public class StudentFirstNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getFirstName().compareTo(s2.getFirstName());
    }

    }
