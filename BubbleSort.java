import java.util.*;
public class BubbleSort {
    public static void main(String args[]){
        String presenters[] = {"James", "Levin", "Kevin", "Aiden","James"};




        for(int i = 0; i < presenters.length - 1; i++){
            for(int j = 0; j < presenters.length - i- 1; j++){
                if(presenters[j].compareTo(presenters[j + 1]) > 0){
                    String temp = presenters[j];
                    presenters[j] = presenters[j + 1];
                    presenters[j + 1] = temp;
                }
            }   
        }

        for(int i = 0; i < presenters.length; i++ ){

            System.out.println(presenters[i]);

        }
    }
}