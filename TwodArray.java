import java.util.*;
public class TwodArray {

    public static void main(String args[]){

    int aGrid[][] = new int[10][10];
    Scanner ss = new Scanner(System.in);
    for(int r = 0; r < aGrid.length; r++){

        for(int c = 0; c < aGrid[r].length; c++){

            System.out.println("Enter a number");
            int userInput = ss.nextInt();
            aGrid[r][c] = userInput;

        }
    }

    for(int r = 0; r < aGrid.length; r++){

        for(int c = 0; c < aGrid[r].length; c++){

            System.out.print(" " + aGrid[r][c]);

        }

        System.out.println("");
    }

    


    }
    
}

