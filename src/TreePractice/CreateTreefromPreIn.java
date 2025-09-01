package TreePractice;

import java.util.HashMap;
import java.util.Map;

public class CreateTreefromPreIn {

    Map<Integer,Integer> map = new HashMap<>();
    int index = 0;
    private int[] preOrder;
    private int[] inOrder;

    public static void main(String[] args) {

        int[] preO = {1,2,4,5,7,3,6,8,9};
        int[] inO = {4,2,7,5,1,3,8,6,9};
        CreateTreefromPreIn ctf = new CreateTreefromPreIn();
        TreeNode1 root = ctf.buildTree(preO,inO);
        ctf.printTree(root);

    }

    public void printTree(TreeNode1 root1){
        if(root1 == null) return;

        System.out.println(root1.val + " ");
        printTree(root1.left);
        printTree(root1.right);
    }

    public TreeNode1 buildTree(int[] preOrder, int[]InOrder){

        this.preOrder = preOrder;
        this.inOrder = InOrder;
        int n = preOrder.length;
        for(int i =0; i<n; i++){
            map.put(inOrder[i],i);
        }
        TreeNode1 root1 = dfs(0,n-1);
        return root1;
    }

    public TreeNode1 dfs(int start, int end){

        if(start > end){
            return null;
        }

        int rootValue = preOrder[index];
        index++;
        TreeNode1 root = new TreeNode1(rootValue);

        int mid = map.get(rootValue);

        root.left = dfs(start, mid-1);
        root.right = dfs(mid+1,end);

        return root;

    }
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1() {
    }

    public TreeNode1(int val) {
        this.val = val;
    }

    public TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
