import java.util.ArrayList;

/**
 * @author Anonymous (do not change)
 *
 *         Question 1:
 *
 *         Implement the Shellsort algorithm
 *         (https://en.wikipedia.org/wiki/Shellsort) for an array of up to 1000
 *         signed doubles in Java. Your solution must use concrete gaps of [1,
 *         3, 7, 15, 31, 63, 127, 255, 511]. Your solution must print the
 *         (partially) sorted array after each gap on a new line in the form:
 *         [a0, a1, a2, a3, ..., an] Where an is the nth element in the
 *         (partially) sorted array (please note the space after the commas),
 *         and each element should be formatted to 2 decimal places (e.g. 1.00).
 *
 */

public class CWK2Q1 {

    

    public static void shell_sort(ArrayList<Double> array) {

        
        Integer size = array.size();

        // perform the shell sort where the gaps are the array size divided by 2, while the spaces are greater than 0
        // divide again by 2 every time to gradually decrease each of the gaps
        for (int space = size / 2; space > 0; space /= 2) {

            
            for (int i = space; i < size; i += 1) {

                //obtain the variable at the gap location
                Double temp = array.get(i);
                // define j as the current space value
                int j = i;

                // while the value of j larger/equal to gap and the array that is space away from j is greater than the item that is at that location
                while (j >= space && array.get(j - space) > temp) {
                    // set the item at j to whatever was at space away from  j as array.get(j-space) is just the item we are looking at but offset by gap
                    // comparing items that are on the other end of the gaps
                    array.set(j, array.get(j - space));

                    // reducing gap size after one run through
                    j -= space;
                }
                // store the item of temp back into j which completes the switch.
                array.set(j, temp);
            }
            System.out.printf("[ ");
            for (Double item : array) {
                System.out.printf("%f ", item);
                
            }
            System.out.printf(" ]\n");
        
        }  
    }

    public static void main(String[] args) {
        ArrayList<Double> testList = new ArrayList<Double>();
        testList.add(3.4);
        testList.add(6.55);
        testList.add(-12.2);
        testList.add(1.73);
        testList.add(140.98);
        testList.add(-4.18);
        testList.add(52.87);
        testList.add(99.14);
        testList.add(73.202);
        testList.add(-23.6);

        shell_sort(testList);

    }
}
