package week6.Multimaps;

import java.util.*;

class MultiMap {

    private Map<Integer, List<Integer>> map;

    /**
     * Creates a new MultiMap.
     */
    public MultiMap() {
        // TODO
        map = new HashMap();

    }

    /**
     * Gets the size of this MultiMap.
     *
     * @return The number of (key, value) pairs in the MultiMap.
     */
    public int size() {
        // TODO
        int size = 0;
        for(List<Integer> ele: map.values())size +=ele.size();
        return size;
    }

    /**
     * Gets whether this MultiMap is empty.
     *
     * @return True if the MultiMap is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO
        return map.isEmpty();
    }

    /**
     * Adds the given (key, value) pair to the MultiMap.
     *
     * @param key Key for the new item.
     * @param value New item to add to the MultiMap.
     */
    public void put(int key, int value) {
        // TODO
        List<Integer> tmp;
        if(map.containsKey(key)){
            tmp = map.get(key);
            tmp.add(value);
        }
        else {
            tmp = new ArrayList();
            tmp.add(value);
            map.put(key,tmp);
        }

    }

    /**
     * Returns all values in the MultiMap for the given key.
     *
     * @param key Key to return all entries for.
     * @return A list of all entries for the given key.
     *         If the key is not in the map, return an empty list.
     */
    public List<Integer> get(int key) {
        // TODO
        if(!map.containsKey(key))return new ArrayList();
        return map.get(key);
    }

    /**
     * Removes the given (key, value) pair from the MultiMap.
     *
     * @param key Key for the value that should be removed.
     * @param value Value to remove.
     * @return True if removal was successful, false otherwise.
     */
    public boolean remove(int key, int value) {
        // TODO
        if(!map.containsKey(key))return false;
        List<Integer> tmp = map.get(key);
        int t = tmp.indexOf(value);
        if(t<0)return false;
        tmp.remove(t);
        if(tmp.isEmpty())map.remove(key);
        return true;
    }
}

