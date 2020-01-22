package student.customImplementations;

import student.models.Student;

public class DynamicArray {
    private Student[] sArray;

    public void add(Student student) {
        if (sArray == null) {
            sArray = new Student[1];
            sArray[0] = student;
        } else {
            Student[] curArray = new Student[sArray.length + 1];
            for (int i = 0; i < sArray.length; i++) {
                curArray[i] = sArray[i];
            }
            curArray[sArray.length] = student;
            sArray = curArray;
        }
    }

    private void removeAt(int index) {
        if (sArray != null) {
            Student[] curArray = new Student[sArray.length - 1];
            int j = 0;
            for (int i = 0; i < sArray.length; i++) {
                if (i == index) {
                    continue;
                } else {
                    curArray[j] = sArray[i];
                    j++;
                }
            }
            sArray = curArray;
        }
    }

    public boolean remove(Student student) {
        if (sArray != null) {
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] == student) {
                    this.removeAt(i);
                    return true;
                }
            }
        }
        return false;
    }
    public int size(){
        if(sArray==null){
            return -1;
        }else{
            return sArray.length;
        }
    }
    public Student get(int index){
        if(sArray==null||sArray.length-1<index){
            return null;
        }else{
            return sArray[index];
        }
    }

    public Student[] getsArray() {
        return sArray;
    }
}
