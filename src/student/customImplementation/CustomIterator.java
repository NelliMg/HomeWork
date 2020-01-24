package student.customImplementation;

import student.customImplementation.DoubleLinked;
import student.model.*;
import java.util.Iterator;

public class CustomIterator implements Iterator<Student> {
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
