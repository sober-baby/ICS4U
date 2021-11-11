package Recursion;

public class EvenMoreRecursion {

   public static int length(String s){   
        
       if(s.equals("")){

        return 0;

       }else{

        return length(s.substring(1)) + 1; 

       }
    }

    public static int calculateSum(int n){

        if(n == 0){

            return 0;

        }else{

            return n + calculateSum(n-1) ; 
        }
    }

    public static String reverseString(String s){

        if(s.equals("")){

            return s; 

        }else{

            return reverseString(s.substring(1)) + s.charAt(0); 


        }

      
    }
    
    public static void main (String args[]){

        String word = "James";
        System.out.println(length(word)); 
        System.out.println(calculateSum(5)); 
        System.out.println(reverseString(word));
        System.out.println(word.charAt(0));
        
    }
}
