package Endterm.Assignment_5;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class StreetTest {
    @Test
    void removeSmallExample() {
        Street s = new Street();
        House house1 = new House(1);
        House house2 = new House(2);
        House house3 = new House(3);
        House house4 = new House(4);
        House house5 = new House(5);
        House house6 = new House(6);
        createHousesDLL(List.of(house2, house4, house6), s.headEven, s.tailEven);
        createHousesDLL(List.of(house1, house3, house5), s.headOdd, s.tailOdd);
        s.headEven.getNext().getOpposingHouses().add(house1);
        s.headEven.getNext().getNext().getOpposingHouses().add(house3);
        s.headEven.getNext().getNext().getNext().getOpposingHouses().add(house3);
        s.headEven.getNext().getNext().getNext().getOpposingHouses().add(house5);
        s.headOdd.getNext().getOpposingHouses().add(house2);
        s.headOdd.getNext().getNext().getOpposingHouses().add(house4);
        s.headOdd.getNext().getNext().getOpposingHouses().add(house6);
        s.headOdd.getNext().getNext().getNext().getOpposingHouses().add(house6);
        assertEquals(Set.of(house1), s.headEven.getNext().getOpposingHouses());
        assertSame(house1, s.removeHouse(1));
        assertEquals(Set.of(), s.headEven.getNext().getOpposingHouses());
    }

    @Test
    void collectExample() {
        Street s = new Street();
        House house1 = new House(1);
        House house2 = new House(2);
        House house3 = new House(3);
        House house4 = new House(4);
        House house5 = new House(5);
        House house6 = new House(6);
        createHousesDLL(List.of(house2, house4, house6), s.headEven, s.tailEven);
        createHousesDLL(List.of(house1, house3, house5), s.headOdd, s.tailOdd);
        s.headEven.getNext().getOpposingHouses().add(house1);
        s.headEven.getNext().getNext().getOpposingHouses().add(house3);
        s.headEven.getNext().getNext().getNext().getOpposingHouses().add(house3);
        s.headEven.getNext().getNext().getNext().getOpposingHouses().add(house5);
        s.headOdd.getNext().getOpposingHouses().add(house2);
        s.headOdd.getNext().getNext().getOpposingHouses().add(house4);
        s.headOdd.getNext().getNext().getOpposingHouses().add(house6);
        s.headOdd.getNext().getNext().getNext().getOpposingHouses().add(house6);
        assertEquals(List.of(house1, house2, house3, house4, house5, house6), s.collectAllHouses());
    }

    @Test
    void sizeOneEven() {
        Street s = new Street();
        House house2 = new House(2);
        createHousesDLL(List.of(house2), s.headEven, s.tailEven);
        assertEquals(1, s.getNumEven());
    }

    private static void createHousesDLL(List<House> houses, Node head, Node tail) {
        Node prev = head;
        for (House house : houses) {
            Node houseNode = new Node(house);
            prev.setNext(houseNode);
            houseNode.setPrev(prev);
            prev = houseNode;
        }
        prev.setNext(tail);
        tail.setPrev(prev);
    }
}