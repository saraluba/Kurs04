package Selection;

public class SelectionSort {
    public static void sort(int array[]){
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for(int j=i+1; j<n; j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            int change = array[min];
            array[min] = array[i];
            array[i] = change;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
