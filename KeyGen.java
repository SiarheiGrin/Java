package Game;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class KeyGen {
    public static String generate() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] values = new byte[16];
        random.nextBytes(values);
        StringBuilder sb = new StringBuilder(values.length * 2);
        for(byte b: values) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}