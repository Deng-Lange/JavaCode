package LinkedList;

public class LinkedList1 {
    //删除链表中等于给定值 val 的所有节点。
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 删除操作需要找到当前节点的前一个节点
        ListNode prev = head; // 待删除节点的前一个节点
        ListNode cur = head.next; // 待删除节点
        while (cur != null) {
            if (cur.val == val) {
                // 如果找到了值为 val 的节点，就需要删除这个节点
                prev.next = cur.next;
                cur = prev.next;
            } else {
                // 如果没找到, 更新 prev 和 cur 的位置
                prev = prev.next;
                //当 cur 指向的节点被删除后，就要让 cur 回到链表正确位置上
                cur = cur.next;
            }
        }
        // 删除操作也需要单独考虑待删除元素是头结点的情况.
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
