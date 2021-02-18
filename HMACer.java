package Game;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

public class HMACer {
    public static ArrayList<String> HMACer(String s) throws NoSuchAlgorithmException, InvalidKeyException {
        ArrayList<String> result = new ArrayList<String>();
        String key = KeyGen.generate();
        byte[] byteKey = key.getBytes(StandardCharsets.UTF_8);
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(byteKey, "HmacSHA256");
        sha256Hmac.init(keySpec);
        byte[] macData = sha256Hmac.doFinal(s.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder(macData.length * 2);
        for(byte b: macData) {
            sb.append(String.format("%02x", b));
        }
        String res = sb.toString();
        result.add(key);
        result.add(res);
        return result;
    }
}
