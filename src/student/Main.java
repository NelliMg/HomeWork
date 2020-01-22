package student;

import student.customImplementations.DoubleLinked;
import student.customImplementations.DynamicArray;
import student.customImplementations.StudentAgeComparator;
import student.mainService.Service;
import student.models.Student;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        DoubleLinked list= new DoubleLinked();
        DynamicArray arr=new DynamicArray();
        Service.initListAndArray(list,arr);
        Service.printArr(arr);
        Service.printDoubleLinked(list);
        LinkedList<Student> linkedList= new LinkedList<Student>();
        Service.initLinkedList(linkedList);
        Collections.sort(linkedList,new StudentAgeComparator());
        Service.printLinkedList(linkedList);

    }
}
