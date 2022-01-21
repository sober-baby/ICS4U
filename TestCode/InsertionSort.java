/*
* Name: James Tan
* Date: 12/16/2021
* Descrpiton: A program that sorts integer and string arrays in different order using insertion sort
*/
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

    //Sort an string array in accending order using insertion sort
    public static void insertionSortAlph(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        
        Scanner ss = new Scanner(System.in); //create a scanner 
        int[] arr = {5, 8, 12, 1, 3, 6, 2}; // create an array of integers
        String[] arrS = new String[5]; // create an array of strings
        ArrayList<Integer> arr1 = new ArrayList<Integer>(); // create an arraylist of integers
        for(int i = 0; i < 8; i++) { //prompt user to enter 8 integers
            System.out.println("Enter a integer: ");
            int num = ss.nextInt();
            arr1.add(num);
        }
        for(int i = 0; i < 5; i++) { //prompt user to enter 5 strings
            System.out.println("Enter a string: ");
            String str = ss.next();
            arrS[i] = str;
        }
        //call the sorting metho
        insertionSortA(arr); 
        insertionSortD(arr1);
        insertionSortAlph(arrS);
        for(int i = 0; i < arr.length; i++) { //print out the sorted array
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr1.size(); i++) { //print out the sorted array
            System.out.print(arr1.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < arrS.length; i++) { //print out the sorted array
            System.out.print(arrS[i] + " ");
        }
        
    }
}


