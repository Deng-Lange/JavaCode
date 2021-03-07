package LinkedList;

//给定一个链表，判断链表中是否有环，如果链表中存在环，则返回 true，否则，返回 false
//方法一：使用一个顺序表把所有遍历过的结点存储起来，
//       每次取到下一个结点，都判定一下这个结点是否出现过，出现过就是带环的
//方法二：快慢指针法，创建两个引用 fast，slow，fast每次走两步，slow每次走一步，
//       如果链表不带环，fast就会率先到达终点 null；如果链表带环，fast 就会追上 slow

public class LinkedList10 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //只判断 fast 就可以了，因为 fast 走得快
        //因为 fast 要走两步，所以要判断 fsat.next
        while (fast != null && fast.next != null) {
            // fast 走两步，slow 走一步
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
