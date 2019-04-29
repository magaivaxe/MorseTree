package app;

import com.morse.Morse;

public class App {
    public static void main(String[] args) {
        Morse m = Morse.getInstance();
        String testWordToMorse = "marcos et veronica";
        System.out.println("to morse: " + m.encoder(testWordToMorse));
        // word separtor = "<>" letter separator = "#"
        String testMorseToWord = "--#---#..<>.#-<>-#---#..";
        System.out.println("to word: " + m.decoder(testMorseToWord));
    }
}