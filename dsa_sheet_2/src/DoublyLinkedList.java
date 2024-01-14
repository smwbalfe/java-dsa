class DoublyLinkedList {
    public ListNode2 head = null;
    public ListNode2 tail = null;
    public int n = 0; // list size

	// TODO implement this...

     /* Adds to the start of the linked list, i.e. makes the object. the new head */
    public void addFirst(Object o){
        if (n == 0 ){
            head = new ListNode2(o, null, null);
            tail = head;
        } else {
            ListNode2 temp = head;
            head = new ListNode2(o, null, head);
            temp.prev = head;
        }
        n++;
    }

    /* obtain the item at the specified index */
    public Object get(int index){
        if (n == 0 ){
            System.out.println("There is literally nothing in the linked list");
        }
        ListNode2 headRef = head;
        for (int i = 0 ; i < index; i++){
            headRef = headRef.next;
        }
        return headRef.element;
    }

    public void insert(Object o, int index){
        /* check they are adding within the valid range*/
        if (index < 0 || index > n){
            System.out.println("invalid index position");
        }

        /* insert as the new head */
        if (index == 0){
            addFirst(o);
            return;
        }

        /* insert as the new tail */

        if (index == n){
            add(o);
            return;
        }

        /* otherwise, locate item at the position we wish to insert into*/
        ListNode2 headRef = head;
        for (int i = 0; i < index; i++){
            headRef = headRef.next;
        }

        /*
        *  headRef holds the item already at this location, therefore
        *  we update its pointer to our new node which points to what headRef was pointing to.
        */

        ListNode2 tempNode = new ListNode2(o, headRef.prev, headRef);
        headRef.prev.next = tempNode;
        headRef.prev = tempNode;
        n++;

    }

     public void add(Object o){
        ListNode2 newTail = new ListNode2(null, null, null);

        /* adding to end with empty list just add as head*/
        if (head == null){
            addFirst(o);
        }
        else{
            /* connect old tail next pointer to the new tail */
            newTail = new ListNode2(o, tail, null);
            tail.next = newTail;
        }
        tail = newTail;
        n++;
    }

    public void remove(int index){
         if (index < 0 || index > n){
            System.out.println("invalid index position");
        }
        if (head == null){
            return;
        }

        /* remove the head*/
        if (index == 0){
            ListNode2 tempHead = head;
            head = tempHead.next;
            /* if there is one item in the list its a special case where previous*/
            if (head != null){
                head.prev = null;
            }
            n--;
            return;
        }

        /* remove the tail */
        if (index == n-1){
            ListNode2 headRef = head;

            /* locate what was pointing to tail originally */
            for (int i = 0; i < n-2; i++){
                headRef = headRef.next;
            }
            /* now points to nothing as the tail has been removed */
            tail = headRef;
            headRef.next = null;
            n--;
            return;
        }

        ListNode2 headRef = head;

        for (int i =  0; i < index-1; i++){
            headRef = headRef.next;
        }
        /* the item before we remove now skips the item we chose to remove */


        headRef.next.next.prev = headRef;
        headRef.next = headRef.next.next;
        n--;
    }
    /**
     * Prints out the elements in the list from the first to the last (front to back) and then from the last to the first
     * (back to front). This is useful to test whether the list nodes are connected correctly with next and prev references.
     */
    public void print() {
        // no elements to print for empty list
        if (head == null) {
            System.out.println("list empty.");
            return;
        }

        // follow next references to list elements from the front to the back of the list
        System.out.print("front to back: ");
        ListNode2 node = head;
        System.out.print(node.element + " ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.element + " ");
        }

        // follow prev references to list elements from the back to the front of the list
        System.out.print("-- and back to front: ");
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.prev;
        }
        System.out.println();
    }
}
