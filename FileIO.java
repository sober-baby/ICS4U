import java.util.*;
import java.io.*;
public class FileIO {

    public static void main (String args[]) throws Exception{

        Scanner userInput = new Scanner(System.in);
        File newfile = new File ("writeEx1");
        PrintWriter output = new PrintWriter (newfile);
        output.println("Hi");
        String string = "POCORN";
        output.close();
        userInput.nextLine(); 

        try{


        }catch(Exception e){
         
            System.out.print("Soemthing went wrong with the program");
            
        }


    }
    
}
