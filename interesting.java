import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class interesting {
    public static void main(String[] args) throws Exception {
        // Generate a random AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // AES key size is 128 bits
        SecretKey secretKey = keyGenerator.generateKey();

        // Encrypt plaintext using AES
        byte[] ciphertext1 = new byte[100];
        Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //Cipher aesCipher1 = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //aesCipher1.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] plaintext = "Hello, AES! AES, Hello!".getBytes();
        byte[] ciphertext = aesCipher.update(plaintext);
        byte[] plaintext1 = "Hello, AES!".getBytes();
        byte[] plaintext2 = " AES, Hello!".getBytes();
        ciphertext1 = aesCipher.update(plaintext1);
        ciphertext1 = aesCipher.doFinal(plaintext2);

        // Decrypt ciphertext using AES
        aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedText = aesCipher.update(ciphertext);
        byte[] decryptedText1 = aesCipher.doFinal(ciphertext1);

        //output has HEX
        byte [] hexByte = stringToHexString(new String(decryptedText)).getBytes();
        byte [] hexByte1 = stringToHexString(new String(decryptedText1)).getBytes();
        System.out.println("Decrypted Hex1: " + new String(hexByte));
        System.out.println("Decrypted Hex: " + new String(hexByte1));
    }


    public static String stringToHexString(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            result += Integer.toHexString(ch);
        }
        return result;
    }
}
