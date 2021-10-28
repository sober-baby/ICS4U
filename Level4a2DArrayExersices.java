import java.io.*;
import java.util.*;
public class Level4a2DArrayExersices {

    public static void populate(int[][]arr){

        Scanner ss = new Scanner(System.in);

        for(int r  = 0; r<arr.length; r++){

            for(int c = 0; c<arr[r].length; c++){

                System.out.println("Enter a number: ");
                int userInput = ss.nextInt();
                arr[r][c] = userInput;

            }
        }

    }

    public static void populate2(int[][] arr) throws Exception{
        
        File test = new File("values.txt");
        Scanner ss = new Scanner(test);
        for(int r = 0; r<arr.length; r++){

            for(int c = 0; c<arr[r].length; c++ ){

                arr[r][c] = ss.nextInt();

            }
        }     
    }

    public static void display(int[][]arr){

        for(int r = 0; r<arr.length; r++){

            for(int c = 0; c<arr[r].length; c++){

                System.out.print(arr[r][c] + " ");

            }
            System.out.println();
        }
    
    }

    public static void sum(int[][]arr){

        int[] rowSum = new int[3];
        int[] columnSum = new int[4];
        for(int r = 0; r<arr.length; r++){
            
            for(int c = 0; c<arr[r].length; c++){

                System.out.print(arr[r][c] + " ");
                rowSum[r] += arr[r][c];
            

            }

            columnSum[c] += arr[r][c];       
            System.out.print("Sum: " + rowSum[r]);
            System.out.println();
        }
    
    }

    public static void main(String args[]) throws Exception{


        int[][] arr = new int[3][4];
        populate2(arr);
        display(arr);
        sum(arr);


    }



    
}
