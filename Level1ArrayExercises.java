import java.util.*;
public class Level1ArrayExercises {


    public static void initializeArray(int[] arr){

        Arrays.fill(arr, -1);

    }

    public static void enterFromKeyboard(int[] arr){

        for(int i = 0; i<arr.length; i++){

            Scanner ss = new Scanner (System.in); 

            int input = ss.nextInt(); 

        }
    }

    public static void countWhole(int[] arr){

        int count = 0;

        for(int i = 0; i<arr.length; i++){

            if(arr[i]>0 && arr[i]%2 == 0){

                count++;

            }
        }

        System.out.println(count);
    }

    public static void display(int[] arr){

        for(int i = 0; i<arr.length; i++){

            if(arr[i] % 2 == 0){

                System.out.println(arr[i]);

            }
        }
    }

    public static void displayReverse(int[] arr){

        int[] arrReverse = new int[arr.length];

        int count = 0; 

        for(int i = 0; i<arr.length; i++){

            if(arr[i] % 2 == 0){

                arrReverse[i] = arr[i];  

                count++;

            }
        }

        for(int i = 0; i<count; i++){

            System.out.println(count-1-i); 

        }
    }
    
    public static void sum(int lol){ 

        
    }
    public static void main (String args[]){

        int[] arr = new int[10];

        initializeArray(arr);

        enterFromKeyboard(arr);


    }
    
}
