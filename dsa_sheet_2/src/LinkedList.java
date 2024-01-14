public class LinkedList {

    public ListNode head = null;
    public ListNode tail = null;
    public int size = 0;

    public static void main(String[] args){
        LinkedList linkList = new LinkedList();
        linkList.addFirst("F"); // F

        System.out.println(linkList.head.element == "F" && linkList.tail.element == "F");
        linkList.remove(0); // Empty
        linkList.insert("D", 0); // D
        System.out.println(linkList.head.element == "D" && linkList.tail.element == "D");
        linkList.addFirst("C"); // C D

        System.out.println(linkList.head.element == "C" && linkList.tail.element == "D");
        linkList.insert(linkList.get(0), 1); // C C D

        System.out.println(linkList.get(0));
        System.out.println(linkList.get(1));
        System.out.println(linkList.get(2));

        linkList.addFirst("A"); // A C C D
        linkList.remove(1); // A C D
        linkList.insert("C", 3); // A C D C
        System.out.println(linkList.head.element == "A" && linkList.tail.element == "C");

        System.out.println(linkList.get(0));
        System.out.println(linkList.get(1));
        System.out.println(linkList.get(2));
        System.out.println(linkList.get(3));
    }

    /* Adds to the start of the linked list, i.e. makes the object. the new head */
    public void addFirst(Object o){
        if (size == 0) {
            head = new ListNode(o, null);
            tail = head;
        } else {
            head = new ListNode(o, head);
        }
        size++;
    }

    /* obtain the item at the specified index */
    public Object get(int index){
        if (size == 0 ){
            System.out.println("There is literally nothing in the linked list");
        }
        ListNode headRef = head;
        for (int i = 0 ; i < index; i++){
            headRef = headRef.next;
        }
        return headRef.element;
    }
    public void insert(Object item, int index){
        /* check they are adding within the valid range*/
        if (index < 0 || index > size){
            System.out.println("invalid index position");
        }

        /* insert as the new head */
        if (index == 0){
            addFirst(item);
            return;
        }

        /* insert as the new tail */
        if (index == size){
            add(item);
            return;
        }

        /* otherwise, locate item at the position we wish to insert into*/
        ListNode headRef = head;
        for (int i = 0; i < index-1; i++){
            headRef = headRef.next;
        }

        /*
        *  headRef holds the item already at this location, therefore
        *  we update its pointer to our new node which points to what headRef was pointing to.
        */

        headRef.next = new ListNode(item, headRef.next);
        size++;

    }

    public void remove(int index){
        if (index < 0 || index > size){
            System.out.println("invalid index position");
        }
        if (head == null){
            return;
        }

        /* remove the head*/
        if (index == 0){
            head = head.next;
            if (size == 0){
                tail = head;
            }
            size--;
            return;
        }

        /* remove the tail */
        if (index == size-1){
            ListNode headRef = head;

            /* locate what was pointing to tail originally */
            for (int i = 0; i < size-2; i++){
                headRef = headRef.next;
            }
            /* now points to nothing as the tail has been removed */
            tail = headRef;
            headRef.next = null;
            size--;
            return;
        }

        ListNode headRef = head;

        for (int i =  0; i < index-1; i++){
            headRef = headRef.next;
        }
        size--;
        /* the item before we remove now skips the item we chose to remove */
        headRef.next = headRef.next.next;
    }

    public void add(Object o){
        ListNode newNode = new ListNode(o, null);
        if (head == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

}