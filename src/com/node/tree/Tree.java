package com.node.tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.node.Node;

/**
 * Singleton binary tree
 */
public class Tree {
	// Fields
	private static Tree INSTANCE;
	private Node root;

	// Constructor
	private Tree() {
		this.root = new Node();
		buildTree();
	}

	// Get Singleton Tree
	public static Tree getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Tree();
		}
		return INSTANCE;
	}

	/**
	 * Builds tree according to text file
	 */
	private void buildTree() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src/eng.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		while (scanner.hasNextLine()) {
			String data = scanner.nextLine().trim();
			if (data.length() > 0) {
				addNodes(data.substring(1).trim(), data.charAt(0));
			}
		}
		scanner.close();
	}

	/**
	 * Add a letter to tree based on code string
	 * @param code string morse code
	 * @param ltr letter added at Node
	 */
	private void addNodes(String code, char ltr) {
		Node current = root;
		String signal = "";
		for (int i = 0; i < code.length(); i++) {
			signal = code.substring(i, i + 1);
			if (signal.equals(".")) {
				if (current.getLeft() != null) {
					current = current.getLeft();
				} else {
					current.setLeft(new Node());
					current = current.getLeft();
				}
			} else {
				if (current.getRight() != null) {
					current = current.getRight();
				} else {
					current.setRight(new Node());
					current = current.getRight();
				}
			}
		}
		current.setLetter(ltr);
	}

	boolean found = false;
	String searched = "";

	public String searchTree(Node current, char ltr, String str) {
		char temp = current.getLetter(); // to debug
		if (current.getLetter() == ltr) {
			this.found = true;
			this.searched = str;
		} else if (!this.found) {
			if (current.getLeft() != null) {
				searchTree(current.getLeft(), ltr, str + ".");
			}
			if (current.getRight() != null) {
				searchTree(current.getRight(), ltr, str + "-");
			}
		}
		return this.found ? this.searched : str;
	}

	// Getters and Setters
	public Node getRoot() {
		return this.root;
	}
}