package TreePractice;

import com.sun.source.tree.Tree;

public class CreateBinaryTree {

    private static TreeNode root;

    public static void main(String[] args) {

        createBinaryTree();
        recursivePreOrder(root);

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

    public static void recursivePreOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val + " ");
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }

}


