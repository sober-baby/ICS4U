package TestCode;

public class Test {

//ask the user to enter a word and print the word in reverse
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String word;
        System.out.println("Enter a word");
        word = System.console().readLine();
        System.out.println(reverse(word));
    }
    
    public static String reverse(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        return reverse;
    }





 

    
}
