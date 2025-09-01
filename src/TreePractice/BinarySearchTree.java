package TreePractice;

// left sub tree contains only nodes with keys less than the node's key
// right sub tree contains only nodes with keys greater than the node's key
 //
// the left and right subtree must also be binary search trees
// there must be no duplicate nodes
//          6
//      4       8
//    2   5   7   9

//Insert a key in BST, Search a key in BST and validate Binary Search Tree
public class BinarySearchTree {

    private static TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.createBinarySearchTree();
        TreeNode rootIns = bt.insertBST(root, 1);
        System.out.println("Inserted 1 in BST");
        //          6
        //      4       8
        //    2   5   7   9
        //  1

        bt.printBST(rootIns);

        TreeNode searchKey = bt.searchBST(12,root);
        if(searchKey != null)
            System.out.println("Key found: " + searchKey.val);
        else
            System.out.println("Key not found");

        boolean isValidBST = validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("Is valid BST: " + isValidBST);
    }

    public void createBinarySearchTree(){
        TreeNode first = new TreeNode(6);
        TreeNode second = new TreeNode(4);
        TreeNode third = new TreeNode(8);
        TreeNode fourth = new TreeNode(2);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(7);
        TreeNode seventh = new TreeNode(9);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }

    public void printBST(TreeNode root){
        if(root == null) return;

        System.out.println(root.val + " ");
        printBST(root.left);
        printBST(root.right);
    }

    public TreeNode searchBST(int key, TreeNode root){
        if(root == null || root.val == key){
            return root;
        }
        if (key < root.val ) {
            return searchBST(key,root.left);
        }else{
            return searchBST(key,root.right);
        }
    }

    public TreeNode insertBST(TreeNode root, int key){

        if(root == null){
            return new TreeNode(key);
        }

        if(key < root.val){
            root.left = insertBST(root.left, key);
        }else{
            root.right = insertBST(root.right, key);
        }
        return root;
    }

    private static boolean validateBST(TreeNode root, long min, long max) {

        if(root == null) return true;

        if(root.val <= min || root.val >= max){
            return false;
        }

        boolean left = validateBST(root.left,min,root.val);
        if(left) {
            boolean right = validateBST(root.right, root.val, max);
            return right;
        }
        return false;
    }
}
