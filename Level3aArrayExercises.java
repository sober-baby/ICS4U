import java.util.*;

import javax.swing.text.html.BlockView;

import java.io.*;

public class Level3aArrayExercises {

    public static boolean contains(int[] arr, int target, int num) {

        boolean found = false;

        for (int i = 0; i < num; i++) {

            if (arr[i] == target) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void noDuplicates(int[] arr) {

        Scanner ss = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {

            System.out.println("Enter a unique number");
            int userInput = ss.nextInt();

            while (contains(arr, userInput, i)) {

                System.out.println("ERROR. Plz Enter a unique number");
                userInput = ss.nextInt();

            }

            arr[i] = userInput;
        }
    }

    public static void randomNoDuplicates(int[] arr) {

        Scanner ss = new Scanner(System.in);
        System.out.println("Enter the min value you want to generate");
        int min = ss.nextInt();
        System.out.println("Enter the max value you want to generate");
        int max = ss.nextInt();
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {

            System.out.println("Generating......");
            int num = ran.nextInt((max - min) + 1) + min;

            while (contains(arr, num, i)) {

                System.out.println("ERROR. Re-genrating......");
                num = (int) (Math.random() * (max - min)) + 1 + min;

            }

            arr[i] = num;

        }
    }

    public static void enterAndCount() throws Exception{

    

        Scanner ss = new Scanner(System.in);
        int[] arr = new int[101];
        int[] userEnter = new int[4];
        int counter = 0;
        System.out.println("Enter a file that you want to search in");
        String fileName = ss.nextLine();
        File myFile = new File(fileName);
        int findCommon = -1;
        int commonNumber = 0;
        int target;

        do {

            Scanner fileScanner = new Scanner(myFile);
            System.out.println("Enter a number you want to count");
            int userInput = ss.nextInt();
            userEnter[counter] = userInput;
            while (fileScanner.hasNext()) {

                target = fileScanner.nextInt();
                //System.out.println(target);

                if (target == userInput) {

                    arr[userInput]++;
                }
            }
            counter++;
            fileScanner.close();

        } while (counter < userEnter.length);

        for (int i = 0; i < userEnter.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (userEnter[i] == j) {

                    System.out.print(userEnter[i] + " :");
                    
                    for (int k = 0; k < arr[j]; k++) {
                        
                        System.out.print(" * ");
                    }

                    System.out.println();

                }
            }
        }

        for(int i = 0; i < arr.length; i++){

            if(arr[i] > findCommon){

                findCommon = arr[i];
                commonNumber = i;

            }
        }
 
        System.out.println("The most common number chosen was " + commonNumber);

    }

    public static void randomOrder(String[] names){

        Random ran = new Random();
        int[] randomUnique = new int[names.length];
        int randomNumber;
        for(int i = 0; i<names.length; i++){

            randomNumber = ran.nextInt(names.length);

            while(contains(randomUnique, randomNumber, i)){

                randomNumber = ran.nextInt(names.length);
                 
            }

            randomUnique[i] = randomNumber;

        }

        System.out.println("The names in random order are: ");
        for(int i = 0; i<names.length; i++){

            System.out.println(names[randomUnique[i]]);

        }
    }

    public static void threeRandomOrder(String[] names){

        int count = 0;
        int[] last = new int[3];
        int[] first = new int[3];
        do{
        boolean uniqueOrder = true;
        Random ran = new Random();
        int[] randomUnique = new int[names.length];
        int randomNumber;
        for(int i = 0; i<names.length; i++){

            randomNumber = ran.nextInt(names.length);

            while(contains(randomUnique, randomNumber, i)){

                randomNumber = ran.nextInt(names.length);             
            }
            randomUnique[i] = randomNumber;
        }
        first[count] = randomUnique[0]; 
        last[count] = randomUnique[names.length - 1]; 
        for(int i = 0; i<count; i++){

            if(last[count] == last[i] || first[count] == first[i]){

                uniqueOrder = false;  
            }
        }
        if(uniqueOrder){
        System.out.println("The names in random order are: ");    
        for(int i = 0; i<names.length; i++){
            System.out.println(names[randomUnique[i]]);
        }
        count++;
        }
        }while(count < 3);
    }

        
    

    public static void main(String args[]) throws Exception{


        String[] arr = {"James" , "Kevin" , "Aiden" , "Bob", "Jack"}; 
        //randomOrder(arr);
        threeRandomOrder(arr);

       // enterAndCount();

        /*
        int[] arrInt = new int[7];
        int[] arrRan = new int[10];
        noDuplicates(arrInt);
        randomNoDuplicates(arrRan);
        for (int i = 0; i < arrInt.length; i++) {

            System.out.println(arrInt[i]);

        }

        for (int i = 0; i < arrRan.length; i++) {

            System.out.println(arrRan[i]);

        }*/

    }

}
