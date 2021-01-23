/*
package Tree;

import java.util.*;

class Node {
    private String root;
    private Node left, right;

    public Node(Node left, String root, Node right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public String getNode() {
        return this.root;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }
}

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    // 전위
    public void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.getNode() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    // 중위
    public void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.getLeft());
        System.out.print(root.getNode() + " ");
        inOrder(root.getRight());
    }

    // 후위
    public void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getNode() + " ");
    }

    // 레벨
    public void levelOrder(Node root) {
        Queue<Node> levelQ = new LinkedList<>();
        levelQ.add(root);

        while (!levelQ.isEmpty()) {
            Node temp = levelQ.remove();
            System.out.print(temp.getNode() + " ");

            if (temp.getLeft() != null || temp.getRight() != null) {
                levelQ.add(temp.getLeft());
                levelQ.add(temp.getRight());
            }
        }
    }

    public static void main(String[] args) {
        Node h = new Node(null, "H", null);
        Node i = new Node(null, "I", null);
        Node j = new Node(null, "J", null);
        Node k = new Node(null, "K", null);
        Node d = new Node(h, "D", i);
        Node e = new Node(null, "E", null);
        Node f = new Node(null, "F", null);
        Node g = new Node(j, "G", k);
        Node b = new Node(d, "B", e);
        Node c = new Node(f, "C", g);
        Node a = new Node(b, "A", c);

        BinaryTree binaryTree = new BinaryTree(a);

        System.out.print("전위: ");
        binaryTree.preOrder(a);
        System.out.print("\n중위: ");
        binaryTree.inOrder(a);
        System.out.print("\n후위: ");
        binaryTree.postOrder(a);
        System.out.print("\n레벨: ");
        binaryTree.levelOrder(a);
    }
}
*/
