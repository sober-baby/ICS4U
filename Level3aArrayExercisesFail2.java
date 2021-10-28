import java.util.*;

public class Level3aArrayExercisesFail2 {

    public static void noDuplicates(int[] arr) {

        Scanner ss = new Scanner(System.in);
        int counter = 0;
        int userInput;
        boolean trueFalse = true;

        do {

            System.out.println("Enter a unique integer");
            userInput = ss.nextInt();

            for (int i = 0; i < counter; i++) {

                if (userInput == arr[i]) {

                    System.out.println("ERROR. Plz re-enter");
                    trueFalse = false;

                }
            }
            if (trueFalse) {

                arr[counter] = userInput;
                counter++;

            }
        } while (counter < arr.length);

    }

    public static void main(String args[]) {

        int[] arr = new int[7];
        noDuplicates(arr);
        for (int i = 0; i < 7; i++) {

            System.out.println(arr[i]);

        }

    }

}
