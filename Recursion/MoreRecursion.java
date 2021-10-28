package Recursion;

public class MoreRecursion {

    public static String laugh(int num, String currentWord){

        if(num == 0){

            return currentWord;

        }else{

            return laugh(num - 1, currentWord += "HA ");

        }
    
    }

    public static int addUp(int[] arr, int sum){

        if(arr.length == 0){

            return arr.length;

        }else{

            return addUp(arr.length - 1, sum += arr[arr.length - 1]);

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

        System.out.println(laugh(4, blank));
        

    }
    
}