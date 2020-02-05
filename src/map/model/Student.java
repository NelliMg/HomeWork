package map.model;

import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private Faculty faculty;
    public Student(String firstName, String lastName, String phoneNumber, int age, Faculty faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName,lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return  firstName.equals(student.firstName) &&
                lastName.equals(student.lastName);
    }

    @Override
    public String toString() {
        return firstName +"  "+ lastName ;
    }
}
