package week3.Summing_trees;

import java.util.*;
class Solution {

    /**
     * Sums the values of the nodes of two n-ary trees.
     *
     * @param t1 - first tree to sum values for
     * @param t2 - second tree to sum values for
     * @return a new tree in which every node contains the sum of the values of the nodes at the
     *     corresponding positions in t1 and t2
     */
    public static Tree sum(Tree t1, Tree t2) {
        // TODO
        int value = t1.getValue() + t2.getValue();
        List<Tree>childrens1 = t1.getChildren();
        List<Tree>childrens2 = t2.getChildren();
        List<Tree>thisChildrens = new ArrayList();
        for(int i=0;i<childrens1.size();i++)thisChildrens.add(sum(childrens1.get(i),childrens2.get(i)));
        if(thisChildrens.isEmpty())return new Tree(value);
        return new Tree(value,thisChildrens);

    }
}

class Tree {

    private int value;

    private List<Tree> children;

    /**
     * Creates a tree with the given value, and no children.
     *
     * @param value The value for this tree.
     */
    public Tree(int value) {
        this.children = new LinkedList<>();
        this.value = value;
    }

    /**
     * Creates a tree with the given value and list of children.
     *
     * @param value The value for this tree.
     * @param children The subtrees for this tree.
     */
    public Tree(int value, List<Tree> children) {
        this.children = new LinkedList<>(children);
        this.value = value;
    }

    /**
     * Returns the value of this tree.
     *
     * @return The value of this tree.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the subtrees of this tree.
     *
     * @return The subtrees of this tree.
     */
    public List<Tree> getChildren() {
        return this.children;
    }

    /**
     * Checks equality of two trees.
     *
     * @param other The object to compare with.
     * @return True if the trees are equal, false otherwise.
     */
    public boolean equals(Object other) {
        if (other instanceof Tree) {
            Tree that = (Tree) other;
            return that.getValue() == this.getValue() && this.getChildren().equals(that.getChildren());
        }
        return false;
    }

    /**
     * Returns a human readable format of this tree.
     *
     * @return A string representation of this tree.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.toString(sb, 0);
        return sb.toString();
    }

    /**
     * Returns a human readable format of this tree.
     *
     * @param sb StringBuilder to append to.
     * @param depth Identation depth of this part.
     */
    private void toString(StringBuilder sb, int depth) {
        for (int i = 0; i < depth; i++) sb.append("  ");
        sb.append("<Tree ").append(this.value).append(" [");

        if (this.children.isEmpty()) {
            sb.append("]>");
            return;
        }
        // Recursively add children
        for (Tree t : this.children) {
            sb.append("\n");
            for (int i = 0; i < depth; i++) sb.append("  ");
            t.toString(sb, depth + 1);
        }
        sb.append("\n");
        for (int i = 0; i < depth; i++) sb.append("  ");
        sb.append("]>");
    }
}
