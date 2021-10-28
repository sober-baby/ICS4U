import java.util.Scanner;

public class rps {
    public static void main (String args[]){
        
        int userInput = 0;
        Scanner ss = new Scanner (System.in);

        while(userInput!=3){

            System.out.println("Enter 0 for Rock, 1 for scissor, 2 for paper, and 3 to exit the game");
            userInput = ss.nextInt();
            int AI = (int)(Math.random()*3);

            if(userInput == 0 && AI == 0){
                System.out.println("Tie, plz try again");
            }

            if(userInput == 1 && AI == 1){
                System.out.println("Tie, plz try again");
            }

            if(userInput == 2 && AI == 2){
                System.out.println("Tie, plz try again");
            }

            if(userInput == 0 && AI == 1){
                System.out.println("You Won");
            }

            if(userInput == 1 && AI == 2){
                System.out.println("You Won");
            }

            if(userInput == 2 && AI == 0){
                System.out.println("You Won");
            }

            if(userInput == 1 && AI == 0){
                System.out.println("AI Won");
            }

            if(userInput == 2 && AI == 1){
                System.out.println("AI Won");
            }

            if(userInput == 0 && AI == 2){
                System.out.println("AI Won");
            }



        }

        


    }
    
}
