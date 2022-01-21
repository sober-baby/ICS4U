package TestCode;

public class Seachidng {

    public static void main(String[] args) {
        
        //use binary search to find the index of an integer in an array
        int[] arr = {121, 456, 999, 1000, 3210, 9460, 22200,}; //create an array of integers
        int target = 1000; //create a target integer
        int low = 0; //create a low bound
        int high = arr.length - 1; //create a high bound
        int mid = (low + high) / 2; //create a mid point
        while (low <= high) {  //while the low bound is less than or equal to the high bound
            if (target < arr[mid]) { //if the target is less than the mid point
                high = mid - 1; //set the high bound to the mid point minus 1
            } else if (target > arr[mid]) { //if the target is greater than the mid point
                low = mid + 1; //set the low bound to the mid point plus 1
            } else {
                System.out.println("The index of the target is: " + mid); //print the index of the target
                break; //break the loop
            }
            mid = (low + high) / 2; //set the mid point to the average of the low and high bounds
        }
    }
}


      