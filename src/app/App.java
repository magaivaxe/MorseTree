package app;

import com.node.tree.Tree;

public class App {
    public static void main(String[] args) {
        Tree tree = Tree.getInstance();
        System.out.println("final: " + tree.searchTree(tree.getRoot(), 'a', ""));
    }
}