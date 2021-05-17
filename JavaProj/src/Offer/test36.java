package Offer;

public class test36 {
    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
    //要求不能创建任何新的节点，只能调整树中节点指针的指向。
    /*
    解题思路：
    将二叉搜索树转换成一个排序的循环双向链表，其中包含三个要素：
    排序链表：节点应从小到大排序，因此应使用中序遍历从小到大访问树的节点。
    双向链表：在构建相邻节点的引用关系时，设前驱节点 pre 和当前节点 cur，不仅应构建 pre.right = cur，也应构建 cur.left = pre。
    循环链表：设链表头节点 head 和尾节点 tail，则应构建 head.left = tail 和 tail.right = head。

    算法流程：
    dfs(cur)：递归法中序遍历
    1、终止条件：当节点 cur 为空，代表越过叶节点，直接返回；
    2、递归左子树，即 dfs(cur.left)；
    3、构建链表：当 pre 为空时，代表正在访问链表头节点，记为 head；
                当 pre 不为空时，修改双向节点引用，即 pre.right = cur，cur.left = pre；
                保存 cur，更新 pre = cur，即节点 cur 是后继节点的 pre；
    4、递归右子树，即 dfs(cur.right)；
    treeToDoublyList(root)：
    1、特例处理：若节点 root 为空，则直接返回；
    2、初始化：空节点 pre；
    3、转化为双向链表：调用 dfs(root)；
    4、构建循环链表：中序遍历完成后，head 指向头节点，pre 指向尾节点，因此修改 head 和 pre 的双向节点引用即可；
    5、返回值：返回链表的头节点 head 即可。
     */
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        //中序遍历完成后，head 指向头节点，pre 指向尾节点
        //连接头节点和尾节点，使链表变为循环链表
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) {
            return;
        }
        dfs(cur.left);
        if(pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
