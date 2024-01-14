import java.util.Random;

public class SkipListNode {
    String element;
    SkipListNode[] next;

    /* random number of lanes up to a maximum of 5 */
    public SkipListNode(String s) {
        element = s;
        Random r = new Random();
        int l = 1;
        while (r.nextFloat() < 0.5 && l < 5) {
            l++;
        }
        next = new SkipListNode[l];
    }

    /* specify how many lanes you wish to have */
    public SkipListNode(String s, int lanes){
        element = s;
        next = new SkipListNode[lanes];
    }

    // Use getNext() in your inList() implementation instead of accessing the
    // next variable directly. The automarker needs this!
    public SkipListNode getNext(int i) {
      System.out.println("getNext(" + i + ")");
      return next[i];
    }
}
