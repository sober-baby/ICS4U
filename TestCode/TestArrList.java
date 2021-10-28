package TestCode;
import java.util.*;
public class TestArrList {

    public static void main (String args[]){

        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        arr.add(5);
        arr.add(5);
        arr.add(1);
        int a = 1; 
        arr.remove(a);
        for(int i = 0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }
        
        
        
    }
    
}
