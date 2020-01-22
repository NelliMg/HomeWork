package student.customImplementations;

import student.customImplementations.CustomIterator;
import student.models.Node;
import student.models.Student;

import java.util.Iterator;

public class DoubleLinked implements Iterable<Student> {
    Node head;
    private Node end;
    private int size;

    public Node getHead() {
        return head;
    }

    @Override
    public Iterator<Student> iterator() {
        return new CustomIterator(this);
    }


    public DoubleLinked() {
        size = 0;
        head = end = null;
    }

    public void push(Student s) {
        if (size == 0) {
            head = new Node(s, null, end);
            end = head;
        } else {
            Node curNode = new Node(s, null, head);
            head.setPrevious(curNode);
            head = curNode;
        }
        size++;

    }

    public void addLast(Student s) {
        if (size == 0) {
            head = new Node(s, null, end);
            end = head;
        } else {
            Node curNode = new Node(s, end, null);
            end.setNext(curNode);
            end = curNode;
        }
        size++;
    }

    public Student pop() {
        if (size == 0) {
            return null;
        } else {
            Node cur = head;
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return cur.getStudent();
        }
    }

    public Student removeLast() {
        if (size == 0) {
            return null;
        } else {
            Node cur = end;
            end = end.getPrevious();
            end.setNext(null);
            size--;
            return cur.getStudent();
        }
    }

    public int size() {
        return size;
    }


}
