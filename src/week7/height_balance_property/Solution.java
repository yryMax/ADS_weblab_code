package week7.height_balance_property;

class Solution {

    /**
     * This method checks whether the given tree has the height-balance property.
     *
     * @param tree
     *     the tree to check.
     * @return true iff the tree has the height-balance property, false otherwise.
     */
    public static boolean flag;
    public static boolean isTreeBalanced(BinaryTree tree) {
        // TODO
        if(tree == null)return true;
        flag = true;
        dfs(tree);
        return flag;
    }
    public static int dfs(BinaryTree tree){
        int height = 0,tmp = 0;
        if(tree.hasLeft())height = dfs(tree.getLeft());
        if(tree.hasRight())tmp = dfs(tree.getRight());
        if(Math.abs(tmp-height)>1)flag = false;
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
