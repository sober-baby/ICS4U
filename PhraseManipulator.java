import java.util.*;
public class PhraseManipulator {

    public static void main (String args[]){

        Scanner ss = new Scanner(System.in);

        System.out.println("Enter a small phrase");

        String userinput = ss.nextLine();

        String[] words = userinput.split(" ");

        String[] unnormalwords = new String[words.length];

        for(int i = 0; i<words.length; i++){

            if(i%2 == 0){

                unnormalwords[i] = words[i].toLowerCase();

            }else{

                unnormalwords[i] = words[i].toUpperCase();

            }

        }

        for(int i = 0; i<words.length; i++){
            
            System.out.print(unnormalwords[i]);
            
            
        }

        System.out.println(" ");

        for(int i = 0; i<words.length; i++){
            
            System.out.println(words[i]);
            
        }





    }
    
}
