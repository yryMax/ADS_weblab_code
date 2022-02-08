package week7.Multiway_Search_Trees;

import java.util.*;

class Solution {

    /**
     * Checks whether the given MultiwaySearchTree satisfies all to conditions.
     * Our reference solution does not change this function in any way.
     *
     * @param tree
     *     MultiwaySearchTree to check.
     * @return True iff the given tree satisfies all conditions.
     */
    public static boolean isSpecialTree(MultiwaySearchTree tree) {
        return satisfiesCondition1(tree)
                && satisfiesCondition2(tree)
                && satisfiesCondition3(tree)
                && satisfiesCondition4(tree);
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should NOT change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition1(MultiwaySearchTree tree) {
        // TODO
        if(tree == null)return true;
        boolean ans = true;
        MultiwaySearchTree[] childrens = tree.getChildren();
        if(childrens == null)return true;
        if(childrens.length>7)return false;
        for(MultiwaySearchTree child: childrens){
            ans = ans && satisfiesCondition1(child);
        }
        return ans;
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should NOT change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition2(MultiwaySearchTree tree) {
        // TODO
        if(tree == null)return true;
        return dfs2(tree,true);
    }
    public static boolean isleaf(MultiwaySearchTree tree){
        MultiwaySearchTree[] childrens = tree.getChildren();
        for(MultiwaySearchTree ele : childrens)if(ele != null)return false;
        return true;
    }
    public static boolean dfs2(MultiwaySearchTree tree, boolean isRoot){
        boolean ans = true;
        if(tree == null)return true;
        if(isleaf(tree))return true;
        MultiwaySearchTree[] childrens = tree.getChildren();
        if(childrens == null)return true;
        if(isRoot == false &&childrens.length<4)return false;
        for(MultiwaySearchTree child: childrens){
            ans = ans && dfs2(child,false);
        }
        return ans;
    }
    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should NOT change the method signature (name/parameters/return type).
     */
    public static int countChildren(MultiwaySearchTree[] children) {
        int count = 0;
        for (int i = 0; i < children.length; i++)
            if (children[i] != null) count++;
        return count;
    }
    public static boolean satisfiesCondition3(MultiwaySearchTree tree) {
        // TODO
        if(tree == null)return true;
        if(isleaf(tree))return true;
        MultiwaySearchTree[] childrens = tree.getChildren();
        return countChildren(childrens) >=2;
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should NOT change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition4(MultiwaySearchTree tree) {
        // TODO
        if(tree == null)return true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return dfs4(tree,min,max);
    }

    public static boolean dfs4(MultiwaySearchTree t,int l,int r){
        if(t == null)return true;
        int[] keys = t.getKeys();
        for(int i=1;i<keys.length;i++)if(keys[i]<=keys[i-1])return false;
        if(keys[0]<l||keys[keys.length-1]>r)return false;
        MultiwaySearchTree[] childrens = t.getChildren();
        if(childrens == null)return true;
        if(keys.length+1!=childrens.length)return false;
        if(!dfs4(childrens[0],l,keys[0]-1))return false;
        if(!dfs4(childrens[childrens.length-1],keys[keys.length-1]+1,r))return false;
        for(int i=1;i<keys.length;i++){
            if(!dfs4(childrens[i],keys[i-1]+1,keys[i]-1))return false;
        }
        return true;
    }
}
class MultiwaySearchTree {

    int[] keys;

    MultiwaySearchTree[] children;

    public MultiwaySearchTree(int[] keys, MultiwaySearchTree[] children) {
        this.keys = keys;
        this.children = children;
    }

    public int[] getKeys() {
        return keys;
    }

    public MultiwaySearchTree[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "MultiwaySearchTree{" + "keys=" + Arrays.toString(keys) + '}';
    }
}
