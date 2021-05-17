package Offer;

public class test28 {
    //请实现一个函数，用来判断一棵二叉树是不是对称的
    //如果一棵二叉树和它的镜像一样，那么它是对称的
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    // 判断两个树 p，q 的镜像关系：
    // 判断 p 和 q 的根节点是否相同 &&
    // 判断 p.left 和 q.right 是否是镜像关系 &&
    // 判断 p.right 和 q.left 是否是镜像关系
    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            // 一个为空, 一个不为空, 一定不是镜像关系
            return false;
        }
        // 先比较根节点的值是否相同
        if (p.val != q.val) {
            return false;
        }
        return isMirror(p.left, q.right)
                && isMirror(p.right, q.left);
    }
}
