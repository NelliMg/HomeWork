package student.model;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return  firstName+" "+ lastName+ " "+age;
    }
    @Override
    public int compareTo(Student comparableStudent) {
        String comparableLastName = comparableStudent.getLastName();
        return this.lastName.compareTo(comparableLastName);
    }
}
