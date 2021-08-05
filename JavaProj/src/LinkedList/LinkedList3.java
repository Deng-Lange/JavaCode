package LinkedList;

// 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
// 如果有两个中间结点，则返回第二个中间结点。
// 思路：
// 1.先求链表长度
// 2.根据链表长度/2的结果，让一个引用从头开始走这些步数即可。

class ListNode {
    int val;
    ListNode next;
    public ListNode(int v) {
        val = v;
    }
}

public class LinkedList3 {
    public int getLength(ListNode head) {
        // 遍历链表即可
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }

    public ListNode middleNode(ListNode head) {
        // 虽然题目要求中, 说了 head 是一个非空单链表.
        // 但是题目的实际测试用例, 可能不讲武德, 拿一个空链表偷袭你~
        // 实际面试的时候, 面试官一般还是希望你能写出这些合法性校验的代码的(良好的编程意识)
        if (head == null) {
            return null;
        }
        // 求链表的长度
        int length = getLength(head);
        // 针对长度 / 2, 得到的引用走的步数
        int steps = length / 2;
        // 控制引用往后走
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            //此处的解引用操作不会触发空指针异常，所以不用对 cur 判空
            cur = cur.next;
        }
        return cur;
    }
}
