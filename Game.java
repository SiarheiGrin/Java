package Game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        Play(args);
    }
    private static void Play(String[] s) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        ArrayList<String> a = Gamer.PlayerEnter(s);
        while (true) {
            String c = "Computer move: ";
            String y = "Your move: ";
            String w = "Your win!";
            int um = a.size() + 1;
            int cm = (int) (Math.random()*a.size());
            String ccm = c + a.get(cm);
            ArrayList<String> hma = HMACer.HMACer(ccm);
            System.out.println("HMAC:");
            System.out.println( hma.get(1));
            System.out.println("Avalaible moves: ");
            for (int i = 0; i < a.size(); i++) {
                System.out.println(i + 1 + " - " + a.get(i));
            }
            System.out.println(0 + " - " + "exit");
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            while (um > a.size() || um < 0) {
                System.out.print("Enter your move: ");
                um = Integer.parseInt(r.readLine()) - 1;
                if (um == -1) {
                    System.exit(0);
                }
            }
            if (cm == um){
                w = "Draw!";
            }
            else {
                if ((cm - um) > 0 && (cm - um) < (a.size() / 2 + 1)) {
                    w = "Computer win!";
                }
                else {
                    if (cm - um < 0 && um - cm > a.size() / 2) {
                        w = "Computer win!";
                    }
                }
            }
            System.out.println(y + a.get(um));
            System.out.println(c + a.get(cm));
            System.out.println(w);
            System.out.println("HMAC key:");
            System.out.println( hma.get(0));
            System.out.println("    ");
        }
    }
}
