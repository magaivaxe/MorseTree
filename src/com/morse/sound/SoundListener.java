package com.morse.sound;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineEvent.Type;

/**
 * SoundListener
 */
public class SoundListener implements LineListener {
  // Fields
  private boolean done = false;

  @Override
  public void update(LineEvent event) {
    Type eventType = event.getType();
    if (eventType == Type.STOP || eventType == Type.CLOSE) {
      done = true;
      // notufy all threads
      notifyAll();
    }
  }
  //
  public synchronized void waitUntilDone() throws InterruptedException {
    while (!done) {
      wait();
    }
  }


}