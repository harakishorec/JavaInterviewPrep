package TreePractice;

public class LevelOrderBTDFS {

    private Node root;

    public Node createNode(){
        Node t1 = new Node(1);
        Node t2 = new Node(2);
        Node t3 = new Node(3);
        Node t4 = new Node(4);
        Node t5 = new Node(5);
        Node t6 = new Node(6);
        Node t7 = new Node(7);

        root = t1;
        t1.left = t2;
        t2.left = t4;
        t2.right = t5;
        t1.right = t3;
        t3.left = t6;
        t3.right = t7;

        return root;
    }

    public static void main(String[] args) {

        LevelOrderBTDFS lo = new LevelOrderBTDFS();
        Node rootVal = lo.createNode();

        System.out.println();
        System.out.println("Level Order DFS Approach");
        Node dfsNode = lo.dfs(rootVal);

    }

    public Node dfs(Node root) {
        if(root == null) {
            return null;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if(root.next == null){
                root.right.next = null;
            } else {
                root.right.next = root.next.left;
            }
        }

        dfs(root.left);
        dfs(root.right);

        return root;
    }
}

class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

}
