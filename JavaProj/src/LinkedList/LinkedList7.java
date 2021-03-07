package LinkedList;

// 在一个排序的链表中存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
// 例如，链表 1->2->3->3->4->4->5 处理后为 1->2->5
// 有序链表中重复的结点一定是相邻的
// 如果当前结点是重复结点，直接跳过，找下一个不重复的结点，如果不是就把这个结点插入到新链表中
// 重复结点不一定只重复一次

public class LinkedList7 {
    public ListNode deleteDuplication(ListNode pHead) {
        // 先考虑特殊情况
        if (pHead == null) {
            return null;
        }
        // 链表里只有一个节点
        if (pHead.next == null) {
            return pHead;
        }
        // 用来保存结果的链表. 这个链表也是一个 带傀儡节点 的链表.
        // 为了尾插方便, 记录链表的尾部
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        // 遍历链表, 判定其中是否存在重复的节点
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                // 发现 cur 是重复节点, 就需要找到接下来不重复的节点位置.
                // 该循环结束, 要么是 cur 已经到达了链表末尾, 要么是 cur 已经到达了重复元素中的最后一个.
                // 此时需要让 cur 再往后走一步, 指向下一个不重复的节点（第40行）
                while (cur != null && cur.next != null
                        && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            } else {
                // cur 不是重复节点. 直接插入到 newHead 末尾即可.
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
            }
            // 循环需要往下走一步.
            cur = cur.next;
        }
        return newHead.next;
    }
}
