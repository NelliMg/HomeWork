package student.customImplementations;

import student.models.Node;
import student.models.Student;

import java.util.Iterator;

public class CustomIterator implements Iterator<Student> {
    Node current;

    public CustomIterator(DoubleLinked current) {
        this.current = current.getHead();
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public Student next() {
        Student s=current.getStudent();
        current=current.getNext();
        return s;
    }
}
