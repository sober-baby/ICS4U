package TestCode;

public class Splitting{

    public static void main (String args[]){


        String name = "James";
        char[] chararray = new char[name.length()];
        String[] result = name.split("");
        for(int i = 0; i<result.length; i++){


            chararray[i] = name.charAt(i);
            System.out.println(result[i]);
            System.out.println(chararray[i]);
        }

    
    }
    
}
