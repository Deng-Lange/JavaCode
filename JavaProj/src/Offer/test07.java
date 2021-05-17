package Offer;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class test07 {
    //根据一棵树的先序遍历与中序遍历构造二叉树
    //详解见 Test0316-->BinaryTree
    public int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return _buildTree(preorder, inorder,0,inorder.length);
    }
    public TreeNode _buildTree(int[] preorder, int[] inorder,
                               int inorderLeft, int inorderRight) {
        if(inorderLeft>=inorderRight){
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int pos = find(inorder,inorderLeft,inorderRight,root.val);
        index++;
        root.left = _buildTree(preorder, inorder, inorderLeft, pos);
        root.right = _buildTree(preorder, inorder, pos+1, inorderRight);
        return root;
    }
    private int find(int[] array, int left, int right, int toFind) {
        for(int i=left;i<right;i++){
            if(array[i]==toFind){
                return i;
            }
        }
        return -1;
    }
}
