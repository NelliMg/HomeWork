package sets.model;

public class RBTree<T extends Comparable<T>> {
    private Node head;
    private class Node {
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

    public boolean remove(T item){
        if(search(item)){
           Node current=findNode(item);
           removeNode(current);
           return true;
        }
        return false;
    }

    private Node rebuild(Node removableNode) {
        //doesn't have child
        if (removableNode.left == null && removableNode.right == null) {
            return null;
        }
        //has both children
        if (removableNode.left != null && removableNode.right != null) {
            Node parent = removableNode, temp = removableNode;
            while (parent.right.right != null) {
                parent = parent.right;
            }
            if (parent.right.left == null) {
                removableNode = parent.right;
                removableNode.left = temp.left;
                removableNode.right = temp.right;
                parent.right = null;
            } else {
                removableNode = parent.right.left;
                removableNode.left = temp.left;
                removableNode.right = temp.right;
                parent.right.left = null;

            }
            return removableNode;
        }
        //has only left child
        if (removableNode.left != null && removableNode.right == null) {
            return removableNode.left;
        }
        //has only right child;
        if (removableNode.right != null && removableNode.left == null) {
            return removableNode.right;
        }
        return removableNode;
    }

    private void removeNode(Node removableNode) {
        if(head==removableNode){
            head=rebuild(head);
        }
        else recursiveRemoveNode(head,removableNode);
    }

    private void recursiveRemoveNode(Node parentNode, Node removableNode) {
        if(parentNode.left==removableNode){
           parentNode.left= rebuild(parentNode.left);
        }else if(parentNode.right==removableNode){
            parentNode.right=rebuild(parentNode.right);
        }
        else {
            if (parentNode.data.compareTo(removableNode.data) > 0) {
                recursiveRemoveNode(parentNode.left, removableNode);
            } else {
                recursiveRemoveNode(parentNode.right, removableNode);
            }
        }

    }

    private Node findNode(T item) {
        return recursiveFindNode(head,item);
    }

    private Node recursiveFindNode(Node head, T item) {
        if(head.data.equals(item)){
            return head;
        }
         return item.compareTo(head.data) < 0
                ? recursiveFindNode(head.left, item)
                : recursiveFindNode(head.right, item);
    }
    public  void print(){
        recursivePrint(head);
    }

    private void recursivePrint(Node head) {
        if(head!=null){
            recursivePrint(head.left);
            System.out.println(head.data+"  ");
            recursivePrint(head.right);
        }
    }
}
