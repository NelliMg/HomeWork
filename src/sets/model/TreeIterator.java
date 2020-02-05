package sets.model;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterator<T extends Comparable<T>> implements Iterator<T> {
   private Stack<RBTree.Node> tStack;

    public TreeIterator(RBTree.Node root ) {
        tStack= new Stack<>();
        while(root!=null){
            tStack.push(root);
            root=root.left;
        }
    }

    @Override
    public boolean hasNext() {
       return !tStack.isEmpty();
    }

    @Override
    public T next() {
        RBTree.Node node=tStack.pop();
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
