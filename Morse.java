import javax.sound.midi.*;
import javax.swing.*;

public class Morse {

  //Creates the objects that allow the project to return a sound when run
  private Synthesizer synth = MidiSystem.getSynthesizer();
  private MidiChannel[] channels = this.synth.getChannels();

  private static int INSTRUMENT_BANK = 1024;
  private static int INSTRUMENT_PROGRAM = 80;
  private static int NOTE_PITCH = 60;
  private static int NOTE_VELOCITY = 100;
  private static int NOTE_SHORT_DURATION = 50;
  private static int NOTE_MEDIUM_DURATION = 150;
  private static int NOTE_LONG_DURATION = 200;

  public static void main (String[] args) throws MidiUnavailableException {
    Morse m = new Morse();

    while (true) {
      String message = JOptionPane.showInputDialog("Message to translate (leave empty to quit):");

      if (message == null || message.trim().equals("")) {
        break;
      }

      m.translate(message);
    }
  }

  public Morse () throws MidiUnavailableException {
    this.synth.open();
    this.channels[0].programChange(INSTRUMENT_BANK, INSTRUMENT_PROGRAM);
  }

  private void note (int duration) throws InterruptedException {
    this.channels[0].noteOn(NOTE_PITCH, NOTE_VELOCITY);
    Thread.sleep(duration);
    this.channels[0].noteOff(NOTE_PITCH);
    Thread.sleep(NOTE_SHORT_DURATION);
  }

  private void note (int duration, boolean betweenChars) throws InterruptedException {
    this.channels[0].noteOn(NOTE_PITCH, NOTE_VELOCITY);
    Thread.sleep(duration);
    this.channels[0].noteOff(NOTE_PITCH);

    if (betweenChars) {
      Thread.sleep(NOTE_MEDIUM_DURATION);
    } else {
      Thread.sleep(NOTE_SHORT_DURATION);
    }
  }
  // Translates a given message to Morse code and plays the corresponding sound
  // Morse code mapping for letters
  // Each letter is represented by a combination of short and medium duration notes
  // Adjustments are made for proper spacing between characters and words
  // The mapping includes letters A-Z and numbers 0-9
  public void translate (String message) {
    message = message.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();

    try {
      for (char c : message.toCharArray()) {
        switch (c) {
          case ' ':
            Thread.sleep(NOTE_LONG_DURATION);

          case 'a':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'b':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'c':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'd':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'e':
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'f':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'g':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'h':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'i':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'j':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'k':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'l':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'm':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'n':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'o':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'p':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 'q':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'r':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 's':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case 't':
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'u':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'v':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'w':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'x':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'y':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
            break;

          case 'z':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
            break;

          case '0':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
          
          case '1':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
          
          case '2':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
          
          case '3':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
          
          case '4':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_MEDIUM_DURATION, true);
          
          case '5':
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
          
          case '6':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
          
          case '7':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
          
          case '8':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
          
          case '9':
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_MEDIUM_DURATION);
            this.note(NOTE_SHORT_DURATION, true);
        }
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}