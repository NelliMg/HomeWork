package map.service;

import map.model.Faculty;
import map.model.Student;

import java.util.List;

public class MainService {
    public static void initStudentsList(List<Student> students) {
        final Student s1= new Student("Lili","Smith","098355652",21,Faculty.ECONOMY);
        final Student s2= new Student("Iyahna","Colton","098355652",20,Faculty.ENGLISH);
        final Student s3= new Student("Lili","Smith","098355652",21,Faculty.CHEMISTRY);
        final Student s4= new Student("Jacob","Green","098355652",30,Faculty.ECONOMY);
        final Student s5= new Student("Lili","Smith","098355652",26,Faculty.HISTORY);
        final Student s6= new Student("Jacob","Green","098355652",25,Faculty.HISTORY);
        final Student s7= new Student("Lili","Smith","098355652",21,Faculty.PHILOSOPHY);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
    }

}
