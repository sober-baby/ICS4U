import java.util.*;
public class Level1ArrayExercises {


    public static void initializeArray(int[] arr){

        Arrays.fill(arr, -1);

    }

    public static void enterFromKeyboard(int[] arr){

        Scanner ss = new Scanner (System.in); 

        for(int i = 0; i<arr.length; i++){

            System.out.println("Enter a number"); 

            int input = ss.nextInt(); 

            arr[i] = input; 

        }
    }

    public static void countWhole(int[] arr){

        int count = 0;

        for(int i = 0; i<arr.length; i++){

            if(arr[i]>0 && arr[i] % 1 == 0 ){

                count++;

            }
        }

        System.out.println(count);
    }

    public static void display(int[] arr){

        for(int i = 0; i<arr.length; i++){

              System.out.println(arr[i]);       
        }
    }

    public static void displayReverse(int[] arr){

        for(int i = arr.length-1; i>=0; i--){

            System.out.println(arr[i]);

        }
    }

    
    public static void sum(int[] arr){

        int count = 0;
        
        for(int i = 0; i<arr.length; i++){

            count += arr[i];

        }

        System.out.println("The sum of all the numbers entered is: " + count);
        
    }

    public static void average(int[] arr){

        int count = 0;
        
        for(int i = 0; i<arr.length; i++){

            count += arr[i];

        }

        double average = count/arr.length;

        System.out.println(average); 
    }

    public static void findMax(int[]arr){

        int temp = arr[0];

        for(int i = 1; i<arr.length; i++){

            if(temp < arr[i]){

                temp = arr[i];
            }
        }

        System.out.println("The greatest number is: " + temp);


    }

    public static void findMin(int[]arr){

        int temp = arr[0];

        for(int i = 1; i<arr.length; i++){

            if(temp > arr[i]){

                temp = arr[i];
            }
        }

        System.out.println("The smallest number is: " + temp);

    }

    public static void search(int[]arr){

        Scanner ss = new Scanner (System.in); 

        System.out.println("Enter a number that you want to search");

        int userSearch = ss.nextInt();

        ArrayList<Integer> positionTracker = new ArrayList<Integer>(); 

        for(int i = 0; i<arr.length; i++){

            if(userSearch == arr[i]){

                positionTracker.add(i);

            }
        }

        System.out.print("The number: " + userSearch + " is found in the following position/index ");

        for(int i = 0; i<positionTracker.size(); i++){

            System.out.print(positionTracker.get(i) + " ");

        }

    }


    public static void main (String args[]){

        Scanner ss = new Scanner(System.in);

        int[] arr = new int[10];

        initializeArray(arr);

        enterFromKeyboard(arr);

        String input = "Y"; 

        do{

            System.out.println("Enter a to display the whole numbers"); 
            System.out.println("Enter b to display the inputted integers");
            System.out.println("Enter c to display the inputted integers in reverse order");
            System.out.println("Enter d to display the sum of all entered numbers");
            System.out.println("Enter e to calculate the average of the displayed numbers");
            System.out.println("Enter f to find the minium number");
            System.out.println("Enter g to to find the max number");
            System.out.println("Enter h to search for a number");
            System.out.println("Enter n to exit the program");
            input = ss.next();

        if(input.equalsIgnoreCase("a")){

            countWhole(arr);

        }else if(input.equalsIgnoreCase("b")){

            display(arr);

        }
        if(input.equalsIgnoreCase("c")){

            displayReverse(arr);

        }else if(input.equalsIgnoreCase("d")){

            sum(arr);

        }else if(input.equalsIgnoreCase("e")){

            average(arr);

        }else if(input.equalsIgnoreCase("f")){

            findMin(arr);

        }else if(input.equalsIgnoreCase("g")){

            findMax(arr);

        }else if(input.equalsIgnoreCase("h")){

            search(arr);

        }


            
        }while(!input.equalsIgnoreCase("N"));



        


    
    
}

}
