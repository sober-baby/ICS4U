import java.util.*;
public class ArrayListPractice {

    public static void main(String args[]){


        ArrayList<String> tryOut = new ArrayList<String>();

        ArrayList lol = new ArrayList();

        lol.add("Hi");

        lol.add(10);

        lol.add(10.32647623);

        lol.add("Hi");

        lol.add(10);

        lol.add(10.32647623);

        for(int i = 0; i<lol.size(); i++){
          

            System.out.println(lol.get(i));

        }


    }
    
}
