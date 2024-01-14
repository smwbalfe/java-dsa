public class Question2 {

    /**
     * Q2a: Measures a "naive" runtime of repeatString,
     * i.e. only one run measured as described in the lecture, with string "hello".
     *
     * @param n the n parameter given to repeatString
     * @return the measured "naive" runtime in nanoseconds
     */
    double naiveRuntime(int n ) {
       StringRepeater s = new StringRepeater();
       long before = System.nanoTime();
       s.repeatString("hello",n);
       long after = System.nanoTime();
       return after-before;
    }

    /**
     * Q2b: Measures a more precise runtime of repeatString,
     * as described in the lecture, with string "hello".
     *
     * @param n the n parameter given to repeatString
     * @return the measured more precise runtime in nanoseconds
     */
    double preciseRuntime(int n) {
        StringRepeater s = new StringRepeater();
        long before = System.nanoTime();
        for (long i = 0; i < n; i++){
            s.repeatString("hello", n);
        }
        long after = System.nanoTime();
        return (float)(after-before)/n;
    }

    /**
     * Q2c: Optimised version of the repeatString method.
     */
    public String optimisedRepeatString(String s, int n) {
        StringBuffer result = new StringBuffer();
        result.append(String.valueOf(s).repeat(Math.max(0, n)));
        return result.toString();
    }
    /**
     * Q2c: Measures a more precise runtime of optimisedRepeatString,
     * as described in the lecture, with string "hello".
     *
     * @param n the n parameter given to repeatString
     * @return the measured more precise runtime in nanoseconds
     */
    double preciseOptimisedRuntime(int n) {
        StringRepeater s = new StringRepeater();
        long before = System.nanoTime();
        for (long i = 0; i < n; i++){
            optimisedRepeatString("hello", n);
        }
        long after = System.nanoTime();
        return (float)(after-before)/n;
    }

    /**
     * main method with some example code for your own testing only
     */
    public static void main(String[] args) {
        StringRepeater s = new StringRepeater();
        System.out.println(s.repeatString("hello", 1) + " should output hello");

        Question2 q2 = new Question2();

        System.out.println("Naive runtime for repeatString():");
        System.out.println("T(1)=" + q2.naiveRuntime(1) + " nanoseconds");
        System.out.println("T(10)=" + q2.naiveRuntime(10) + " nanoseconds");
        System.out.println("T(100)=" + q2.naiveRuntime(100) + " nanoseconds");
        System.out.println("T(1000)=" + q2.naiveRuntime(1000) + " nanoseconds");

        System.out.println("Precise runtime for repeatString():");
        System.out.println("T(1)=" + q2.preciseRuntime(1) + " nanoseconds");
        System.out.println("T(10)=" + q2.preciseRuntime(10) + " nanoseconds");
        System.out.println("T(100)=" + q2.preciseRuntime(100) + " nanoseconds");
        System.out.println("T(1000)=" + q2.preciseRuntime(1000) + " nanoseconds");

        System.out.println(q2.optimisedRepeatString("hello", 1) + " should output hello");

        System.out.println("Precise runtime for optimisedRepeatString():");
        System.out.println("T(10)=" + q2.preciseOptimisedRuntime(10) + " nanoseconds");
        System.out.println("T(100)=" + q2.preciseOptimisedRuntime(100) + " nanoseconds");
        System.out.println("T(5000)=" + q2.preciseOptimisedRuntime(10000) + " nanoseconds");
        System.out.println("T(6000)=" + q2.preciseOptimisedRuntime(100000) + " nanoseconds");
    }
}
