import java.util.*;
public class test{


    public static void enterFromKeyboard(int[] arr){

        Scanner ss = new Scanner (System.in); 

        for(int i = 0; i<arr.length; i++){

            System.out.println("Enter a number"); 

            int input = ss.nextInt(); 

            arr[i] = input; 

        }
    }


    public static void main(String args[]){
    
        Scanner ss = new Scanner(System.in);

        int[] arr = new int[10];

        enterFromKeyboard(arr);

       for(int i = 0; i<arr.length; i++){

           System.out.println(arr[i]);

       }


    
    
    
    
    
    
    
    
    }
}

