package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Gamer {
    static int ok = 0;
    public static ArrayList<String> PlayerEnter(String[] args) throws IOException {
        ArrayList<String> Input = new ArrayList<String>();
        for (String s : args) {
            Input.add(s);
        }
        do {
            int c = 0;
            if (Input.size() < 2) {
                System.out.println("Enter three or more moves");
                c++;
            }
            if (Input.size() % 2 == 0) {
                System.out.println("Enter an odd number of moves");
                c++;
            }
            int k = 0;
            for (int i = 0; i < Input.size(); i++) {
                for (int j = i+1; j < Input.size(); j++) {
                    if (Input.get(i).equals(Input.get(j)) || Input.get(i) == Input.get(j)) {
                        k++;
                    }
                }
            }
            if (k > 0) {
                c++;
                System.out.println("Enter non-recurring moves");
            }
            if (Input.size() > 2 && Input.size() % 2 != 0 && c == 0 && k ==0) {
                ok = 1;
            }
            if (c != 0 || k > 0) {
                Input.clear();
                BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                String moves = r.readLine();
                for (String s : moves.split(" ")) {
                    Input.add(s);
                }
            }
        } while (ok != 1);
        return Input;
    }
}

