import java.util.*;
public class Level2aArrayExercises {

    public static void findMax (int[] arr){

        int temp = arr[0];
        for(int i = 1; i<arr.length; i++){

            if(temp < arr[i]){

                temp = arr[i];

            }
        }

        int count = 0;

        for(int i = 0; i<arr.length; i++){
            
            if(temp == arr[i]){

                count++;

            }
        }

        System.out.println("The largest number " + temp + " occured " + count + " time(s)");


    }

    public static void findMin (int[] arr){

        int temp = arr[0];
        for(int i = 1; i<arr.length; i++){

            if(temp > arr[i]){

                temp = arr[i];

            }
        }

        int count = 0;

        for(int i = 0; i<arr.length; i++){
            
            if(temp == arr[i]){

                count++;

            }
        }

        System.out.println("The smallest number " + temp + " occured " + count + " time(s)");


    }


    public static void main (String args[]){
        
        int[] arr = {4,5,6,2,3,4,2};
        findMax(arr);
        findMin(arr);


    }
    
}
