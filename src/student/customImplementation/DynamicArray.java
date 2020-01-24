package student.customImplementation;

import student.model.Student;

public class DynamicArray {
    private Student[] sArray;
    private int size;
    private int capacity = 10;

    public DynamicArray() {
        sArray = new Student[this.capacity];
    }

    public void add(Student student) {
        if (size == capacity) {
            capacity=(int)(capacity*1.5);
            Student[] curArray = new Student[capacity];
            for (int i = 0; i < size(); i++) {
                curArray[i] = sArray[i];
            }
            sArray = curArray;
        }
            sArray[size] = student;
            size++;
    }

    private void removeAt(int index) {
        for (int i = index; i < size; i++) {
            sArray[i] = sArray[i + 1];
            size--;
        }
        if (size > 10 && size < capacity / 1.5) {
            capacity=(int) (size / 1.5);
            Student[] curArray = new Student[capacity];
            for (int i = 0; i < size; i++) {
                curArray[i] = sArray[i];
            }
            sArray = curArray;
        }
    }

    public boolean remove(Student student) {
        for (int i = 0; i < size; i++) {
                if (sArray[i] == student) {
                    this.removeAt(i);
                    return true;
                }
            }
        return false;
    }

    public int size() {
        return this.size;
    }

    public Student get(int index) throws RuntimeException {
        if ( size - 1 < index || index < 0) {
            throw new IndexOutOfBoundsException();
            } else {
            return sArray[index];
        }
    }

}
