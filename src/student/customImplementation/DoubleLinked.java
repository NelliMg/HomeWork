package student.customImplementation;

import student.model.Student;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinked implements Iterable<Student> {
    private Node head;
    private Node end;
    private int size;

    private static class  Node {
        private Student student;
        private Node previous;
        private Node next;

        public Node(Student student, Node previous, Node next) {
            this.student = student;
            this.previous = previous;
            this.next = next;
        }
        private void setPrevious(Node previous) {
            this.previous = previous;
        }

        private void setNext(Node next) {
            this.next = next;
        }
    }

    private class CustomIterator implements Iterator<Student> {
        DoubleLinked.Node current;

        public CustomIterator(DoubleLinked.Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Student next() {
            Student s=current.student;
            current=current.next;
            return s;
        }
    }

    @Override
    public Iterator<Student> iterator() {
        return new CustomIterator(this.head);
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

    private void checkSize() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    public Student pop() throws RuntimeException {
        checkSize();
        Node cur = head;
        head = head.next;
        head.setPrevious(null);
        size--;
        return cur.student;
    }

    public Student removeLast() throws  RuntimeException{
        checkSize();
            Node cur = end;
            end = end.previous;
            end.setNext(null);
            size--;
            return cur.student;
    }

    public int size() {
        return size;
    }


}
