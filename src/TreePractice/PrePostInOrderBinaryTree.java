package TreePractice;

public class PrePostInOrderBinaryTree {
    private static TreeNode root;

    public static void main(String[] args) {

        PrePostInOrderBinaryTree bt = new PrePostInOrderBinaryTree();


        createBinaryTree();
        System.out.println("Recursive PreOrder Traversal:");
        bt.recursivePreOrder(root);
        System.out.println("-------------------------");

        System.out.println("Recursive PostOrder Traversal:");
        bt.recursivePostOrder(root);
        System.out.println("-------------------------");

        System.out.println("Recursive InOrder Traversal:");
        bt.recursiveInOrder(root);
        System.out.println("-------------------------");
    }
    public static void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

    }

    public void recursivePreOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val + " ");
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }

    public void recursivePostOrder(TreeNode root){
        if(root == null){
            return;
        }

        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.println(root.val + " ");
    }

    public void recursiveInOrder(TreeNode root){
        if(root == null){
            return;
        }

        recursiveInOrder(root.left);
        System.out.println(root.val + " ");
        recursiveInOrder(root.right);

    }
}
