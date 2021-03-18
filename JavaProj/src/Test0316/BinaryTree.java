package Test0316;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTree {
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }
    //给定一个二叉树，判断它是否是高度平衡的二叉树
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
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

    //给定一个二叉树，检查它是否是镜像对称的
    //主要是看左右子树是否满足镜像关系
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

    //层序遍历（借助队列）
    //1、先把根节点放到队列里
    //2、进行出队列操作，并访问这个结点
    //3、把当前结点的左子树和右子树再入队列
    //4、回到 2，继续循环执行
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        //把根节点入队列
        queue.offer(root);
        //循环取队列中的队首元素
        while (true) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                break;
            }
            // 访问当前节点. 就用打印表示访问即可.
            System.out.print(cur.val);
            // 把该节点的左子树入队列, 右子树入队列
            // 选中代码，ctrl+alt+t，选择包裹代码的语句
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //判断一棵树是不是完全二叉树
    //1、对这棵树进行层序遍历
    //2、第一阶段：
    //   要求每个被访问到的结点都要有两个子树
    //   如果当前结点只有左子树，则进入第二阶段
    //   如果当前结点没有子树，也进入第二阶段
    //   如果当前结点只有右子树，则认为这不是完全二叉树
    //3、第二阶段：
    //   要求每个被访问到的结点必须没有子树
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 分成两个阶段来进行判定
        // 这个变量为 false, 表示当前是第一阶段,
        // 这个变量为 true, 表示进入第二阶段
        boolean isLevel2 = false;

        // 层序遍历, 需要有一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 通过层序遍历的方式来实现
        while (true) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                break;
            }
            // 针对当前节点进行访问.
            // 此处的访问是一系列的逻辑判断
            if (!isLevel2) {
                // 第一阶段的逻辑
                if (cur.left != null && cur.right != null) {
                    // 这是一个符合要求的节点, 继续往下遍历即可.
                    // 此时直接把左右子树入队列即可
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    // 第一阶段中发现只有右子树的节点
                    // 说明这个树一定不是完全二叉树
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    // 遇到了这个节点不符合第一阶段的条件,
                    // 进入到第二阶段继续判定
                    isLevel2 = true;
                    queue.offer(cur.left);
                } else {
                    // 这个节点没有子树，左右子树都为空
                    // 也是进入到第二阶段继续判定
                    isLevel2 = true;
                }
            } else {
                // 第二阶段的逻辑
                if (cur.left != null || cur.right != null) {
                    // 发现第二阶段的某个节点的子树不为空, 此时就认为不是完全二叉树
                    return false;
                }
            }
        }
        // 遍历了整个树, 也没找到 return false 的反例.
        return true;
    }

    //二叉树的分层遍历
    //使用一个成员变量记录最终结果
    //即使代码递归了很深，也能随时操作这个变量
    public static List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        //为了保证多组用例之间不干扰，需要把 result 每次重新初始化
        result=new ArrayList<>();
        if(root==null){
            return result;
        }
        //让层数从 0 开始算
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int level) {
        //刚开始创建的 result 的长度为 0，如果直接 get 取下标
        //就会产生下标越界异常
        //需要提前把对应的实例创建好，插入到 result 中
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if(root.left!=null){
            helper(root.left,level+1);
        }
        if(root.right!=null){
            helper(root.right,level+1);
        }
    }

    //创建一棵树
    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        levelOrder(root);
    }
}
