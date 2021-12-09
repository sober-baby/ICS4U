/*
* Description: Program that sorts an array of integeres using quick sort
*/
package TestCode;
import java.util.*;
public class QuickSort {
    public static void main(String[] args) {

        int[] array = {5,3,2,4,1,6,8}; //array to be sorted
        quickSort(array, 0, array.length-1); //sort the array
        for(int i = 0; i<array.length; i++){ //print the array
            System.out.println(array[i]);
        }
    }
    
    //quick sort recursive method
    public static void quickSort(int[] array, int low, int high){
        if(low < high){ //base case
            int pivot = partition(array, low, high); //choose pivot and partition array 
            quickSort(array, low, pivot-1); //sort the left half
            quickSort(array, pivot+1, high); //sort the right half
        }
    }

    //partition method
    public static int partition(int[] array, int low, int high){
        int pivot = array[high]; //choose pivot
        int i = low - 1; //index of smaller element
        for(int j = low; j<high; j++){ //loop through array
            if(array[j] <= pivot){ //if element is smaller than pivot
                i++; //increment index of smaller element
                int temp = array[i]; //swap elements
                array[i] = array[j]; 
                array[j] = temp;
            }
        }
<<<<<<< HEAD
        int temp = array[i+1]; //swap elements 
        array[i+1] = array[high]; 
        array[high] = temp; 
        return i+1; //return index of pivot
=======
       
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
>>>>>>> 652aa51f39cc21b5ec2d33c77a7b62f18ebcb193
    }
}

