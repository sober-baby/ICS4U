import java.util.*;
public class ArrayListExercises {

    public static void enterFromKeyboard(ArrayList<Integer> arr){ //Method to prompt the user to enter some numbers 
        
        Scanner ss = new Scanner(System.in);

        for(int i = 0; i<10; i++){

            System.out.println("Enter a number");
            arr.add(ss.nextInt());
            System.out.println("Do you want to keep on entering a number? Y/N");
            String check = ss.next();
            if(check.equalsIgnoreCase("N")){

                break;

            }
        }
    }

    public static void main (String args[]){

        ArrayList<Integer> intArray = new ArrayList<Integer>();
        enterFromKeyboard(intArray);
        




    }
    
}
