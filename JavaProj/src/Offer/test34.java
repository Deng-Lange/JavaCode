package Offer;

import java.util.LinkedList;
import java.util.List;

public class test34 {
    //输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
    //从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
    /*
    先序遍历：按照 “ 根、左、右 ” 的顺序，遍历树的所有节点.
    路径记录：在先序遍历中，记录从根节点到当前节点的路径。
             当路径为根节点到叶节点形成的路径且各节点值的和等于目标值 sum 时，
             将此路径加入结果列表。
    算法流程：
    pathSum(root, sum) 函数：
    1、初始化：结果列表 res，路径列表 path
    2、返回值：返回 res 即可
    recur(root, tar) 函数：
    1、递推参数：当前节点 root，当前目标值 tar
    2、终止条件：若节点 root 为空，则直接返回
    3、递推工作：
        路径更新：将当前节点值 root.val 加入路径 path；
        目标值更新：tar = tar - root.val（即目标值 tar 从 sum 减至 0）；
        路径记录：当 root 为叶节点且路径和等于目标值，则将此路径 path 加入 res。
        先序遍历：递归左 / 右子节点。
        路径恢复：向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop()。
     */
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
