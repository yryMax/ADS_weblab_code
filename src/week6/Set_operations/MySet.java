package week6.Set_operations;

import java.util.*;

class MySet extends HashSet<String> {

    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * Unions this set with the given other set.
     *
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();
        // TODO
        if(that == null){
            for(String ele: this)result.add(ele);
            return result;
        }
        for(String ele: this){
            result.add(ele);
        }
        for(String ele: that){
            result.add(ele);
        }
        return result;
    }

    /**
     * Intersects this set with the given other set.
     *
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        if(that == null)return result;
        // TODO
        for(String ele: this){
            if(that.contains(ele))result.add(ele);
        }
        return result;
    }

    /**
     * Gets the difference between this set and the given other set.
     *
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();
        if(that == null){
            for(String ele: this)result.add(ele);
            return result;
        }
        // TODO
        for(String ele: this){
            if(!that.contains(ele))result.add(ele);
        }
        return result;
    }

    /**
     * Gets the exclusive or between this set and the given other set.
     *
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();
        // TODO
        if(that == null){
            for(String ele: this)result.add(ele);
            return result;
        }
        for(String ele: this){
            if(!that.contains(ele))result.add(ele);
        }
        for(String ele: that){
            if(!this.contains(ele))result.add(ele);
        }
        return result;
    }

    /**
     * Converts this set to a string representation.
     *
     * @return a String representation of a MySet object
     */
    public String toString() {
        // TODO
        int flag = 0;
        String ans = "<MySet{";
        for(String ele: this){
            if(flag >0)ans +=",";
            flag = 1;
            ans += ele;
        }
        ans += "}>\n";
        return ans;

    }
}
