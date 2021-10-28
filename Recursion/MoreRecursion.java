package Recursion;

public class MoreRecursion {

    public static String laugh(int num, String currentWord){

        if(num == 0){

            return currentWord;

        }else{

            return laugh(num - 1, currentWord += "HA ");

        }
    
    }

    public static int addUp(int[] arr, int sum, int count){

        if((arr.length - count) < 0){

            return sum;

        }else{

            return addUp(arr, sum += arr[arr.length - 1 - count], count++);

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
        System.out.println(addUp(arr, sum, count));
       // System.out.println(laugh(4, blank));
        

    }
    
}
