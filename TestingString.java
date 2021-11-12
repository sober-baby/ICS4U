public class TestingString {

    public static void main(String[] args) {
        String s = "Hello";
        String[] letters = s.split("");
        for(int i = 0; i < letters.length; i++) {
            System.out.println(letters[i]);
        }

    }
}
