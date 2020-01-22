package student.models;

public class ComparableStudent implements Comparable<ComparableStudent> {
   private String firstName;
   private String lastName;
   private int age;

    public ComparableStudent(String firstName, String lastName, int age) {
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
    public int compareTo(ComparableStudent comparableStudent) {
        String comparableLastName = comparableStudent.getLastName();
        return this.lastName.compareTo(comparableLastName);
    }
}
