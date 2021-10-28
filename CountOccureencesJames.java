import java.util.*;
public class CountOccureencesJames {

    public static void main(String args[]){

        Scanner ss = new Scanner (System.in);

        int[] arr = new int[10];

        int[] count = new int[10];

        Arrays.fill(count, 1);
        
        int i = 0; 

        int input; 

        do{

            System.out.println("Enter a number between 0 to 10, or enter a number out of this range to exit");

            input = ss.nextInt(); 

            if(input>=0 && input<=10){

                arr[i] = input; 

                i++;  

            }  

        }while(input>=0 && input<=10); 

        for(int j = 0; j < i; j++){

            if(arr[j] == arr[j+1]){

                count[j]++;

            }
        }

        for(int j = 0; j<i; j++){

            System.out.println("The Number: " + arr[j] + " Occured " + count[j] + "Times"); 
        }

    }
    
}
