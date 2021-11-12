package Recursion;

public class MoreRecursion {

    public static String laugh(int num){

        if(num == 0){

            return "";

        }else{

            return laugh(num - 1) + "Ha ";

        }
    
    }

    // add up all values in an array using recursion 
    
    public static int addUp(int[] arr, int count){

        if(count == arr.length - 1){

            return arr[count];

        }else{

            return arr[count] + addUp(arr, count + 1);  

        }
    
    }

    public static int fibonaciSequence(int n) {
        
        if(n > 0 && n<3){

            return 1;
            
        }else{

            return fibonaciSequence(n-1) + fibonaciSequence(n-2); 


        }

    }

    public static void main (String args[]){

        String blank = "";
        int[] arr = {3,4,5};
        int sum = 0;
        int count = 0;
        System.out.println(addUp(arr, count));
       System.out.println(laugh(4));
        

    }
    
}
