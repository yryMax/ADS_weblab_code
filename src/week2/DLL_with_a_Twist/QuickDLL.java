package week2.DLL_with_a_Twist;

class QuickDLL {

    // Each QuickDLL has one field head, which points to the starting Node of QuickDLL.
    private Node head;

    // Each QuickDLL has one field tail, which points to the last Node of QuickDLL.
    private Node tail;

    // Each QuickDLL has one size field, which represents the number of elements in the QuickDLL.
    private int size;

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public QuickDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @return The head Node of the DLL
     */
    public Node getHead() {
        return head;
    }

    /**
     * @return The tail Node of the DLL
     */
    public Node getTail() {
        return tail;
    }

    /**
     * @return the number of elements in the WeirdDLL.
     */
    public int getSize() {
        return size;
    }

    /**
     * @param index
     *     of the node to get
     * @return O(n) operation to get the node at position index.
     */
    public Node atPosition(int index) {
        if (index < 0)
            return null;
        Node finger = head;
        while (index > 0 && finger != null) {
            finger = finger.getNext(0);
            index -= 1;
        }
        return finger;
    }

    public void addFirst(Object value) {
        // TODO
        Node newHead = new Node(value);
        newHead.pointers[0] = atPosition(0);
        newHead.pointers[1] = atPosition(2);
        newHead.pointers[2] = atPosition(8);
        newHead.pointers[3] = atPosition(13);
        if(head != null)head.previous = newHead;
        else tail = newHead;
        head = newHead;
        size++;
    }

    public void addLast(Object value) {
        // TODO
        if(head == null)addFirst(value);
        else{
            Node newTail = new Node(value);
            newTail.previous = tail;
            if(atPosition(size - 3) != null)atPosition(size - 3).pointers[1] = newTail;
            if(atPosition(size - 9) != null)atPosition(size - 9).pointers[2] = newTail;
            if(atPosition(size - 14) != null)atPosition(size - 14).pointers[3] = newTail;
            if(atPosition(size - 1) != null)atPosition(size - 1).pointers[0] = newTail;
            tail = newTail;
            size++;
        }

    }
    public void insert(int index, Object value) {
        // TODO
        if(index >= size)addLast(value);
        else if(index == 0)addFirst(value);
        else {
            Node newNode = new Node(value);
            newNode.pointers[0] = atPosition(index);
            newNode.previous = atPosition(index - 1);
            atPosition(index).previous = newNode;
            atPosition(index - 1).pointers[0] = newNode;

            size++;
            for(int i=0; i<size;i++){
                atPosition(i).pointers[1] = atPosition(i+3);
                atPosition(i).pointers[2] = atPosition(i+9);
                atPosition(i).pointers[3] = atPosition(i+14);
            }

        }
    }

    class Node {

        // Each node object has these two fields
        private Object element;

        // Pointers are null when they point to a node that does not exist.
        private Node[] pointers;

        private Node previous;

        // Constructor: Creates a Node object with element = e and no pointers set.
        Node(Object e) {
            element = e;
            pointers = new Node[4];
            previous = null;
        }

        // This function gets Object e as input and sets e as the element of the Node
        public void setElement(Object e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public Object getElement() {
            return element;
        }

        /**
         * @param pointer_index
         *     the pointer index to update.
         * @param n
         *     the node to set in the pointer table
         */
        public void setNext(int pointer_index, Node n) {
            pointers[pointer_index] = n;
        }

        /**
         * @param pointer_index
         *     Number between 0 and 3 to indicate which pointer is required
         * @return the correct next_node based on the pointer_index
         */
        public Node getNext(int pointer_index) {
            return pointers[pointer_index];
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "Node{" + "element=" + element + '}';
        }
    }
}

