package TreePractice;

import java.util.HashMap;
import java.util.Map;

public class CreateTreefromPoIn {

    Map<Integer,Integer> map = new HashMap<>();
    int index;
    int[] postOrder;
    int[] inOrder;

    public static void main(String[] args) {
        int[] inO = {4,2,7,5,1,3,8,6,9};
        int[] poO = {4,7,5,2,8,9,6,3,1};
        CreateTreefromPoIn ctf = new CreateTreefromPoIn();
        TreeNode2 root = ctf.buildTree(poO,inO);
        ctf.printTree(root);
    }

    public void printTree(TreeNode2 root){
        if(root == null) return;

        System.out.println(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public TreeNode2 buildTree(int[] postOrder, int[] inOrder){

        this.postOrder = postOrder;
        this.inOrder = inOrder;

        int n = postOrder.length;
        for(int i =0; i<n; i++){
            map.put(inOrder[i],i);
        }
        index = n-1;
        TreeNode2 rootTree = dfs(0,n-1);
        return rootTree;
    }

    public TreeNode2 dfs(int start, int end){

        if(start > end)
            return null;

        int rootValue = postOrder[index];
        index--;

        TreeNode2 root = new TreeNode2(rootValue);

        int mid = map.get(rootValue);

        root.left = dfs(start,mid-1);
        root.right = dfs(mid+1,end);

        return root;
    }



}

class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int val){
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
