package com.node;

import java.util.LinkedList;

/**
 * SearchNode
 */
public class SearchNode {
  // Fields
  private static SearchNode INSTANCE;
  private boolean found;
  private LinkedList<String> searchControler;
  // Constructor
  private SearchNode () {
    this.found = false;
    this.searchControler = new LinkedList<>();
  }
  // Get singleton SearchNode
  public static SearchNode getInstance() {
    return INSTANCE == null ? new SearchNode() : INSTANCE;
  }

  // Search character inside tree
  public String searchChar(Node current, char ltr, String code) {
		this.searchControler.add(code);
		if (current.getLetter() == ltr) {
			this.found = true;
      return this.searchControler.removeFirst();
		} else {
			if (current.getLeft() != null && !this.found) {
				searchChar(current.getLeft(), ltr, code + ".");
			}
			if (current.getRight() != null && !this.found) {
				searchChar(current.getRight(), ltr, code + "-");
			}
		}
    if (this.searchControler.size() == 1) { // reinit found
      this.found = false;
    }
    return this.searchControler.removeFirst();
	}

  public StringBuffer searchMorse(String code) {
    char foundChar = ' ';
    Node current = Tree.getInstance().getRoot();
    for (int i = 0; i < code.length(); i++) {
      String symbol = code.substring(i, i + 1);
      if (symbol.equals(".")) {
        current = current.getLeft();
      } else {
        current = current.getRight();
      }
      foundChar = current.getLetter();
    }
    return new StringBuffer().append(foundChar);
  }
}