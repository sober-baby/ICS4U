import java.util.*; 
public class StringPrinter {

    public static void main (String args[]){

        List<String> mylist = new LinkedList<String>();

        Scanner ss = new Scanner (System.in);

        String input;

        do{

            System.out.println("Enter a string, or enter N to exit");

            input = ss.nextLine();

            mylist.add(input);

        }while(!input.equalsIgnoreCase("N"));

        for( int i = mylist.size()-2; i>=0; i--){

            System.out.println(mylist.get(i));

        }

    }
    
}
