package week7.The_color_of_the_Tree;

class Solution {

    /**
     * Checks whether the given BinaryTree is a Red Black Tree.
     *
     * @param tree
     *     BinaryTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     */
    public static int result;
    public static boolean isRedBlackTree(BinaryTree tree) {
        // TODO
        if(tree == null)return false;
        if(!tree.isBlack())return false;
        result = -1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return dfs(tree,0,null) && dfsdfs(tree,min,max);
    }

    public static boolean dfs(BinaryTree tree,int depth,BinaryTree fa){
        if(tree == null){
            if(result == -1){
                result = depth;
                return true;
            }
            return depth == result;
        }
        if(fa!=null&&fa.isRed()&&tree.isRed())return false;
        int newdepth = depth;
        if(tree.isBlack())newdepth++;
        return dfs(tree.getLeft(),newdepth,tree) && dfs(tree.getRight(),newdepth,tree);
    }
    public static boolean dfsdfs(BinaryTree t,int l,int r){
        if(t.getValue()<l || t.getValue()>r)return false;
        if(t.hasLeft() && !dfsdfs(t.getLeft(),l,t.getValue()-1))return false;
        if(t.hasRight()&& !dfsdfs(t.getRight(),t.getValue()+1,r))return false;
        return true;
    }
}
class BinaryTree {

    private int value;

    private BinaryTree left, right;

    private boolean isRed;

    /**
     * Simple constructor.
     *
     * @param value
     *     Value for this tree set as value.
     * @param isRed
     *     True if this node is red, false otherwise.
     */
    public BinaryTree(int value, boolean isRed) {
        this.value = value;
        this.isRed = isRed;
    }

    /**
     * Extended constructor.
     *
     * @param value
     *     to set as value.
     * @param left
     *     to set as left child.
     * @param right
     *     to set as right child.
     */
    public BinaryTree(int value, boolean isRed, BinaryTree left, BinaryTree right) {
        this(value, isRed);
        setLeft(left);
        setRight(right);
    }

    /**
     * @return the value of this tree.
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value
     *     the new value of this tree.
     */
    public void setValue(int value) {
        this.value = value;
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

    /**
     * @return true if this node is red, false otherwise.
     */
    public boolean isRed() {
        return isRed;
    }

    /**
     * @return true if this node is black, false otherwise.
     */
    public boolean isBlack() {
        return !isRed;
    }

    /**
     * @return True if the tree has a left child, false otherwise.
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * @return True if the tree has a right child, false otherwise.
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left
     *     Left subtree to set.
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * @param right
     *     Right subtree to set.
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    /**
     * @param red
     *     True if the new color is red, false otherwise.
     */
    public void setRed(boolean red) {
        isRed = red;
    }
}
