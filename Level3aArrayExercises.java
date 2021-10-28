import java.util.*;

public class Level3aArrayExercises {

    public static void noDuplicates() {

        Scanner ss = new Scanner(System.in);
        int[] arr = new int[7];
        int counter = 0;
        int userInput;
        boolean trueFalse = true;

        do {

            System.out.println("Enter a unique integer");
            userInput = ss.nextInt();

            for (int i = 0; i < counter; i++) {

                if(trueFalse){

                    if (userInput == arr[i]) {

                        System.out.println("ERROR. Enter a valid number");
                        userInput = ss.nextInt();
                        trueFalse = true;

                    }else{

                        trueFalse = false; 
                    }
                }


                }

                    arr[counter] = userInput;
                    counter++;
                    trueFalse = true;
            
        } while (counter < arr.length);

    }

    public static void main(String args[]) {

        noDuplicates();

    }

}
