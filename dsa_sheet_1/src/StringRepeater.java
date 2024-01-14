public class StringRepeater {
    public String repeatString(String s, int n){
        String result = ""; // 1
        for(int i=0  ; i < n  /* n+1 */; i++ /*n*/) {
            result = result + s; /* 2n*/
        }
        return result; // 1
        /* 1 + 1 + (n+1) + 3n + 1= 4n + 4 */
    }
}
