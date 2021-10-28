/* Start of my algorithm
* Prompt the user to enter a number that he/she wants to reverse
* Store the user's input in num
* Create a variable called reverse num to store the reversed number, let reverse num be 0
* Create a while loop that has the condition of num is not equal to zero
* In the loop, multiply reversenum by 10 each time, and let reversenum's first digit be the last digit of num by finding the remainder of num/10
* Divide num by 10 each loop
* Print the reversenum
*/
import java.util.*;
public class AlgorithmChallange {

    public static void main(String args[]){
     
      int num=0;
      int reversenum =0;
      System.out.println("Enter a number");
      Scanner ss = new Scanner(System.in);
      num = ss.nextInt();
      while( num != 0 )
      {
          reversenum = reversenum * 10;
          reversenum = reversenum + num%10;
          num = num/10;
      }

      System.out.println("The reversed number is: "+reversenum);
   }
    
}
