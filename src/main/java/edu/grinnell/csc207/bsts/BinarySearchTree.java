package edu.grinnell.csc207.bsts;

import java.util.List;

/**
 * A binary tree that satisifies the binary search tree invariant.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    ///// From the reading

    /**
     * A node of the binary search tree.
     */
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        /**
         * @param value the value of the node
         * @param left the left child of the node
         * @param right the right child of the node
         */
        Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * @param value the value of the node
         */
        Node(T value) {
            this(value, null, null);
        }
    }

    private Node<T> root;

    /**
     * Constructs a new empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * @param node the root of the tree
     * @return the number of elements in the specified tree
     */
    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /**
     * @return the number of elements in this tree
     */
    public int size() {
        return sizeH(root);
    }

    /** @return the updated tree after inserting h into the given tree */
    private Node<T> insertH(T v, Node<T> cur) {
        if (cur == null) {
            return new Node<>(v);
        } else {
            if (v.compareTo(cur.value) < 0) {
                cur.left = this.insertH(v, cur.left);
            } else {
                cur.right = this.insertH(v, cur.right);
            }
            return cur;
        }
    }
    
    /**
     * 
     * @param v of type T value to insert
     */
    public void insert(T v) { root = insertH(v, root); }

    ///// Part 1: Contains
   
    /**
     * @param v the value to find
     * @return true iff this tree contains <code>v</code>
     */
    public boolean contains(T v) {return this.containsH(this.root, v);}

    private boolean containsH(Node<T> node, T v) {
        if (node == null) {
            return false;
        } else if (v.compareTo(node.value) == 0) {
            return true;
        } else if (v.compareTo(node.value) < 0) {
            return this.containsH(node.left, v);
        } else {
            return this.containsH(node.right, v);
        }
    }

    ///// Part 2: Ordered Traversals

    /**
     * @return the (linearized) string representation of this BST
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        toStringH(root, sb);
        if (sb.length() > 1) {sb.delete(sb.length()-2, sb.length());};
        sb.append("]");
        return sb.toString();
    }

    public void toStringH(Node<T> node, StringBuffer sb) {
        if (node == null) return;
        toStringH(node.left, sb);
        sb.append(node.value);
        sb.append(", ");
        toStringH(node.right, sb);
    }


    /**
     * @return a list contains the elements of this BST in-order.
     */
    public List<T> toList() {
        List<T> l = new ArrayList<T>(); 
        toStringH(root, sb);
        if (sb.length() > 1) {sb.delete(sb.length()-2, sb.length());};
        sb.append("]");
        return sb.toString();
    }

    public void toListH(Node<T> node, List<T> l) {
        if (node == null) return;
        toStringH(node.left, sb);
        sb.append(node.value);
        sb.append(", ");
        toStringH(node.right, sb);
    }

    ///// Part 3: BST Sorting

    /**
     * @param <T> the carrier type of the lists
     * @param lst the list to sort
     * @return a copy of <code>lst</code> but sorted
     * @implSpec <code>sort</code> runs in ___ time if the tree remains balanced. 
     */
    public static <T extends Comparable<? super T>> List<T> sort(List<T> lst) {
        throw new UnsupportedOperationException();
    }

    ///// Part 4: Deletion
  
    /*
     * The three cases of deletion are:
     * 1. (TODO: fill me in!)
     * 2. (TODO: fill me in!)
     * 3. (TOOD: fill me in!)
     */

    /**
     * Modifies the tree by deleting the first occurrence of <code>value</code> found
     * in the tree.
     *
     * @param value the value to delete
     */
    public void delete(T value) {
        throw new UnsupportedOperationException();
    }
}
