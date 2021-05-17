package Offer;

public class test27 {
    //请完成一个函数，输入一个二叉树，该函数输出它的镜像
    /*
    方法一：递归法
    根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。
    递归解析：
    1、终止条件：当节点 root 为空时（即越过叶节点），则返回 null
    2、递推工作：
       初始化节点 tmp，用于暂存 root 的左子节点
       开启递归右子节点 mirrorTree(root.right)，并将返回值作为 root 的左子节点
       开启递归左子节点 mirrorTree(tmp)，并将返回值作为 root 的右子节点
    3、返回值：返回当前节点 root
    Q：为何需要暂存 root 的左子节点？
    A：在递归右子节点 root.left=mirrorTree(root.right)执行完毕后，
       root.left 的值已经发生改变，此时递归左子节点 mirrorTree(root.left) 则会出问题
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
