package Offer;

public class test25 {
    // 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
    // 思路：
    // 创建一个新链表，用来表示合并结果，初始情况下是一个空链表；
    // 创建两个引用分别指向两个链表的第一个结点，
    // 比较这两个值的大小，将值较小的结点插入到结果链表的末尾；
    // 然后对应的引用也要移动到 next 的位置上；
    // 循环以上比较和插入的过程，直到两个引用的其中一个到达 null 即链表末尾；
    // 最后将另一个链表剩余的部分都插入到结果链表的末尾。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 两个链表都非空, 进行合并.
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        // 创建了一个新的链表, 用来保存最终结果.
        // 为了简化后续的插入操作，此处使用一个 带傀儡节点 的链表.
        // newHead 和 newTail 两个引用都指向傀儡结点
        ListNode newHead = new ListNode(0);
        // 后续需要频繁进行尾插. 为了尾插方便, 使用一个变量把链表的尾部给记录下来.
        // 虽然链表一般都是用头结点来表示, 但是也是完全可以通过其他引用记录其他位置. 典型的就是记录尾节点.
        ListNode newTail = newHead;

        // 进行循环遍历两个链表, 并比较. 任意引用到达链表末尾, 都算循环结束.
        while (cur1 != null && cur2 != null) {
            // 带傀儡结点的链表不用单独考虑空和非空的情况
            if (cur1.val < cur2.val) {
                // 就把 cur1 插入到新链表末尾
                newTail.next = cur1;
                // 更新循环变量
                cur1 = cur1.next;
            } else {
                // 就把 cur2 插入到新链表末尾
                newTail.next = cur2;
                // 更新循环变量
                cur2 = cur2.next;
            }
            newTail = newTail.next;
        }

        // 当上述循环结束, 意味着一定有一个引用已经先到达了链表末尾.
        // 于是就把另一个链表的剩余部分插入过来即可.
        if (cur1 == null) {
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }

        // 返回结果链表. 此时我们需要把傀儡节点跳过.
        return newHead.next;
    }
}
