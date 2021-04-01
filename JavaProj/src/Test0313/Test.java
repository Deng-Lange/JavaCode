package Test0313;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static Node build() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }
    // 先序遍历
    public static void preOrder(Node root) {
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    // 中序遍历
    public static void inOrder(Node root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.left);
        inOrder(root.right);
    }
    // 后序遍历
    public static void postOrder(Node root) {
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
    //求节点个数
    public static int count=0;
    public static void length(Node root) {
        if(root==null){
            return;
        }
        count++;
        length(root.left);
        length(root.right);
    }
    public static int length2(Node root) {
        if(root==null){
            return 0;
        }
        return 1+length2(root.left)+length2(root.right);
    }
    //求叶子结点个数
    public static int leafSize = 0;
    public static void getLeafSize(Node root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }
    public static int getLeafSize2(Node root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }
    //求第 k 层结点的个数 = 求左子树的第 k-1 层结点个数 + 求右子树的第 k-1 层结点个数
    public static int getKLevelSize(Node root, int k) {
        if(root==null||k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    //求 A 的高度 = 1 + B 的高度和 C 的高度的较大值
    public static int getHeight(Node root) {
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return 1+(leftHeight>rightHeight?leftHeight:rightHeight);
    }
    //查找树上的某个元素
    public static Node find(Node root, String toFind) {
        if(root==null){
            return null;
        }
        if(root.val.equals(toFind)){
            return root;
        }
        Node result=find(root.left,toFind);
        if(result!=null){
            return result;
        }
        return find(root.right,toFind);
    }
    //二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
    //检查两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //另一棵树的子树
    //遍历 s，看 s 上的某个结点对应的子树是否和 t 这个树是相等的
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        boolean ret=isSameTree(s,t);
        if(ret){
            return ret;
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    //二叉树最大数深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=maxDepth(root.left);
        int rightHeight=maxDepth(root.right);
        return 1+(leftHeight>rightHeight?leftHeight:rightHeight);
    }
}
