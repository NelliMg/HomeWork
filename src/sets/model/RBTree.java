package sets.model;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class RBTree<T extends Comparable<T>> implements Iterable<T> {
    private Node head;

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator(head);
    }

   class Node {
        T data;
        Node right;
        Node left;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node recursiveAdd(Node current, T item) {
        if (current == null) {
            return new Node(item);
        }

        if (current.data.compareTo(item) > 0) {
            current.left = recursiveAdd(current.left, item);
        } else if (current.data.compareTo(item) < 0) {
            current.right = recursiveAdd(current.right, item);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(T item) {
        head = recursiveAdd(head, item);
    }

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

    public boolean search(T item) {
        return recursiveSearch(head, item);
    }

    public boolean remove(T item) {
        if (search(item)) {
            findAndRemoveNode(item);
             return true;
        }
        return false;
    }

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

    private void findAndRemoveNode(T item) {
        if (head.data == item) {
            head = removeNode(head);
        } else recursiveFindParentNode(head, item);
    }

    private void recursiveFindParentNode(Node parentNode,T item) {
        if (parentNode.left.data == item) {
            parentNode.left = removeNode(parentNode.left);
        } else if (parentNode.right.data == item) {
            parentNode.right = removeNode(parentNode.right);
        } else {
            if (parentNode.data.compareTo(item) > 0) {
                recursiveFindParentNode(parentNode.left, item);
            } else {
                recursiveFindParentNode(parentNode.right, item);
            }
        }

    }

    public void print() {
        recursivePrint(head);
    }

    private void recursivePrint(Node head) {
        if (head != null) {
            recursivePrint(head.left);
            System.out.println(head.data + "  ");
            recursivePrint(head.right);
        }
    }
}
