package LinkedList;

//给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null
//结论：从链表的头部出发到达环入口点的距离，
//     和从 fast slow 交汇处出发到达环入口点的距离是一样的

public class LinkedList11 {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针, 先找到快慢指针重合的位置.
        ListNode fast = head;
        ListNode slow = head;
        // 链表不带环
        if (fast == null || fast.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //相交了
            if (fast == slow) {
                break;
            }
        }
        // 如果带环, 从链表头 和 fast slow 交汇位置同时出发, 两个引用相遇位置就是环的入口
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            // 在解引用之前, 比如 cur1.next 之前要保证 cur1 是非空的.
            // 当前链表已经是带环了, 带环的链表上没有 null
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
