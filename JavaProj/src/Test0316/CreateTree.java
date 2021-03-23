package Test0316;

import java.util.Scanner;
//编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
//例如如下的先序遍历字符串： ABC##DE#G##F### 其中 “#” 表示空格，空格字符代表空树。
//建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
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
        // 注意!!系统给的测试用例, 往往是多组!!
        while (scanner.hasNext()) {
            //1、读取字符串
            String line = scanner.next();
            //至关重要！！！
            //这个代码一旦忘了，就会导致两个用例之间互相影响
            index=0;
            //2、构建二叉树
            TreeNode root = build(line);
            //3、中序遍历
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
        char ch=input.charAt(index);//取字符串中的结点
        if(ch=='#'){
            return null;//当前字符如果是 #，该节点是一个空节点
        }
        TreeNode root=new TreeNode(ch);//当前字符如果不是空节点，就创建一个TreeNode对象
        index++;//处理下一个结点
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
