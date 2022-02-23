package Endterm.Assignment_5;

import java.util.*;

class Street {

    // Use the fields below to store the heads and tails of the even and odd side of the street
    // Do NOT change the names of the fields or how they are initialised in the constructor!
    // You may NOT add more fields to the class.
    Node headEven;

    Node tailEven;

    Node headOdd;

    Node tailOdd;

    /**
     * Make an empty street.
     */
    public Street() {
        headEven = new Node();
        tailEven = new Node();
        headEven.setNext(tailEven);
        tailEven.setPrev(headEven);
        headOdd = new Node();
        tailOdd = new Node();
        headOdd.setNext(tailOdd);
        tailOdd.setPrev(headOdd);
    }

    /**
     * Removes a house from the street.
     * If the house does not exist, the street should be unchanged and the method should return null.
     *
     * This method must run in O(n + m) time.
     * Here is n the number of even houses, and m the number of odd houses.
     *
     * @param houseNumber number of the house to be removed from this street, if present
     * @return if present, the removed house, otherwise null
     */
    public House removeHouse(int houseNumber) {
        // TODO
        Map<House,Node>map = new HashMap();
        Node cur = null;
        Node ans = null;
        if(houseNumber%2 == 1){//odd
            cur = headOdd;
            while(cur.getNext()!=tailOdd){
                cur = cur.getNext();
                if(cur.getHouse().getHouseNumber() == houseNumber)ans = cur;
            }
            cur = headEven;
            while(cur.getNext()!=tailEven){
                cur = cur.getNext();
                map.put(cur.getHouse(),cur);
            }
        }
        else {//even
            cur = headEven;
            while(cur.getNext()!=tailEven){
                cur = cur.getNext();
                if(cur.getHouse().getHouseNumber() == houseNumber)ans = cur;
            }
            cur = headOdd;
            while(cur.getNext()!=tailOdd){
                cur = cur.getNext();
                map.put(cur.getHouse(),cur);
            }
        }
        if(ans == null)return null;
        Node prev = ans.getPrev();
        Node nxt = ans.getNext();
        prev.setNext(nxt);
        nxt.setPrev(prev);
        for(House h: ans.getOpposingHouses()){
            Node op = map.get(h);
            //  System.out.println(ans);
            //  System.out.println(op);
            HashSet<House>ss = op.getOpposingHouses();
            ss.remove(ans.getHouse());
            //  System.out.println(ss.remove(ans.getHouse()));
            op.setOpposingHouses(ss);
            //System.out.println(op);
        }
        return ans.getHouse();

    }

    /**
     * Puts all the houses in the street in a list in increasing order of house number.
     *
     * This method must run in O(n+m) time.
     * Here n is the number of even houses, and m is the number of odd houses.
     *
     * @return a list of all the houses in the street in increasing order of house number
     */
    public List<House> collectAllHouses() {
        // TODO
        Node currentOdd = headOdd;
        Node currentEven = headEven;
        List<House>ans = new ArrayList();
        while(currentOdd.getNext()!=tailOdd||currentEven.getNext()!=tailEven){
            //    System.out.println(currentOdd);
            //      System.out.println(currentEven);
            if(currentOdd.getNext() == tailOdd){
                currentEven = currentEven.getNext();
                ans.add(currentEven.getHouse());
            }
            else if(currentEven.getNext() == tailEven){
                currentOdd = currentOdd.getNext();
                ans.add(currentOdd.getHouse());
            }
            else if(currentEven.getNext().getHouse().getHouseNumber()<currentOdd.getNext().getHouse().getHouseNumber()){
                currentEven = currentEven.getNext();
                ans.add(currentEven.getHouse());
            }
            else {
                currentOdd = currentOdd.getNext();
                ans.add(currentOdd.getHouse());
            }
        }
        return ans;
    }

    /**
     * Gets the number of even numbered houses in the street.
     *
     * @return the number of houses with an even house number
     */
    public int getNumEven() {
        // TODO
        Node cur = headEven;
        int size = 0;
        while(cur.getNext()!=tailEven){
            cur = cur.getNext();
            size++;
        }
        return size;
    }
}
class House {

    private int houseNumber;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return houseNumber == house.houseNumber;
    }

    @Override
    public String toString() {
        return "House{" + houseNumber + '}';
    }
}

class Node {

    private House house;

    private Node prev;

    private Node next;

    private HashSet<House> opposingHouses = new HashSet<>();

    public Node(House house) {
        this.house = house;
    }

    public Node(House house, Node prev, Node next) {
        this.house = house;
        this.prev = prev;
        this.next = next;
    }

    public Node() {}

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public HashSet<House> getOpposingHouses() {
        return opposingHouses;
    }

    public void setOpposingHouses(HashSet<House> opposingHouses) {
        this.opposingHouses = opposingHouses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(house, node.house)
                && Objects.equals(prev, node.prev)
                && Objects.equals(next, node.next)
                && Objects.equals(opposingHouses, node.opposingHouses);
    }

    @Override
    public String toString() {
        return "Node{" + house + ", opposingHouses=" + opposingHouses.toString() + '}';
    }
}

