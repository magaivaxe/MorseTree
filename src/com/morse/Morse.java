package com.morse;

import com.node.Node;
import com.node.SearchNode;
import com.node.Tree;

/**
 * Morse
 */
public class Morse implements MorseInterface {
  // Fields
  private static Morse INSTANCE;
  // Constructor
  private Morse () {}
  // Get singleton instance
  public static Morse getInstance() {
    return INSTANCE == null ? new Morse() : INSTANCE;
  }

  @Override
  public void inOrderPrint() {

  }

  @Override
  public String decoder(String morse) {
    SearchNode sn = SearchNode.getInstance();
    String results = "";
    String splitWords [] = morse.split("<>");
    // Words loop
    for (int i = 0; i < splitWords.length; i++) {
      String splitLetters [] = splitWords[i].split("#");
      // letters loop
      for (int j = 0; j < splitLetters.length; j++) {
        results = results + sn.searchMorse(splitLetters[j]).toString();
      }
      results = results + " ";
    }
    return results;
  }
  /**
   * @param phrase a word or phrase to convert to morse
   * @return morse code
   */
  @Override
  public String encoder(String phrase) {
    Node root = Tree.getInstance().getRoot();
    String result = "";
    for (int i = 0; i < phrase.length(); i++) {
      char ltr = phrase.charAt(i);
      if (ltr == ' ') {
        result = result + "/";
      } else {
        result = result + SearchNode.getInstance().searchChar(root, ltr, "");
      }
    }
    return result;
  }
}