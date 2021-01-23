package Tree;

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

public class Tree_Height_Count {
    private int nodeCount = 0;

    public int getNodeCount() { return nodeCount; }

    public int getMaxHeight() { return nodeCount; }

    public int getMinHeight() {
        return (int)(Math.log(nodeCount) / Math.log(2)) + 1;
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.getLeft());
        preOrder(root.getRight());
        nodeCount++;
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

        Tree_Height_Count tree = new Tree_Height_Count();
        tree.preOrder(a);

        System.out.print("이진 트리의 노드 개수: " + tree.getNodeCount());
        System.out.print("\n이진 트리의 최대 높이: " + tree.getMaxHeight());
        System.out.print("\n이진 트리의 최소 높이: " + tree.getMinHeight());
    }
}
