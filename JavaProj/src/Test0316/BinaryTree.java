package Test0316;

import java.util.*;

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
        // 这个变量为 true, 表示当前是第一阶段
        // 这个变量为 false, 表示当前是第二阶段
        boolean isLevel1 = true;

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
            if (isLevel1) {
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
                    isLevel1 = false;
                    queue.offer(cur.left);
                } else {
                    // 这个节点没有子树，左右子树都为空
                    // 也是进入到第二阶段继续判定
                    isLevel1 = false;
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

    // 给定一个二叉树，找到该树中两个指定节点的最近公共祖先（一个节点也可以是它自己的祖先）
    // 从某个结点出发，如果能同时找到 p 和 q，说明这个结点是公共祖先
    // 判断最近的公共祖先：如果从该结点出发进行查找时，p 和 q 主要从三个渠道进行查找
    // 1、当前结点自身是不是 p 或 q
    // 2、左子树是否包含 p 或 q
    // 3、右子树是否包含 p 或 q
    // 如果 p 和 q 来自于这三个渠道中的两个，那么这个结点就是最近公共祖先
    // 为了更方便的获取到最终结果，使用一个成员变量来记录，最近公共祖先 lca
    public TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 递归查找 p 和 q，用一个辅助方法进行递归
        findNode(root, p, q);
        return lca;
    }
    // 如果当前 root 中能找到 p 或者 q，找到一个就返回 true
    // 如果 p 和 q 都没找到，就返回 false
    public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            // 空树里肯定找不到，就返回 false
            return false;
        }
        // 使用 ? : 把 boolean 转换成整数
        // 从三个渠道分别查找
        // 判定根结点是不是 p 或 q
        int mid = (root == p || root == q) ? 1 : 0;
        // 在左子树中查找 p 和 q
        int left = findNode(root.left, p, q) ? 1 : 0;
        // 在右子树中查找 p 和 q
        int right = findNode(root.right, p, q) ? 1 : 0;
        // 最重要的步骤，判定该结点是否是 lca
        // 如果 p 和 q 来自于这三个渠道中的两个，那么这个结点就是 lca
        if (mid + left + right == 2) {
            lca = root;
        }
        // 只要找到了其中的 p 或者 q 中的一个, 都可以返回 true
        // 要是找到两个也是返回 true
        // 一个都没找到才是返回 false
        return (left + right + mid) > 0;
    }

    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    // 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    // 它的左、右子树也分别为二叉搜索树。
    // 二叉搜索树的特点：中序遍历能够得到一个有序的序列
    // 要求不能创建任何新的结点，只能调整树中结点指针的指向。
    public TreeNode Convert(TreeNode pRootOfTree) {
        // 判定特殊情况
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        // 处理一般情况
        // 1. 先递归的把左子树转成链表
        //    得到的 leftHead 可能是 null, 下面在使用的时候要考虑到这个细节
        TreeNode leftHead = Convert(pRootOfTree.left);
        // 2. 把根节点尾插到 leftHead 这个链表中
        //    需要找到 leftHead 的末尾节点才能尾插
        TreeNode leftTail = leftHead;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 找到了尾结点
        if (leftHead != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 3. 递归的把右子树转成链表
        TreeNode rightHead = Convert(pRootOfTree.right);
        // 4. 把跟节点头插到右侧链表的前面
        if (rightHead != null) {
            pRootOfTree.right = rightHead;
            rightHead.left = pRootOfTree;
        }
        // 需要返回最终链表的头结点
        // 注意，leftHead 可能是空链表
        // 如果是空链表，整体的头结点就应该是 pRootOfTree
        return leftHead != null ? leftHead : pRootOfTree;
    }

    // 根据一棵树的先序遍历与中序遍历构造二叉树
    /*
    依次取出先序遍历的每个节点，取出的第一个节点 A，一定是根节点，
    再取第二个节点 B，不能确定 B 是 A 的左子树还是右子树，此时看中序遍历，
    如果 B 在 A 的左侧，那么 B 就是 A 的左子树，
    如果 B 在 A 的右侧，那么 B 就是 A 的右子树，以此类推
     */
    // 成员变量，index 表示当前访问到 先序 中的第几个元素
    public int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 由于输入的用例可能有多组，所以在方法入口这里把 index 还原成 0，防止多个用例之间干扰
        index = 0;
        // 辅助递归方法中后两个参数表示当前这个子树对应的中序遍历结果
        // 使用这一对下标表示当前子树的中序遍历结果是在 inorder 的那个部分上
        return _buildTree(preorder, inorder,0,inorder.length);
    }
    // [inorderLeft, inorderRight) 标注了一个前闭后开的区间
    // inorder 数组上的这个区间中的内容, 就正是当前子树的中序遍历结果
    public TreeNode _buildTree(int[] preorder, int[] inorder,
                               int inorderLeft, int inorderRight) {
        if(inorderLeft>inorderRight){
            //中序区间是一个空区间，说明当前子树是空树
            return null;
        }
        if (index >= preorder.length) {
            //先序结果遍历完毕，整个树就处理完了
            return null;
        }
        //处理一般情况，仍然是进行先序遍历
        //访问结点操作不是打印，而是构建结点
        TreeNode root = new TreeNode(preorder[index]);
        //查找当前结点在中序区间中所处的位置
        int pos = find(inorder,inorderLeft,inorderRight,root.val);
        //有了 pos 之后，就知道了当前结点左右子树的中序区间
        //左子树的中序区间：[inorderLeft,pos)
        //右子树的中序区间：(pos+1,inorderRight]
        //递归处理左右子树
        //此处 index 只 ++ 一次
        //如果遍历结果中有空节点，就要 ++ 两次
        //如果没有空节点，只 ++ 一次
        index++;
        root.left = _buildTree(preorder, inorder, inorderLeft, pos);
        root.right = _buildTree(preorder, inorder, pos+1, inorderRight);
        return root;
    }
    private int find(int[] array, int left, int right, int toFind) {
        for(int i=left;i<right;i++){
            if(array[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    //你需要采用先序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串
    //空节点则用一对空括号 "()" 表示，需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对
    //核心就是先序遍历，打印节点是加上括号，考虑清楚什么时候 "()" 可以省略
    //左右子树都为空，可以省略左右子树的空（）
    //左子树为空，右子树不为空，不可以省略左子树的空（）
    //左子树不为空，右子树为空，可以省略右子树的空（）
    //使用一个成员变量，通过这个成员变量来记录最终结果，随时在递归过程中把得到的结果拼接到 result 里面
    public StringBuilder result2 = null;//可变字符串，线程不安全
    public String tree2str(TreeNode t) {
        //防止用例之间相互影响
        result2 = new StringBuilder();
        if (t == null) {
            return "";
        }
        // 通过 helper 方法辅助进行先序遍历的递归
        // 在递归过程中逐渐构造出 result 了
        helper2(t);
        // 手动把最外层括号给删了!
        result2.deleteCharAt(0);
        result2.deleteCharAt(result2.length() - 1);
        return result2.toString();
    }
    public void helper2(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问当前根节点
        result2.append("(");
        result2.append(root.val);
        //递归处理左子树
        helper2(root.left);
        if (root.left == null && root.right != null) {
            result2.append("()");
        }
        //递归处理右子树
        helper2(root.right);
        result2.append(")");
    }

    //前序的非递归实现
    /*
    1、创建一个栈
    2、把根节点入栈
    3、取出栈顶元素，访问这个节点（打印）
    4、把当前结点的右子树入栈，左子树入栈（非空）
    5、回到 3，重复执行
    */
    public static void preOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        // 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 把根节点入闸
        stack.push(root);
        while (!stack.isEmpty()) {
            //取栈顶元素
            //要保证栈不能为空，否则会抛异常
            TreeNode cur = stack.pop();
            System.out.print(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //中序的非递归实现
    /*
    1、创建一个栈
    2、创建一个引用 cur，从 root 出发，一路向左跑，遇到的非空节点都入栈，
       当 cur 遇到 null 时，就循环结束
    3、取出栈顶元素，并访问（cur为空时才能取栈顶元素）
    4、让 cur 指向该节点的右子树，回到 2 继续执行
     */
    public static void inOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            // 里层循环负责 cur 往左走并入栈这件事
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 当上面循环结束, cur 就已经是 null
            // 取出栈顶元素, 并且访问
            // 取栈顶元素前先判断栈是否为空
            if (stack.isEmpty()) {
                // 栈为空，说明遍历完了
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val);
            // 让 cur 从 top 的右子树出发重复上述过程
            cur = top.right;
        }
    }

    //后序的非递归实现
    /*
    1、创建一个栈
    2、创建一个引用 cur，从 root 出发，一路向左走，遇到非空节点就入栈，
       遇到空节点就循环结束
    3、栈顶元素不能立刻访问，先判断：
       a)如果栈顶的右子树为空，就可以访问栈顶元素，访问的同时出栈
       b)如果栈顶的右子树已经访问过了，也可以访问栈顶元素，访问的同时出栈
    4、如果栈顶元素不能被访问，就让 cur 指向栈顶的右子树，回到 2，继续执行
     */
    public static void postOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //使用 prev 表示遍历结果的前一个元素
        TreeNode prev = null;
        while (true) {
            //让 cur 往左走，遇到非空节点就入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //取出栈顶元素判断能不能访问
            if (stack.isEmpty()) {
                // 遍历结束
                break;
            }
            //此处不能直接 pop 出栈，该节点能不能访问还不知道呢
            //必须是能访问才能出栈
            TreeNode top = stack.peek();
            //遍历结果的前一个元素如果和栈顶的右子树一样，说明栈顶的右子树已经访问过了
            if (top.right == null || top.right == prev) {
                System.out.print(top.val);
                stack.pop();
                prev = top; //更新 prev 的指向
            } else {
                cur = top.right;
            }
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
        preOrderByLoop(root);
        System.out.println();
        inOrderByLoop(root);
        System.out.println();
        postOrderByLoop(root);
    }
}
