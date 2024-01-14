import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Anonymous (do not change)
 *
 *         Question 2:
 *
 *         Implement interpolation search for a list of Strings in Java using
 *         the skeleton class provided. The method should return the position in
 *         the array if the string is present, or -1 if it is not present.
 */

 // used to override how elements are sorted of which i wish them to be sorted on the value they are on
//  https://stackoverflow.com/questions/42863823/how-to-override-compareto-java
class Element implements Comparable<Element> {
    int index;
    String value;

    Element(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public int compareTo(Element e) {
        return this.value.compareTo(e.value);
    }
}

public class CWK2Q2 {
    // method to calculate how alphabetically far apart two string are for the
    // interpolation search algorithm.
    public static int stringDistance(String string1, String string2) {

        // find the largest of the two strings as it compares each letter as it goes
        int maxlen = Math.max(string1.length(), string2.length());

        // set d to be 0
        BigDecimal d = BigDecimal.ZERO;
        // iterate over the number of characters in the largest string
        for (int i = 0; i < maxlen; i++) {
            
            int dist;
            if (i < string1.length() && i < string2.length()) {
                // calculate the distance of the specific character being looked at
                dist = string1.charAt(i) - string2.charAt(i);
            // if string 2 lengh is more than or equal to i then the distance would just be the string 1
            } else if (i < string1.length()) {
                dist = string1.charAt(i);
            // otherwise its the negated distance of string 2
            } else {
                dist = -string2.charAt(i);
            }
            // increment this and move to next character
            d = d.add(BigDecimal.valueOf(dist));
        }
        // return total.
        return d.intValue();
    }

    public static int isearch(ArrayList<String> array, String item, int low, int high){

        int position;
        

        // if high is equal to low then we are done
        // if the word being looked at compare to low/ high is less than or more than 0 respectively then run the search still
        // the item has been found if any of these become equal to one another, essentially a binary search with a different method of calculating 
        // where the next center to be read is from
        if (low < high && item.compareTo(array.get(low)) >= 0 && item.compareTo(array.get(high)) <= 0) {

            // calculate the postion which uses the lexigraphical distnace of words and the size of array to obtain
            // where to search if the above statement was hit
            position = Math.abs(low + stringDistance(item, array.get(low))
                    / stringDistance(array.get(high), array.get(low)) * (high - low)) % array.size();

            //  if you have found the item here then return it
            if (array.get(position).equals(item)) {
                return position;
            // otherwise if its lexigraphically less then set min to be + 1, vice versa max -1 
            } else if (array.get(position).compareTo(item) < 0) {
                return isearch(array, item, position + 1, high);
            } else if (array.get(position).compareTo(item) > 0) {
                return isearch(array, item, low, position - 1);
            }
        }
        return -1;
    }
    public static int interpolation_search(ArrayList<String> array, String item) {
        int high,low;
        low = 0;
        // the largest value index is the array size -1 
        high = array.size() - 1;
        return isearch(array, item, low, high);
    }

    public static void main(String[] args) {
        ArrayList<String> testList = new ArrayList<String>();
        ArrayList<Element> keepIndex = new ArrayList<Element>();
        testList.add("Hello");
        testList.add("World");
        testList.add("How");
        testList.add("Are");
        testList.add("You");

        // keep track of the original index of the element after sorting
        for (int i = 0; i < testList.size(); i++) {
            keepIndex.add(new Element(i, testList.get(i)));
        }

        // sort both lists.
        Collections.sort(keepIndex);
        Collections.sort(testList);
        int result = interpolation_search(testList, "Are");

        // map back to original order to obtain where the item was before it was sorted.
        result = keepIndex.get(result).index;
        System.out.println("Result = " + result);
    }
}