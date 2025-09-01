package TreePractice;

public class FindMaxBT {
    private static TreeNode root;

    public static void main(String[] args) {
        FindMaxBT bt = new FindMaxBT();
        bt.createBinaryTree();
        bt.printBt(root);

        int maxValue = bt.findMax(root);
        System.out.println("Maximum value in the binary tree: " + maxValue);
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(15);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(55);
        TreeNode sixth = new TreeNode(6);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;

    }

    public int findMax(TreeNode root1){

        if(root1 == null){
            return Integer.MIN_VALUE;
        }
        int max = root1.val;
        int left = findMax(root1.left);
        int right = findMax(root1.right);
        if(left > max){
            max = left;
        }
        if(right > max){
            max = right;
        }

        return max;
    }

    public void printBt(TreeNode root){
        if(root == null) return;

        System.out.println(root.val + " ");
        printBt(root.left);
        printBt(root.right);
    }
}
