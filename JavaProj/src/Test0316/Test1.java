package Test0316;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1 {
    public int getHeight(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return (leftHeight>rightHeight)?leftHeight:rightHeight;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        if((leftHeight-rightHeight)>1||(leftHeight-rightHeight)<-1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isMirror(p.left,q.right)&&isMirror(p.right,q.left);
    }

    public static void levelOrder(TreeNode root) {
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(true){
            TreeNode cur=queue.poll();
            if(cur==null){
                break;
            }
            System.out.println(cur.val);
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }

    public static boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean isLevel1=true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(true){
            TreeNode cur=queue.poll();
            if(cur==null){
                break;
            }
            if(isLevel1){
                if(cur.left!=null&&cur.right!=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left!=null&&cur.right==null){
                    isLevel1=false;
                    queue.offer(cur.left);
                }else if(cur.left==null&&cur.right==null){
                    isLevel1=false;
                }else{
                    return false;
                }
            }else{
                if(cur.left!=null||cur.right!=null){
                    return false;
                }
            }
        }
        return true;
    }

    public static List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        result=new ArrayList<>();
        if(root==null){
            return result;
        }
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int level) {
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if(root.left!=null){
            helper(root.left,level+1);
        }
        if(root.right!=null){
            helper(root.right,level+1);
        }
    }

    public TreeNode lca=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return false;
        }
        int mid=(root==p||root==q)?1:0;
        int left=findNode(root.left,p,q)?1:0;
        int right=findNode(root.right,p,q)?1:0;
        if(mid+left+right==2){
            lca=root;
        }
        return (left+mid+right)>0;
    }

    public TreeNode Convert(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode leftHead=Convert(root.left);
        TreeNode leftTail=leftHead;
        while(leftTail!=null&&leftTail.right!=null){
            leftTail=leftTail.right;
        }
        if(leftHead!=null){
            leftTail.right=root;
            root.left=leftTail;
        }
        TreeNode rightHead=Convert(root.right);
        TreeNode rightTail=rightHead;
        if(rightHead!=null){
            root.right=rightHead;
            rightHead.left=root;
        }
        return leftHead!=null?leftHead:root;
    }

    public int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
        return _buildTree(preorder,inorder,0,inorder.length);
    }
    private TreeNode _buildTree(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if(inorderLeft>inorderRight){
            return null;
        }
        if(index>=preorder.length){
            return null;
        }
        TreeNode root=new TreeNode(preorder[index]);
        int pos=find(inorder,inorderLeft,inorderRight,root.val);
        index++;
        root.left=_buildTree(preorder,inorder,inorderLeft,pos);
        root.right=_buildTree(preorder,inorder,pos+1,inorderRight);
        return root;
    }
    private int find(int[] arr, int left, int right, int toFind) {
        for(int i=left;i<right;i++){
            if(arr[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    public StringBuilder result2=null;
    public String tree2str(TreeNode t) {
        result2=new StringBuilder();
        if(t==null){
            return "";
        }
        helper2(t);
        result2.deleteCharAt(0);
        result2.deleteCharAt(result2.length()-1);
        return result2.toString();
    }
    private void helper2(TreeNode root) {
        if(root==null){
            return;
        }
        result2.append("(");
        result2.append(root.val);
        result2.append(root.left);
        if(root.left==null&&root.right!=null){
            result2.append("()");
        }
        result2.append(root.right);
        result2.append(")");
    }
}
