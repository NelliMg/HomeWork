package sets.implementation;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Generic search tree implementation
 * that if Traversed from left to right will bew sorted in ascending array
 * @param <T>
 */

public class SearchTree<T extends Comparable<T>> implements Iterable<T> {
    private Node head;
    private  boolean added=true;

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator(head);
    }

    /**
     * Node class to store Tree connections
     * Each Node has information about it's right and left Node and Stores a Object of type <T>
     */
   class Node {
        T data;
        Node right;
        Node left;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * recieves two parameters current node and the item to be added
     * after checking if current is null it recursively calls the function for it's left Node or Right Node
     * depending on the item being greater or smaller then the item stored in current
     * @param current
     * @param item    is the item to be added to the tree
     * @return the new node if current was null and the same Node if it wasn't null
     */
    private Node recursiveAdd(Node current, T item) {
        if (current == null) {
            added=true;
            return new Node(item);
        }else if (current.data.compareTo(item) > 0) {
            current.left = recursiveAdd(current.left, item);
        } else if (current.data.compareTo(item) < 0) {
            current.right = recursiveAdd(current.right, item);
        }
        return current;
    }

    /**
     * recieves the item to be added to the tree
     * @param item
     * @return false if the item existed/true if it didn't exist and was successfully added
     */
    public boolean add(T item) {
        if(item==null){
            throw  new RuntimeException("You tried to add a null item");
        }
        added=false;
        head = recursiveAdd(head, item);
        return added;
      }

    /**
     *
     * @param current item stored in it is compared with the other item received by the function
     * @param item
     * @return true if after search one of Node's stored items were equal to the item recieved by the function
     */
    private boolean recursiveSearch(Node current, T item) {
        if (current == null) {
            return false;
        }
        if (item.equals(current.data)) {
            return true;
        }
        return item.compareTo(current.data) < 0
                ? recursiveSearch(current.left, item)
                : recursiveSearch(current.right, item);
    }

    /**
     * Searches for the item in the tree
     * @param item
     * @return true if contains such item/ false if tree doesn't contain
     */
    public boolean search(T item) {
        if(item==null){
            throw  new RuntimeException("You tried to see if a null item is contained");
        }
        return recursiveSearch(head, item);
    }

    /**
     * deletes the item from the tree
     * @param item
     * @return true if removed/ false if such element was not found in the tree
     */

    public boolean remove(T item) {
        if(item==null){
            throw  new RuntimeException("You tried to remove a null item");
        }
        if (search(item)) {
            findAndRemoveNode(item);
             return true;
        }
        return false;
    }

    /**
     *  if the Node has no children it return null
     *  if the Node has only one child
     * @param removableNode
     * @return the rebuild Node
     */
    private Node removeNode(Node removableNode) {
        //doesn't have child
        if (removableNode.left == null && removableNode.right == null) {
            return null;
        }
        //has both children
        if (removableNode.left != null && removableNode.right != null) {
            Node parent = removableNode.right, temp = removableNode;
            while (parent.left.left != null) {
                parent = parent.left;
            }
            if (parent.left.right == null) {
                removableNode = parent.left;
                parent.left = null;
            } else {
                removableNode = parent.left;
                parent.left=parent.left.right;
                parent.left.right = null;
            }
            removableNode.left = temp.left;
            removableNode.right = temp.right;
            return removableNode;
        }
        //has only left child
        if (removableNode.left != null ) {
            return removableNode.left;
        }
        //has only right child;
         return removableNode.right;
    }

    /**
     * checks to see if the root is the Node to be removed removes from head
     * else tries to find the
     * @param item
     */
    private void findAndRemoveNode(T item) {
        if (head.data == item) {
            head = removeNode(head);
        } else recursiveFindNode(head, item);
    }

    /**
     *is a recursive function to find and remove the item from the tree
     * @param parentNode is the parent Node of the node to be removed
     * @param item item to be removed
     *if one of the child's of parentNode stores the item to be deleted
     */

    private void recursiveFindNode(Node parentNode, T item) {
        if (parentNode.left != null) {
            if (parentNode.left.data.equals(item)) {
                 parentNode.left = removeNode(parentNode.left);
            }
        }
        if (parentNode.right != null) {
            if (parentNode.right.data.equals(item)) {
                parentNode.right = removeNode(parentNode.right);
            }
        }
            if (parentNode.data.compareTo(item) > 0) {
                if(parentNode.left!=null){
                recursiveFindNode(parentNode.left, item);}
            } else {
                if(parentNode.right!=null){
                recursiveFindNode(parentNode.right, item);}
            }
    }

    /**
     * print the tree traversing from left to right
     */
    public void print() {
        recursivePrint(head);
    }

    /**
     * is a recursive function that gets to the farthes left Node and Prints starting from there
     * It Prints LeftNode-ParentNode-RightNode order
     * @param head
     */
    private void recursivePrint(Node head) {
        if (head != null) {
            recursivePrint(head.left);
            System.out.println(head.data + "  ");
            recursivePrint(head.right);
        }
    }
}
