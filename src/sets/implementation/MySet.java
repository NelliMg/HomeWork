package sets.implementation;

import org.jetbrains.annotations.NotNull;

public class MySet<T extends Comparable<T>> {
    private SearchTree<T> setTree;
    private int size;

    public MySet() {
        this.setTree = new SearchTree<>();
    }
    public boolean add(@NotNull T item){
        return setTree.add(item);
    }
    public boolean contains(@NotNull T item){
        return setTree.search(item);
    }
    public boolean remove(@NotNull T item){
        if(!setTree.search(item)){
            return false;
        }else{
            setTree.remove(item);
            size--;
            return true;
        }
    }
    public int getSize(){ return size;}
    public void print(){ setTree.print();}
}
