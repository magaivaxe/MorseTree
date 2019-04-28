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
  public String decoder(String str) {
    return null;
  }
  /**
   * @param str a word or phrase to convert to morse
   * @return morse code
   */
  @Override
  public String encoder(String str) {
    Node root = Tree.getInstance().getRoot();
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      char ltr = str.charAt(i);
      if (ltr == ' ') {
        result = result + "/";
      } else {
        result = result + SearchNode.getInstance().searchChar(root, ltr, "");
      }
    }
    return result;
  }
}