package app;

import com.morse.Morse;
import com.morse.sound.Sound;

public class App {
    public static void main(String[] args) {
        Morse m = Morse.getInstance();
        String testWordToMorse = "marcos et veronica";
        System.out.println("to morse: " + m.encoder(testWordToMorse));
        // word separtor = "<>" letter separator = "#"
        String testMorseToWord = "--#---#..<>.#-<>-#---#..";
        System.out.println("to word: " + m.decoder(testMorseToWord));
        // Play Sound test
        Sound.getInstance().playPoint();
        Sound.getInstance().playHyphen();
    }
}