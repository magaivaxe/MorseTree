package com.node;

/**
 * Node class to compose binary tree.
 */
public class Node {
  // Fields
  private char letter;
  private Node left;
  private Node right;
  public static final char EMPTY = ' ';
  // Constructor
  public Node() {
    this.letter = EMPTY;
    this.left = null;
    this.right = null;
  }
  // Setters and getters
  public char getLetter() {
    return letter;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}