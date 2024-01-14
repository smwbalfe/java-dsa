public class Sorter {



    public static void selectionSort(Contact[] contacts) {
        // TODO implement this

        int n = contacts.length;;
        for (int i = 0; i < n;  i++){
            int minIndex = i;

            for (int j = i+1; j < n; j++){
                if (contacts[j].compareTo(contacts[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(contacts, i, minIndex);
        }

    }

    public static void insertionSort(Contact[] contacts) {
        // TODO implement this

        for (int s = 2; s <= contacts.length; s++){
            Contact sortMe = contacts[s-1];

            int i = s - 2;

            while (i >= 0 && sortMe.compareTo(contacts[i]) < 0) {
                contacts[i+1] = contacts[i];
                i--;
            }
            contacts[i+1] = sortMe;
        }
    }

    public static void quickSort(Contact[] contacts) {
        // TODO implement this
        quicksort_(contacts, 0 , contacts.length-1);

    }

    public static void mergeSort(Contact[] contacts) {
       mergeSort(contacts, 0, contacts.length -1);
    }

    // TODO you may add additional methods here. Make them static just like
    // the other methods defined here.

    public static void quicksort_(Contact[] array, int first, int last){
        if (last - first >= 1){
            int pivotIndex;
            pivotIndex = partition(array,first, last);
            quicksort_(array, first , pivotIndex -1);
            quicksort_(array, pivotIndex+1, last);
        }
    }

    public static int partition(Contact[] a, int low, int high){
        int pi = low;
        Contact pivot = a[low];

        do {
            while (low <= high && a[low].compareTo(pivot) <= 0 ){
                low++;
            }
            while (a[high].compareTo(pivot) > 0){
                high--;
            }
            if (low < high){
                swap(a, low, high);
            }
        } while (low < high);

        swap(a, pi, high);
        pi = high;
        return pi;
    }

        public static void swap(Object [] arr, int i, int j){
        Object temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
    public static void merge(Contact[] arr, int l, int m, int r){
        Contact [] temp = new Contact[r+1];
        if (r + 1 - l >= 0) System.arraycopy(arr, l, temp, l, r + 1 - l);
        int i = l; int j = m + 1; int k = l;
        while (i <= m && j <= r){
            if ( temp[i].compareTo(temp[j])  < 0  ){
               arr[k] = temp[i]; i++;
            }
            else {
                arr[k] = temp[j]; j++;
            }
            k++;
        }
        while( i <= m){
            arr[k] = temp[i];
            k++; i++;
        }

    }
    public static void mergeSort(Contact[] arr, int l, int r){
        if (r > l){
            int middle = l + (r-l)/2;

            mergeSort(arr, l,middle);
            mergeSort(arr, middle+1, r);
            merge(arr, l, middle, r);

        }
    }
}
