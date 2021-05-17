package Offer;

public class test24 {
    //定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
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
            // 逆向--关键一步
            curNode.next = prevNode;
            // 更新引用的位置
            prevNode = curNode;
            curNode = nextNode;
        }
        return newHead;
    }
}
