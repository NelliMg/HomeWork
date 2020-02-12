package sets.implementation;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterator<T extends Comparable<T>> implements Iterator<T> {
   private Stack<SearchTree.Node> tStack;

    public TreeIterator(SearchTree.Node root ) {
        tStack= new Stack<>();
        while(root!=null){
            tStack.push(root);
            root=root.left;
        }
    }

    /**
     * Show if there is an element not traversed
     * @return if there is an element not traversed yet
     */
    @Override
    public boolean hasNext() {
       return !tStack.isEmpty();
    }

    /**
     * return the next smallest Element
     * @return The next element and pops it from Stack
     */
    @Override
    public T next() {
        SearchTree.Node node=tStack.pop();
        T result= (T) node.data;
        if(node.right!=null){
            node=node.right;
            while(node!=null){
                tStack.push(node);
                node=node.left;
            }
        }
        return result;
    }
}
