package Offer;

public class test54 {
    //给定一棵二叉搜索树，请找出其中第 k 大的节点。
    /*
    解题思路：
        本文解法基于此性质：二叉搜索树的中序遍历为递增序列。
        根据以上性质，易得二叉搜索树的中序遍历倒序为递减序列。
        因此，求 “二叉搜索树第 k 大的节点” 可转化为求 “此树的中序遍历倒序的第 k 个节点”。
    递归解析：
    1、终止条件：当节点 root 为空（越过叶节点），则直接返回；
    2、递归右子树：即 dfs(root.right)；
    3、三项工作：
        提前返回：若 k=0，代表已找到目标节点，无需继续遍历，因此直接返回；
        统计序号：执行 k=k−1（即从 k 减至 0 ）；
        记录结果：若 k=0，代表当前节点为第 k 大的节点，因此记录 res=root.val；
    4、递归左子树：即 dfs(root.left)；
     */
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.right);
        if(k == 0) {
            return;
        }
        k--;
        if(k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}
