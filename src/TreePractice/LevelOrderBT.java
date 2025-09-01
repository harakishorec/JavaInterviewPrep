package TreePractice;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBT {
    private static TreeNode root;

    public static void main(String[] args) {
        LevelOrderBT bt = new LevelOrderBT();
        bt.createBinaryTree();

        bt.levelOrder(root);

    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;

    }

    public void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode temp = queue.poll();
            System.out.println(temp.val + " ");
            if(temp.left != null){
                queue.offer(temp.left);
            }

            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }
}
