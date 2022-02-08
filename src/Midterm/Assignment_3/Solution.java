package Midterm.Assignment_3;

import java.util.*;

public class Solution {

    /**
     * Checks whether the given BinaryTree has the heap property for a max-heap.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree satisfies the heap property, else false.
     */
    public static boolean hasHeapProperty(BinaryTree tree) {
        // TODO
        if(tree == null)return false;
        if(!isCompleteTree(tree))return false;
        return dfs(tree);
    }
    public static boolean dfs(BinaryTree tree) {
        // TODO
        boolean ans = true;
        if(tree.hasLeft())ans = (tree.getKey()>=tree.getLeft().getKey() && dfs(tree.getLeft()));
        if(ans == false)return ans;
        if(tree.hasRight())ans = (tree.getKey()>=tree.getRight().getKey() && dfs(tree.getRight()));
        return ans;
    }
    /**
     * Checks whether the BinaryTree is complete.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isCompleteTree(BinaryTree tree) {
        // TODO
        if(tree == null)return false;
        Queue<BinaryTree> q = new LinkedList();
        List<BinaryTree> check = new ArrayList();
        q.add(tree);
        while(!q.isEmpty()){
            BinaryTree cur = q.remove();
            check.add(cur);
            if(cur.hasLeft())q.add(cur.getLeft());
            if(cur.hasRight())q.add(cur.getRight());
        }
        for(int i=0;i<check.size();i++){
            if(i*2+1<check.size()&&!check.get(i).hasLeft())return false;
            if(i*2+2<check.size()&&!check.get(i).hasRight())return false;
            if(i*2+1<check.size()&&check.get(i).getLeft()!=check.get(i*2+1))return false;
            if(i*2+2<check.size()&&check.get(i).getRight()!=check.get(i*2+2))return false;
        }
        return true;
    }
}
class BinaryTree {

    private int key;

    private BinaryTree left, right;

    /**
     * Simple constructor.
     *
     * @param key to set as key.
     */
    public BinaryTree(int key) {
        this.key = key;
    }

    /**
     * Extended constructor.
     *
     * @param key to set as key.
     * @param left to set as left child.
     * @param right to set as right child.
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
     * Gives the left child of this node.
     *
     * @return the left child.
     */
    public BinaryTree getLeft() {
        return left;
    }

    /**
     * Gives the right child of this node.
     *
     * @return the right child.
     */
    public BinaryTree getRight() {
        return right;
    }

    /**
     * Indicates whether this node has a left child.
     *
     * @return true if there is a left child, false otherwise
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * Indicates whether this node has a right child.
     *
     * @return true if there is a right child, false otherwise
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * Sets the left child of this node.
     *
     * @param left to set
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * Sets the right child of this node.
     *
     * @param right to set
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" + "key=" + key + ", left=" + left + ", right=" + right + '}';
    }
}
