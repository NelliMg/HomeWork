package map;

import map.model.Faculty;
import map.model.Student;
import map.service.MainService;
import map.service.MapService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        MainService.initStudentsList(students);
        System.out.println("How many times does students' name repeat");
        Map mapStudents= MapService.getMap(students);
        MapService.printMap(mapStudents);

        System.out.println("\nHow many students in each faculty");
        Map mapFaculties= MapService.getEnumMap(students);
        MapService.printMap(mapFaculties);
    }
}
