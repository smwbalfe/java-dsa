public class Contact implements Comparable<Contact> {
    public String firstName;
    public String lastName;

    public Contact(String f, String l) {
        firstName = f; lastName = l;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public int compareTo(Contact c) {
        // TODO implement this

        if ((c.firstName.compareTo(firstName) != 0) || (c.lastName.compareTo(lastName) != 0)){

            if (lastName.compareTo(c.lastName) != 0){

                return lastName.compareTo(c.lastName);
            }
            else if (lastName.compareTo(c.lastName) == 0){
                return firstName.compareTo(c.firstName);
            }
            else {
                return firstName.compareTo(c.firstName);
            }
        }
        return 0;
    }
}
