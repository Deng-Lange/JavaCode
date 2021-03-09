package LinkedList;

//反转一个单链表

public class LinkedList2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            // 链表里只有一个节点
            return head;
        }
        // 处理一般情况
        ListNode newHead = null;
        ListNode prevNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            // 进入循环的时候, 需要先设定好 nextNode 的位置
            ListNode nextNode = curNode.next;
            if (nextNode == null) {
                // curNode 就指向了链表的最后一个节点
                // 也就是反转后的新链表的头结点
                newHead = curNode;
            }
            // 逆向 关键一步
            curNode.next = prevNode;
            // 更新引用的位置
            prevNode = curNode;
            curNode = nextNode;
        }
        return newHead;
    }
}
