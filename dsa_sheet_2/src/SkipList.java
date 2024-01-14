class SkipList {
    public SkipListNode[] head;
    public SkipListNode[] headRef;
    public int n = 0; // list size

    public SkipList() {
        head = new SkipListNode[5];

    }

    public void createTestList() {

        SkipListNode anne = new SkipListNode("Anne", 5);
        SkipListNode ben = new SkipListNode("Ben", 1);
        SkipListNode charlie = new SkipListNode("Charlie", 2);
        SkipListNode don = new SkipListNode("Don", 5);
        SkipListNode ernie = new SkipListNode("Ernie", 3);
        head = new SkipListNode[5];
        for (int i = 0 ; i < 3 ; i++){
            head[i] = anne;
        }

        anne.next[0] = ben;
        anne.next[1] = charlie;
        anne.next[2] = ernie;

        ben.next[0] = charlie;

        charlie.next[0] = don;
        charlie.next[1] = ernie;

        don.next[0] = ernie;

        ernie.next[0] = null;
        ernie.next[1] = null;
        ernie.next[2] = null;
        n = 5;

    }

    public void print() {

         SkipListNode[] headRef = head.clone();
         for (int lane = 4; lane > -1; lane--){

             StringBuilder string = new StringBuilder();

             while (headRef[lane] != null){

                string.append(headRef[lane].element);
                if (headRef[lane].next[lane] != null){
                      string.append(", ");
                }
                headRef[lane] = headRef[lane].next[lane];
             }
             if (string.length() > 0){
                  System.out.println(string);
             }


         }
    }

    public SkipListNode getHead(int i) {
      System.out.println("getHead(" + i + ")");
      return headRef[i];
    }

    public boolean inList(String s) {
        int currentLane = 4;

        SkipListNode[] headRef = head.clone();

        getHead(currentLane);

        while(head[currentLane] == null ){
            currentLane--;

            getHead(currentLane);

        }




        if (headRef[currentLane].element == s){
            return true;
        }

        headRef[currentLane].getNext(currentLane);

        while (headRef[currentLane].next[currentLane] != null){
            if (s.compareTo((headRef[currentLane].next[currentLane].element)) == 0){

                return true;
            }
            else if (s.compareTo((headRef[currentLane].next[currentLane].element)) > 0){
                headRef[currentLane].getNext(currentLane);
                headRef[currentLane] = headRef[currentLane].next[currentLane];
            }
            else {
                currentLane--;
                headRef[currentLane].getNext(currentLane);
                if (currentLane < 0){
                    break;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
//        SkipList sl = new SkipList();
//        sl.createTestList();
//        sl.print();
//        System.out.println();
//
//        System.out.println(sl.inList("Anne") + " should be true");
//        System.out.println(sl.inList("Ben") + " should be true");
//        System.out.println(sl.inList("Charlie") + " should be true");
//        System.out.println(sl.inList("Don") + " should be true");
//        System.out.println(sl.inList("Ernie") + " should be true");
//
//        System.out.println(sl.inList("Arya") + " should be false");
//        System.out.println(sl.inList("Elmo") + " should be false");
//        System.out.println(sl.inList("Zorro") + " should be false");


        SkipList s = new SkipList();
        s.createTestList();
        System.out.println(s.inList("Anne"));


    }
}
