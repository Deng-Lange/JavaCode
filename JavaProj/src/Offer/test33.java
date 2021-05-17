package Offer;

public class test33 {
    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
    //如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
    /*
    后序遍历定义： [ 左子树 | 右子树 | 根节点 ]，即遍历顺序为 左、右、根
    二叉搜索树定义：左子树中所有节点的值 < 根节点的值；
                  右子树中所有节点的值 > 根节点的值；
                  其左、右子树也分别为二叉搜索树。
    递归解析：
    1、终止条件：当 i≥j，说明此子树节点数量 ≤1，无需判别正确性，因此直接返回 true；
    2、递推工作：
       a、划分左右子树：遍历后序遍历的 [i,j] 区间元素，寻找第一个大于根节点的节点，索引记为 m
       此时，可划分出左子树区间 [i,m−1]、右子树区间 [m,j−1]、根节点索引 j
       b、判断是否为二叉搜索树：
       左子树区间 [i,m−1] 内的所有节点都应 <postorder[j]，而 a 步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可
       右子树区间 [m,j−1] 内的所有节点都应 >postorder[j]，实现方式为遍历，当遇到 ≤postorder[j] 的节点则跳出；则可通过 p=j 判断是否为二叉搜索树。
    3、返回值：所有子树都需正确才可判定正确，因此使用与逻辑符 && 连接
       p=j：判断此树是否正确
       recur(i,m−1)：判断此树的左子树是否正确
       recur(m,j−1)：判断此树的右子树是否正确
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) {
            return true;
        }
        int p = i;
        //寻找第一个大于根节点的节点
        while(postorder[p] < postorder[j]) {
            p++;
        }
        //找到了，记为 m
        int m = p;
        while(postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
