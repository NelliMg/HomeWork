package sets.model;

import java.util.Objects;

/**
 * A simple  class implementation of Student
 * Two private fields firstName and LastName
 */

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     *
     * @param comparableStudent recieves the Student to be compared to
     *                          compares first their Lastnames and if they are equal compares firstnames
     * @return 1 if the object is greater then the comparable object,-1 if Object is smaller and 0 if they are equal
     *
     */
    @Override
    public int compareTo(Student comparableStudent) {
        String comparableLastName = comparableStudent.getLastName();
        String comparableFirstName = comparableStudent.getFirstName();
        return this.lastName.compareTo(comparableLastName) == 0
                ? this.firstName.compareTo(comparableFirstName)
                : this.lastName.compareTo(comparableLastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
