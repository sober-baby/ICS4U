import java.util.*;

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

    public static void noDuplicates(int[] arr){

        Scanner ss = new Scanner (System.in);
        for(int i = 0; i<arr.length; i++){

            System.out.println("Enter a unique number");
            int userInput = ss.nextInt();

            while(contains(arr, userInput, i)){

                System.out.println("ERROR. Plz Enter a unique number");
                userInput = ss.nextInt();

            }

            arr[i] = userInput;
        }
    }

    public static void randomNoDuplicates(int[]arr){

        Scanner ss = new Scanner(System.in);
        System.out.println("Enter the min value you want to generate");
        int min = ss.nextInt();
        System.out.println("Enter the max value you want to generate");
        int max = ss.nextInt();
        Random ran = new Random();
        for(int i = 0; i<arr.length; i++){

            System.out.println("Generating......");
            int num = ran.nextInt((max-min) + 1) + min;

            while(contains(arr, num, i)){

                System.out.println("ERROR. Re-genrating......");
                num = (int)(Math.random()*(max-min))+1+min;

            }

            arr[i] = num;

        }
    }

    public static enterAndCount

    public static void main(String args[]) {

        int[] arrInt = new int[7];
        int[] arrRan = new int[10];
        noDuplicates(arrInt);
        randomNoDuplicates(arrRan);
        for(int i = 0; i<arrInt.length; i++){

            System.out.println(arrInt[i]);

        }

        for(int i = 0; i<arrRan.length; i++){

            System.out.println(arrRan[i]);

        }

    }

}
