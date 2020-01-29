package student;

import student.comparator.*;
import student.customImplementation.*;
import student.service.MainService;
import student.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        DoubleLinked list = new DoubleLinked();
        DynamicArray arr = new DynamicArray();
        MainService.initListAndArray(list, arr);
        System.out.println("\nThe Dynamic Array custom implementation");
        MainService.printArr(arr);
        System.out.println("\nThe DoubleLinkedList custom implementation");
        MainService.printDoubleLinked(list);

        LinkedList<Student> linkedList = new LinkedList<Student>();
        ArrayList<Student> arrayListStudents = new ArrayList<Student>();
        for (int i = 0; i < arr.size(); i++) {
            linkedList.add(arr.get(i));
            arrayListStudents.add(arr.get(i));

        }

        Collections.sort(arrayListStudents, new StudentAgeComparator());
        System.out.println("\nThe ArrayList sorted descending by age");
        MainService.printArrayList(arrayListStudents);
        Collections.sort(arrayListStudents, new StudentFirstNameComparator());
        System.out.println("\nThe ArrayList sorted ascending by first name");
        MainService.printArrayList(arrayListStudents);
        Collections.sort(linkedList);
        System.out.println("\nThe LinkedList sorted ascending by last name");
        MainService.printLinkedList(linkedList);

    }
}
