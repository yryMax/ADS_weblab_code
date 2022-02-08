package week2.Doubly_Linked_List_implementation;
class DLList {

    class Node {

        // Each node object has these three fields
        private Object element;

        private Node previous;

        private Node next;

        /**
         * Constructor: Creates a Node object.
         *
         * @param e the element in the Node.
         * @param p the previous Node.
         * @param n the next Node.
         */
        Node(Object e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        /**
         * Sets the element of the Node.
         *
         * @param e the new element.
         */
        public void setElement(Object e) {
            element = e;
        }

        /**
         * Returns the element of the Node.
         *
         * @return the element of the Node.
         */
        public Object getElement() {
            return element;
        }

        /**
         * Sets the next Node.
         *
         * @param n the new next Node.
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Returns the next Node.
         *
         * @return the next Node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Sets the previous Node.
         *
         * @param p the new previous Node.
         */
        public void setPrevious(Node p) {
            previous = p;
        }

        /**
         * Returns the previous Node.
         *
         * @return the previous Node.
         */
        public Node getPrevious() {
            return previous;
        }
    }

    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private Node head;

    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private Node tail;

    /** Constructor: initialises the head and tail fields as null */
    public DLList() {
        head = null;
        tail = null;
    }

    /**
     * Returns the element in the head Node.
     *
     * @return The element in the head Node.
     */
    public Object getHead() {
        return head.getElement();
    }

    /**
     * Returns the element in the tail Node.
     *
     * @return The element in the tail Node.
     */
    public Object getTail() {
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e the element to add.
     */
    public void addFirst(Object e) {
        // TODO
        Node newhead = new Node(e,null,head);
        if(head != null)head.previous = newhead;
        head = newhead;
        if(head.next == null)tail = head;
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        // TODO
        if(head == null) return null;
        Node ans = head;
        head = head.next;
        if(head == null)tail = head;
        else head.previous = null;
        return ans.element;
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e the element to add.
     */
    public void addLast(Object e) {
        // TODO
        if(tail == null)addFirst(e);
        else {
            Node newTail = new Node(e,tail,null);
            tail.next = newTail;
            tail = newTail;
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        // TODO
        if(tail == null)return null;
        if(head == tail)return removeFirst();
        Node newTail = tail.previous;
        newTail.next = null;
        Node ans = tail;
        tail = newTail;
        return ans.element;
    }

    /**
     * Returns the number of Nodes in the list.
     *
     * @return the number of Nodes in the list.
     */
    public int size() {
        // TODO
        int cnt = 0;
        Node cur = head;
        while(cur != null){
            //   System.out.println(cur.element);
            cur = cur.next;
            cnt++;
        }
        return cnt;
    }

    /**
     * Adds element e in a new Node which is inserted at position pos. The list is zero indexed, so
     * the first element in the list corresponds to position 0. This also means that `addAtPosition(0,
     * e)` has the same effect as `addFirst(e)`. If there is no Node in position pos, this method adds
     * it to the last position.
     *
     * @param pos The position to insert the element at.
     * @param e The element to add.
     */
    public void addAtPosition(int pos, Object e) {
        // TODO
        if(pos<0)return;
        else if(pos == 0)addFirst(e);
        else if(pos >= size())addLast(e);
        else {
            int cnt = pos;
            Node cur = head;
            while(cnt > 0){
                cur = cur.next;
                cnt--;
            }
            Node pre = cur.previous;
            Node thisNode = new Node(e,pre,cur);
            pre.next = thisNode;
            cur.previous = thisNode;
        }
    }

    /**
     * Remove Node at position pos and return its element. The list is zero indexed, so the first
     * element in the list corresponds to position 0. This also means that `removeFromPosition(0)` has
     * the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this
     *     method returns null.
     */
    public Object removeFromPosition(int pos) {
        // TODO
        if(pos >= size() || pos<0)return null;
        if(pos == 0)return removeFirst();
        if(pos == size() - 1)return removeLast();
        int cnt = pos;
        Node cur = head;
        while(cnt > 0){
            cur = cur.next;
            cnt--;
        }
        Node pre = cur.previous;
        Node nxt = cur.next;
        pre.next = nxt;
        nxt.previous = pre;
        return cur.element;
    }

    /** @return A new DLL that contains the elements of the current one in reversed order. */
    public DLList reverse() {
        // TODO
        DLList ans = new DLList();
        Node cur = head;
        while(cur != null){
            ans.addFirst(cur.element);
            cur = cur.next;
        }
        return ans;
    }
}