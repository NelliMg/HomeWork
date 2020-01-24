package student.service;

import student.customImplementation.DoubleLinked;
import student.customImplementation.DynamicArray;
import student.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MainService {
    public static Scanner input = new Scanner(System.in);

    public static void initListAndArray(DoubleLinked list, DynamicArray arr) {
        boolean correctInput = false;
        int studentCount = 0;
        while (!correctInput) {
            System.out.print("Enter the number of the students :");
            try {
                studentCount = input.nextInt();
                input.nextLine();
                correctInput = true;
            } catch (Exception e) {
                input.nextLine();
                System.out.print("Please enter a valid number for Student Count. ");
            }
        }

        correctInput = false;
        String lastName, firstName;
        int age = 0;
        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter the last name of the Student:");
            lastName = input.nextLine();
            System.out.print("Enter first name of the Student:");
            firstName = input.nextLine();
            while (!correctInput) {
                System.out.print("Enter the age of the Student :");
                try {
                    age = input.nextInt();
                    input.nextLine();
                    correctInput = true;
                } catch (Exception e) {
                    input.nextLine();
                    System.out.print("Please enter a valid number for Age. ");
                }
            }

            list.addLast(new Student(firstName, lastName, age));
            arr.add(new Student(firstName, lastName, age));
        }
    }

    public static void printArr(DynamicArray arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void printDoubleLinked(DoubleLinked list) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void printLinkedList(LinkedList<Student> linkedList) {
        Iterator<Student> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void printArrayList(ArrayList<Student> arrayList) {
        Iterator<Student> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
