package com.morse.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * PlayMorse
 */
public class Sound {
  // Fields
  private static Sound INSTANCE;
  private String eSound = "src/soundE.wav";
  private String tSound = "src/soundT.wav";
  private File eFile, tFile;
  // Constructor
  private Sound() {
    eFile = new File(this.eSound);
    tFile = new File(this.tSound);
  }
  // Get singleton instance
  public static Sound getInstance() {
    return INSTANCE == null ? new Sound() : INSTANCE;
  }

  // get sounds
  public void playPoint() {
    try {
      play(this.eFile);
    } catch (Exception e) {
      e.getMessage();
    }
  }
  public void playHyphen() {
    try {
      play(this.tFile);
    } catch (Exception e) {
      e.getMessage();
    }
  }

  private void play(File file) throws IOException,
  UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
    // Create listener and inputStream
    SoundListener listener = new SoundListener();
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
    // try play
    try {
      Clip clip = AudioSystem.getClip();
      clip.addLineListener(listener);
      clip.open(audioInputStream);
      try {
        clip.start();
        listener.waitUntilDone();
      } finally {
        clip.close();
      }
    } finally {
      audioInputStream.close();
    }
  }
}