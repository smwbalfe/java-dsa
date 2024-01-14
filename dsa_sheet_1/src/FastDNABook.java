public class FastDNABook implements SocialNetwork {

    public static class user {
        public int number;
        public String name;
        public user(String name_, int number_){
            number = number_;
            name = name_;
        }
    }

    public static int userCount = 0;

    public static user[] users = new user[200];
    public boolean[][] friendArray = new boolean[200][200];

    public void registerUser(String name){
        users[userCount] = new user(name, userCount);
        userCount++;
    }

    /* binary search which is optimized and log time*/
    public int fetchNumber(String name, int low, int high){

        if (low <= high) {
            int mid = (low + high)/2;
            if (users[mid].name.equals(name)) {
                return users[mid].number;
            }
            else if (users[mid].name.compareTo(name) < 0) {
                return fetchNumber(name, mid+1, high);
            }
            return fetchNumber(name, low, mid-1);
        }
        return -1;
    }

    public void becomeFriends(String name1, String name2){

        int name1Num = fetchNumber(name1, 0, userCount-1);
        int name2Num = fetchNumber(name2, 0, userCount-1);


        friendArray[name1Num][name2Num] = true;

    }

    public boolean areTheyFriends(String name1, String name2){
        int name1Num = fetchNumber(name1, 0, userCount-1);
        int name2Num = fetchNumber(name2, 0, userCount-1);


        return friendArray[name1Num][name2Num] || friendArray[name2Num][name1Num];


    }

}
