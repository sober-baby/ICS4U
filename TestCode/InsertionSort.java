package TestCode;
import java.util.*;

public class InsertionSort {

    //Sort an integer array in accending order using insertion sort
    public static void insertionSortA(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    //Sort an arraylist in decending order using insertion sort
    public static void insertionSortD(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) < key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        
        Scanner ss = new Scanner(System.in);
        int[] arr = {5, 8, 12, 1, 3, 6, 2};
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        for(int i = 0; i < 8; i++) {
            System.out.println("Enter a integer: ");
            int num = ss.nextInt();
            arr1.add(num);
        }
        insertionSortA(arr);
        insertionSortD(arr1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr1.size(); i++) {
            System.out.print(arr1.get(i) + " ");
        }
        
    }
}


