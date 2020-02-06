package sets;

import sets.model.MySet;

public class Main {
    public static void main(String[] args) {
        MySet<Integer> set= new MySet<>();
        set.add(15);
        set.add(100);
        set.add(187);
        set.add(61);
        set.add(0);
        set.add(485);
        set.add(87);
        set.add(0);
        set.remove(15);
        set.print();
    }
}
