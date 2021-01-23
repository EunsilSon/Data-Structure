/*
package Tree;

class Node {
    private String root;
    private Node left, right;
    private int size;

    public Node(Node left, String root, Node right, int size) {
        this.root = root;
        this.left = left;
        this.right = right;
        this.size = size;
    }

    public String getRoot() {
        return this.root;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public int getSize() {
        return this.size;
    }
}

public class DirectorySize {
    private int total = 0;

    public int getDirSize() {
        return total;
    }

    public void checkDirSize(Node root) {
        if (root == null) {
            return;
        }
        checkDirSize(root.getLeft());
        checkDirSize(root.getRight());
        total += root.getSize();
    }

    public static void main(String[] args) {
        Node photo = new Node(null, "photo", null, 200);
        Node video = new Node(null, "video", null, 100);
        Node picture = new Node(photo, "picture", video, 500);
        Node music = new Node(null, "music", null, 50);
        Node document = new Node(music, "document", picture , 0);

        DirectorySize dir = new DirectorySize();
        dir.checkDirSize(document);

        System.out.print("디렉토리 총 용량: " + dir.getDirSize());
    }
}
*/
