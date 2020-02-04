package sets.model;

public class MySet<T extends Comparable<T>> {
    private RBTree<T> setTree;
    private int size;

    public MySet() {
        this.setTree = new RBTree<>();
    }
    public boolean add(T item){
        if(setTree.search(item)){
            return false;
        }else{
            setTree.add(item);
            size++;
            return true;
            }
    }
    public boolean contains(T item){
        return setTree.search(item);
    }
    public boolean remove(T item){
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
