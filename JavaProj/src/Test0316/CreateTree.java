package Test0316;

import java.util.Scanner;

public class CreateTree {
    public static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //至关重要！！！
        //这个代码一旦忘了，就会导致两个用例之间互相影响
        index=0;
        // 注意!!系统给的测试用例, 往往是多组!!
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = build(line);
            //中序遍历
            inOrder(root);
            // 打印换行
            System.out.println();
        }
    }

    // 当前这个 String input 里的每个字符就对应到树的一个节点.
    // 接下来我们要进行递归.
    // 为了在递归过程中, 也能明确的知道当前正在处理的是哪个节点
    // 使用一个成员变量 index, 记录当前节点对应的下标.
    public static int index = 0;
    public static TreeNode build(String input) {
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

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");//不换行，加空格
        inOrder(root.right);
    }
}
