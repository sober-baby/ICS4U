package TestCode;
import java.util.*;
public class ArrayListTesting {

    public static void main (String args[]){

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i<arr.size(); i++){

            System.out.println(arr.get(i));
        }

        int[] array = new int[10];
        for(int i = 0; i<array.length; i++){

            System.out.println(array[i]);
        }

        String s = "Hello";
        s = s.concat(" James");
        System.out.println(s);

        String number = "1234567";
        int numberint = Integer.valueOf(number);
        System.out.println(numberint);
        String n = String.valueOf(numberint);
        System.out.print(n);


    }
    
}
