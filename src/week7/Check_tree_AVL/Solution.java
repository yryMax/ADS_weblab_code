package week7.Check_tree_AVL;
class Solution {

    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree) {
        // TODO
        if(tree == null)return true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return (dfsdfs(tree)!=-1) && dfs(tree,min,max);
    }

    public static boolean dfs(BinaryTree t,int l,int r){
        if(t.getKey()<l || t.getKey()>r)return false;
        if(t.hasLeft() && !dfs(t.getLeft(),l,t.getKey()-1))return false;
        if(t.hasRight()&& !dfs(t.getRight(),t.getKey()+1,r))return false;
        return true;
    }
    public static int dfsdfs(BinaryTree tree){
        int height = 0,tmp = 0;
        if(tree.hasLeft())height = dfsdfs(tree.getLeft());
        if(height == -1)return -1;
        if(tree.hasRight())tmp = dfsdfs(tree.getRight());
        if(tmp == -1)return -1;
        if(Math.abs(tmp-height)>1)return -1;
        return Math.max(tmp,height)+1;
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
