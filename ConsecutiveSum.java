import java.util.*;
public class ConsecutiveSum {

    public static void main(String args[]){

        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Enter a number");
        int UserInput = myScanner.nextInt();
        int total = 0;
        
        for(int i = 0; i<=5; i++){

            total += UserInput;

            if ((UserInput % 2) == 0){

               UserInput ++;

            }else{

                UserInput += 2;


            }



        }

        System.out.println(total);







    }
    
}
