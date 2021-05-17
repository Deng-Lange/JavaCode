package Offer;

public class test26 {
    //输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构(约定空树不是任意一个树的子结构)
    //B 是 A 的子结构，即 A 中有出现和 B 相同的结构和节点值
    /*
    若树 B 是树 A 的子结构，则子结构的根节点可能为树 A 的任意一个节点
    因此，判断树 B 是否是树 A 的子结构，需完成以下两步工作：
    1、先序遍历树 A 中的每个节点 n_A，对应函数 isSubStructure(A, B)
    2、判断树 A 中以 n_A 为根节点的子树是否包含树 B，对应函数 recur(A, B)
    recur(A, B) 函数：
    1、终止条件：
    当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true
    当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false
    当节点 A 和 B 的值不同：说明匹配失败，返回 false
    2、返回值：
    判断 A 和 B 的左子节点是否相等，即 recur(A.left, B.left)
    判断 A 和 B 的右子节点是否相等，即 recur(A.right, B.right)
    isSubStructure(A, B) 函数：
    1、特例处理：当树 A 为空或树 B 为空时，直接返回 false
    2、返回值：若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接
       以节点 A 为根节点的子树包含树 B，对应 recur(A, B)
       树 B 是树 A 左子树的子结构，对应 isSubStructure(A.left, B)
       树 B 是树 A 右子树的子结构，对应 isSubStructure(A.right, B)
     */
    // 判断树 A 中以 A 为根节点的子树是否包含树 B
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        // 节点 A 和 B 的值不同，说明匹配失败，返回 false
        if (A.val != B.val) {
            return false;
        }
        // 分别比较左右子节点是否相同（递归）
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    // 树的子结构 (另一个树的子树见Test0313)
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null||B == null) {
            return false;
        }
        // 以节点 A 为根节点的子树包含树 B
        boolean ret = recur(A, B);
        if (ret) {
            return ret;
        }
        // 递归的判定树 B 是不是树 A 左子树的子结构 || 递归的判定树 B 是不是树 A 右子树的子结构
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
}
