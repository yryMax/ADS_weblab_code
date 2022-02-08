package week7.Flatten_BST;

import java.util.*;

class Solution {

    /**
     * Return all elements in the given BST in descending order.
     *
     * @param tree
     *     The BST to traverse.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree) {
        // TODO
        List<Integer> ans = new ArrayList();
        List tmp;
        if(tree.hasRight()){
            tmp = descendingOrder(tree.getRight());
            ans.addAll(tmp);
            tmp.clear();
        }
        ans.add(tree.getKey());
        if(tree.hasLeft()){
            tmp = descendingOrder(tree.getLeft());
            ans.addAll(tmp);
            tmp.clear();
        }
        return ans;
    }
}
class BinaryTree {

    private int key;

    private BinaryTree left, right;

    /**
     * Simple constructor.
     *
     * @param key
     *     to set as key.
     */
    public BinaryTree(int key) {
        this.key = key;
    }

    /**
     * Extended constructor.
     *
     * @param key
     *     to set as key.
     * @param left
     *     to set as left child.
     * @param right
     *     to set as right child.
     */
    public BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this.key = key;
        setLeft(left);
        setRight(right);
    }

    public int getKey() {
        return key;
    }

    /**
     * @return the left child.
     */
    public BinaryTree getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public BinaryTree getRight() {
        return right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left
     *     to set
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * @param right
     *     to set
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
