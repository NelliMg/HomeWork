package sets;

import sets.implementation.SearchTree;

public class Main{
    public static void main(String[] args) {
        SearchTree<Integer> tree = new SearchTree<>();
        tree.add(15);
        tree.add(4);
        tree.add(10);
        tree.remove(10);

    }
}
