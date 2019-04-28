package app;

import com.morse.Morse;

public class App {
    public static void main(String[] args) {
        Morse m = Morse.getInstance();
        String test = "marcos et veronica";
        System.out.println("final: " + m.encoder(test));
    }
}