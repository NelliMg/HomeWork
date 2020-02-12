package sets.implementation;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 *  Set is a collection that doesn't keep duplicates.
 *  Under MySet work Search tree.
 * @param <T> is type of parameter keeped in MySet
 */
public class MySet<T extends Comparable<T>> implements Iterable<T>{
    private SearchTree<T> setTree;
    private int size;

    public MySet() {
        this.setTree = new SearchTree<>();
    }

    /**
     * add the given item
     * @param item
     * @return true if was added successfully and false otherwise
     */
    public boolean add( T item){
        return setTree.add(item);
    }

    /**
     * checks if the given item exists in set
     * @param item
     * @return true if contains false otherwise
     */
    public boolean contains(T item){
        return setTree.search(item);
    }

    /**
     * removes the given item
     * @param item
     * @return true if was removed successfully and false otherwise
     */
    public boolean remove(T item){
        if(!setTree.search(item)){
            return false;
        }else{
            setTree.remove(item);
            size--;
            return true;
        }
    }

    /**
     *
     * @return the count of objects in MySet
     */
    public int getSize(){ return size;}

    /**
     * prints the items in set in ascending order
     */
    public void print(){ setTree.print();}

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return setTree.iterator();
    }
}
