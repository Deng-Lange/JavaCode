package Test0316;

import java.util.Scanner;

public class Test2 {
    public static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(char val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String line=scanner.next();
            index=0;
            TreeNode root=build(line);
            inOrder(root);
            System.out.println();
        }
    }
    private static void inOrder(TreeNode root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    public static int index = 0;
    private static TreeNode build(String input) {
        char ch=input.charAt(index);
        if(ch=='#'){
            return null;
        }
        TreeNode root=new TreeNode(ch);
        index++;
        root.left=build(input);
        index++;
        root.right=build(input);
        return root;
    }
}
