package LinkedList;

//对于一个链表，判断其是否为回文结构
//给定一个链表的头指针A，请返回一个 bool值，代表其是否为回文结构

public class LinkedList8 {
    public boolean chkPalindrome(ListNode A) {
        // 空链表，直接返回 true
        if (A == null) {
            return true;
        }
        // 一个结点，直接返回 true
        if (A.next == null) {
            return true;
        }
        // 1. 把原来的链表复制一份.
        //创建一个带傀儡结点的链表
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        // 遍历原来的链表，进行尾插
        for (ListNode cur = A; cur != null; cur = cur.next) {
            newTail.next = new ListNode(cur.val);
            newTail = newTail.next;
        }
        // B 是一个复制出来的不带傀儡结点的新链表
        ListNode B = newHead.next;
        // 2. 把新链表逆置
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // cur 就指向最后一个节点了, 也就是逆置后的链表的头结点.
                B = cur;
            }
            // 逆置的核心操作: 掰道岔
            cur.next = prev;
            // 更新循环变量
            prev = cur;
            cur = next;
        }
        // 3. 对比两个链表是否一样
        ListNode cur1 = A;
        ListNode cur2 = B;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                // 找到了反例, 不是回文
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 找了一圈下来也没找到反例, 于是就判定这是回文
        return true;
    }

    public int getLength(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }

    // 空间复杂度 O(1) 的版本.
    // 找到链表的中间节点, 把后半部分逆置, 对比前后两个半个链表是否一致.
    public boolean chkPalindrome2(ListNode A) {
        if (A == null) {
            // 空链表, 直接返回 true
            return true;
        }
        if (A.next == null) {
            return true;
        }
        // 1. 找到中间节点
        int length = getLength(A);
        int steps = length / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        // 经历了上述循环, B 就指向了链表的中间节点.
        // 2. 针对 B 这个半个链表进行逆置.
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                B = cur;
            }
            // 掰道岔
            cur.next = prev;
            // 更新循环变量
            prev = cur;
            cur = next;
        }
        // 3. 对比两个半个链表是否一样.
        ListNode cur1 = A;
        ListNode cur2 = B;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }
}
