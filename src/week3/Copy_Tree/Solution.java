package week3.Copy_Tree;

import java.util.*;

public class Solution {

    /**
     * Creates a hard copy of the n-ary tree.
     *
     * @param t The tree to create a copy of
     * @return a new tree in which every node contains the values of the nodes at the corresponding
     *     positions in t
     */
    public static Tree copy(Tree t) {
        // TODO
        if(t == null)return t;
        List<Tree> childrens = t.getChildren();
        List<Tree> subtrees = new ArrayList();
        for(Tree child: childrens)subtrees.add(copy(child));
        if(subtrees.isEmpty())return new Tree(t.getValue());
        return new Tree(t.getValue(),subtrees);
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
     * Sets the value of this tree.
     *
     * @param value The new value of this tree.
     */
    public void setValue(int value) {
        this.value = value;
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
        if (other instanceof Tree that) {
            return that.getValue() == this.getValue() && this.getChildren().equals(that.getChildren());
        }
        return false;
    }

    /**
     * Returns a human-readable format of this tree.
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
