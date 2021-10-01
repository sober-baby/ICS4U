/*
* Name: James Tan
* Date: 2021/09/16
* Description: Manipulating integers stored by a user
*/



import java.util.*;
public class ArrayPractice {


    public static void main(String args[]){

        int arr[] = new int [10]; //Create the array
        Scanner ss = new Scanner(System.in); //Initialize scanner
        int total = 0; //Variable for the sum of all the numbers
        int temp = 0; //temparary variable for finding the smallest number
        for(int i = 0; i<10; i++){ //prompt user 10 times to put values in array and add the numbers 

            int num = ss.nextInt();
            arr[i] = num;  
            total += num;      
        }

        for(int i = 0; i<10; i++){ //printing numbers in order

            System.out.print(arr[i]);

        }

        for(int i = 9; i>=0; i--){ //printing numbers in reverse order

            System.out.print(" " + arr[i]);

        }

        System.out.println(" "); 

        
        for(int i = 0; i<10; i++){ //printing numbers that are greater or equal than 0

            if(arr[i]>=0){

                System.out.print(" " + arr[i]); 
            }

        }

        for(int i = 0; i<10; i++){ //printing numbers that are smaller than 0

            if(arr[i]<0){

                System.out.println(arr[i]); 
            }

        }

        temp = arr[0];

        for(int i = 0; i<10; i++){ //finding the smallest number 

            if(arr[i]<temp){

                temp = arr[i];

            }

        }

        System.out.println("The minimum number in the array is " + temp); //printing the smallest number
        System.out.println("The average is" + total/10); //print the average 


    }
    
}
