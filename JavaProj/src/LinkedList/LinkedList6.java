package LinkedList;

// 给一定值 x ，编写一段代码将所有小于 x 的结点排在其余结点之前，
// 且不能改变原来的数据顺序，返回重新排列后的链表的头指针。

public class LinkedList6 {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        //链表只有一个结点
        if (pHead.next == null) {
            return pHead;
        }
        // 处理一般情况. 需要创建两个链表, 用来保存两部分结果.
        // 为了方便后续的尾插操作, 仍然使用带傀儡节点的链表, 同时记录链表末尾
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;

        ListNode largeHead = new ListNode(0);
        ListNode largeTail = largeHead;

        //遍历链表
        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                // 比基准值小, 就插入到 smallHead 的末尾
                // 由于旧的链表是使用 for 的方式直接遍历, 就会一直执行到 cur = cur.next
                // 通过这样的方式尾插, 可能会对原来链表的遍历造成影响.
                // 稳妥起见, 创建新的节点, 而不是拆掉旧的链表.
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                // 大于等于基准值, 就插入到 largeHead 的末尾
                largeTail.next = new ListNode(cur.val);
                largeTail = largeTail.next;
            }
        }
        // 经过了上面的循环, 此时链表已经被拆成两个部分了.
        // 第一部分就都是小于 x 的元素.
        // 第二部分就都是大于等于 x 的元素.
        // 最后一步, 需要把两个链表合并成一个, 直接收尾相接即可.
        smallTail.next = largeHead.next;
        return smallHead.next;
    }
}
