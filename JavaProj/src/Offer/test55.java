package Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test55 {
    //题一：输入一棵二叉树的根节点，求该树的深度。
    //从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
    /*
    方法一：后序遍历（DFS）
    此树的深度等于左子树的深度与右子树的深度中的最大值 +1。
    算法解析：
    1、终止条件：当 root​为空，说明已越过叶节点，因此返回深度 0。
    2、递推工作：本质上是对树做后序遍历。
        计算节点 root​的左子树的深度，即调用 maxDepth(root.left)；
        计算节点 root​的右子树的深度，即调用 maxDepth(root.right)；
    3、返回值：返回此树的深度，即 max(maxDepth(root.left), maxDepth(root.right)) + 1。
    方法二：层序遍历（BFS）
    每遍历一层，则计数器 +1，直到遍历完成，则可得到树的深度。
    算法解析：
    1、特例处理：当 root​为空，直接返回深度 0。
    2、初始化：队列 queue（加入根节点 root），计数器 res=0。
    3、循环遍历：当 queue 为空时跳出。
        初始化一个空列表 tmp，用于临时存储下一层节点；
        遍历队列：遍历 queue 中的各节点 node，并将其左子节点和右子节点加入 tmp；
        更新队列：执行 queue = tmp，将下一层节点赋值给 queue；
        统计层数：执行 res+=1，代表层数加 1；
    4、返回值：返回 res 即可。
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            List<TreeNode> tmp=new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) {
                    tmp.add(node.left);
                }
                if(node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            res++;
        }
        return res;
    }
    //题二：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
    //如果某二叉树中任意节点的左右子树的深度相差不超过 1，那么它就是一棵平衡二叉树。
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + (Math.max(leftHeight, rightHeight));
    }
    public boolean isBalanced(TreeNode root) {
        // 先进行遍历
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        // 访问当前节点
        // 访问操作其实就是计算左右子树的高度, 并求差值
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if ((leftHeight - rightHeight) > 1
                || (leftHeight - rightHeight) < -1) {
            return false;
        }
        // 递归处理左右子树的情况
        // 要求左子树和右子树都是平衡的, 才能说明整个树是平衡的
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
