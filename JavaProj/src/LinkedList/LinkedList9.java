package LinkedList;

//编写一个程序，找到两个单链表相交的起始节点。
//1、分别求出两个链表的长度 l1，l2
//2、看两个链表谁长，
//   如果 l1>l2 ，就让 cur1 先走 l1-l2 步，如果 l1<l2 ，就让 cur2 先走 l2-l1 步
//3、此时 cur1 和 cur2 处在同一起跑线上，让他俩同时往后走，看是否相遇
//   相遇时的位置就是两个链表的交点

public class LinkedList9 {
    public int getLength(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 先求两个链表的长度
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        // 2. 比较两个链表的长度，让长的链表先走
        if (len1 > len2) {
            int steps = len1 - len2;
            for (int i = 0; i < steps; i++) {
                headA = headA.next;
            }
        } else {
            int steps = len2 - len1;
            for (int i = 0; i < steps; i++) {
                headB = headB.next;
            }
        }
        // 3. 此时 headA 和 headB 已经在同一起跑线上了. 于是就同步往后走, 看能否相遇
        while (headA != null && headB != null) {
            // 此处比较的不是节点里的 val，而是节点对象的身份（地址）.
            if (headA == headB) {
                // 相交了, 交点也找到了.
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}