package week2.Remove_last_occurrence_in_ArrayList;
import java.util.*;
public class Solution {
    /**
     * Removes all elements from the ArrayList, using the removeLastOccurrence method.
     *
     * @param list to remove the elements from.
     */
    public static void removeAll(ArrayList<Integer> list) {
        // TODO
        while(list.isEmpty() == false)removeLastOccurrence(list.get(0), list);
    }

    /**
     * Takes an ArrayList and removes last occurrence of x, shifting the rest of the elements left.
     * I.e. [5, 1, 5, 9, 8], with x = 5 would result in: [5, 1, 9, 8]. Note that this method does not
     * return a new list. Instead, the list that is passed as a parameter is changed.
     *
     * @param list to remove an element from.
     * @param x element value to look for
     */
    public static void removeLastOccurrence(int x, ArrayList<Integer> list) {
        // TODO
        if(list.lastIndexOf(x)<0)return;
        list.remove(list.lastIndexOf(x));

    }
}
