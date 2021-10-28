import java.util.*;
public class ArrayListExercises {

    public static void enterFromKeyboard(ArrayList<Integer> arr){ //Method to prompt the user to enter some numbers 
        
        Scanner ss = new Scanner(System.in);

        for(int i = 0; i<10; i++){

            System.out.println("Enter a number");
            arr.add(ss.nextInt());
            System.out.println("Do you want to keep on entering a number? Y/N");
            String check = ss.next();
            if(check.equalsIgnoreCase("N")){

                break;

            }
        }
    }

   
    public static void countWhole(ArrayList<Integer> arr){

        int count = 0;

        for(int i = 0; i<arr.size(); i++){

            if(arr.get(i)>0){

                count++;

            }
        }

        System.out.println(count);
    }

    public static void display(ArrayList<Integer> arr){

        for(int i = 0; i<arr.size(); i++){
              System.out.println(arr.get(i));       
        }
    }
    
    public static void displayReverse(ArrayList<Integer> arr){

        for(int i = arr.size()-1; i>=0; i--){
            System.out.println(arr.get(i));

        }
    }

    public static void sum(ArrayList<Integer> arr){

        int count = 0;    
        for(int i = 0; i<arr.size(); i++){

            count += arr.get(i);

        }

        System.out.println("The sum of all the numbers entered is: " + count);
   
    }

    public static void average(ArrayList<Integer> arr){

        double count = 0;
        
        for(int i = 0; i<arr.size(); i++){

            count += arr.get(i);

        }

        double average = count/arr.size();

        System.out.println(average); 
    }

    public static void findMax(ArrayList<Integer> arr){

        int temp = arr.get(0);

        for(int i = 1; i<arr.size(); i++){

            if(temp < arr.get(i)){

                temp = arr.get(i);
            }
        }

        System.out.println("The greatest number is: " + temp);


    }

    public static void findMin(ArrayList<Integer> arr){

        int temp = arr.get(0);

        for(int i = 1; i<arr.size(); i++){

            if(temp > arr.get(i)){

                temp = arr.get(i);
            }
        }

        System.out.println("The smallest number is: " + temp);
    }

    public static void search(ArrayList<Integer> arr){

        Scanner ss = new Scanner (System.in); 

        System.out.println("Enter a number that you want to search");

        int userSearch = ss.nextInt();

        ArrayList<Integer> positionTracker = new ArrayList<Integer>(); 

        for(int i = 0; i<arr.size(); i++){

            if(userSearch == arr.get(i)){

                positionTracker.add(i);

            }
        }

        System.out.print("The number: " + userSearch + " is found in the following position/index ");

        for(int i = 0; i<positionTracker.size(); i++){

            System.out.print(positionTracker.get(i) + " ");

        }

    }

    public static void bubbleSort(ArrayList<Integer> arr){

        for(int i = 0; i<arr.size() - 1; i++){

            for(int j = 0; j<arr.size() - i - 1; j++){

                if(arr.get(j) > arr.get(j + 1)){

                    Integer temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j + 1, temp);
                }
            }
        }

        for(int i = 0; i<arr.size(); i++){

            System.out.println(arr.get(i));
        }
    }



    public static void main (String args[]){

        Scanner ss = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
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
            System.out.println("Enter i to sort the number in ascending order");
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

        else if(input.equalsIgnoreCase("i")){

            bubbleSort(arr);

        }
       
        }while(!input.equalsIgnoreCase("N"));
    


    }
    
}
