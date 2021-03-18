package Test0313;

import java.util.ArrayList;
import java.util.List;

class Node {
    String val;
    Node left;
    Node right;

    public Node(String val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTree {
    // 创建一个树(手动写死的方式)
    public static Node build() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    // 先序遍历
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        // 访问根节点. 此处的访问就是打印操作
        System.out.print(root.val);
        // 递归遍历左子树
        preOrder(root.left);
        // 递归遍历右子树
        preOrder(root.right);
    }

    // 中序遍历
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        // 先递归处理左子树
        inOrder(root.left);
        // 再访问根节点
        System.out.print(root.val);
        // 最后递归处理右子树
        inOrder(root.right);
    }

    // 后序遍历
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        // 先递归处理左子树
        postOrder(root.left);
        // 再递归处理右子树
        postOrder(root.right);
        // 最后打印根节点
        System.out.print(root.val);
    }

    // 使用这个成员变量 count, 来记录元素的个数
    public static int count = 0;
    public static void length(Node root) {
        if (root == null) {
            return;
        }
        // 访问根节点, 此时的访问操作就是 count++
        count++;
        // 递归处理左子树
        length(root.left);
        // 递归处理右子树
        length(root.right);
    }

    // 接下来还是实现 length, 此时通过方法的返回值来记录元素个数
    public static int length2(Node root) {
        if (root == null) {
            return 0;
        }
        // 当前树的节点个数 = 根节点的个数 + 左子树的节点个数 + 右子树的节点个数
        return 1 + length2(root.left) + length2(root.right);
    }

    public static int leafSize = 0;
    public static void getLeafSize(Node root) {
        // 针对二叉树遍历, 判断当前节点是否是叶子节点. 如果是就 size++
        if (root == null) {
            return;
        }
        // 判断当前节点是否是叶子节点
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }

    public static int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        //当前节点是叶子结点
        if (root.left == null && root.right == null) {
            return 1;
        }
        //当前结点不是叶子结点
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    public static int getKLevelSize(Node root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            // 如果当前树非空, 第一层节点一定是 1 个元素.
            return 1;
        }
        //求第 k 层结点的个数 = 求左子树的第 k-1 层结点个数 + 求右子树的第 k-1 层结点个数
        //求 A 的第三层结点个数 = 求 B 的第二层结点个数 + 求 C 的第二层结点个数
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    //求 A 的高度 = 1 + B 的高度和 C 的高度的较大值
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    //查找树上的某个元素
    public static Node find(Node root, String toFind) {
        if (root == null) {
            return null;
        }
        if (root.val.equals(toFind)) {
            return root;
        }
        //先找左子树，如果找到了直接返回结果
        Node result = find(root.left, toFind);
        if (result != null) {
            return result;
        }
        //没找到，再找右子树
        return find(root.right, toFind);
    }

    //二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
            // 不要 return null;
        }
        // 先访问根节点. 此处的 "访问" 不是打印, 而是插入 result 末尾
        result.add(root.val);
        // 递归处理左子树, 此时会得到一个左子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(preorderTraversal(root.left));
        // 递归处理右子树
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 递归处理左子树
        result.addAll(inorderTraversal(root.left));
        // 访问根节点
        result.add(root.val);
        // 递归处理右子树
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 递归处理左子树
        result.addAll(postorderTraversal(root.left));
        // 递归处理右子树
        result.addAll(postorderTraversal(root.right));
        // 访问根节点
        result.add(root.val);
        return result;
    }

    //检查两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            // 进入这个条件意味着, 一定是 p 和 q 其中一个为空, 一个不为空
            return false;
        }
        // 都不为空树, 先判定根节点的值是不是相同
        if (p.val != q.val) {
            return false;
        }
        // 根节点相同, 再分别比较左右子树是不是相同（递归）
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //另一棵树的子树
    //遍历 s，看 s 上的某个结点对应的子树是否和 t 这个树是相等的
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean ret = isSameTree(s, t);
        if (ret) {
            return ret;
        }
        //如果不相等，再递归的判定 s 的左子树是否包含 t || 递归的判定 s 的右子树是否包含 t
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    //二叉树最大数深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    public static void main(String[] args) {
        Node root = build();
//        preOrder(root);
//        inOrder(root);
//        postOrder(root);
//        length(root);
//        System.out.println(count);
//        System.out.println(length2(root));
//        getLeafSize(root);
//        System.out.println(leafSize);
//        System.out.println(getLeafSize2(root));
//        System.out.println(getKLevelSize(root, 3));
        System.out.println(getHeight(root));
    }
}
