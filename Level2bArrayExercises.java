import java.util.*;
public class Level2bArrayExercises {

    public static void CountOccurences(){

        int[] arr = new int[10];
        Scanner ss = new Scanner(System.in);
        int userInput = 1;
        int count = 0;
        while(userInput > 0 && userInput < 11){

            System.out.println("Enter a number between 1 and 10 inclusive");
            userInput = ss.nextInt();

            if(userInput > 0 && userInput < 11){
                
                arr[userInput - 1]++;

            }
        }

        for(int i = 0; i<arr.length; i++){

            System.out.println("The number " + (i+1) + " occured " + arr[i] + " times");
        }
      
    }

    public static void CountOccurences2(){

        int[] arr = new int[11];
        Scanner sc = new Scanner(System.in);
        int userInput = 1;
        int count = 0;
        while(userInput > 14 && userInput < 26){

            System.out.println("Enter a number between 15 and 25 inclusive");
            userInput = sc.nextInt();

            if(userInput > 14 && userInput < 26){
                
                arr[userInput]++;

            }
        }

        for(int i = 0; i<arr.length; i++){

            System.out.println("The number " + (i+15) + " occured " + arr[i] + " times");
        }
      
    }

    public static void totals(){

        int[]arr = new int[100];
        Scanner s = new Scanner(System.in);
        int userInput = 1;
        int tempSum = 0;
        while(userInput>=0 && userInput<=99){

            System.out.println("Enter a number between 0-99, or enter a number out of this range to exit");
            userInput = s.nextInt();

            if(userInput >=0 && userInput <= 99){

                arr[userInput]++;
                 
            }
        }

        for(int i = 0; i<10; i++){

            for(int j = 0; j<10; j++){

                tempSum += ((i*10+j)*arr[i*10+j]);

            }
            
            int num = i*10+9;
            System.out.println("The sum of all the numbers between " + i*10 + " and " + num + " is " + tempSum);
            tempSum = 0; 

        }


    }

    
    public static void main (String args[]){

        Scanner ss = new Scanner(System.in);
        String userInput = "Y";

        while(!userInput.equalsIgnoreCase("N")){

            System.out.println("Enter a to CountOccurences of numbers 1 to 10");
            System.out.println("Enter b to CountOccurences of numbers 15 to 25");
            System.out.println("Enter c to enter numbers from 0 to 99 and display their sum");
            System.out.println("Enter N to exit the program");
            userInput = ss.nextLine();

            if(userInput.equals("a")){

                CountOccurences();

            }else if(userInput.equals("b")){

                CountOccurences2();

            }else if(userInput.equals("c")){

                totals();
            }
        }

        ss.close(); 

    }

    
    
}
