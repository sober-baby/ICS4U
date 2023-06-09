import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {
    public static void main(String[] args) {
        String input = "Hello, SHA-256!";

        try {
            byte[] hashValue = computeSHA256(input);
            System.out.println("Input: " + input);
            System.out.println("SHA-256 Hash Value: " + bytesToHex(hashValue));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("SHA-256 algorithm not available.");
        }
    }

    private static byte[] computeSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
