package Test0204;

class ListNode {
    int val = 0;
    ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    // 删除链表中的所有元素
    // 先删除一般节点，再删除头节点
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 删除操作是需要找到当前节点的前一个节点的.
        ListNode prev = head; // 待删除的节点的前一个节点
        ListNode cur = head.next; // 待删除节点
        while (cur != null) {
            if (cur.val == val) {
                // 如果找到了值为 val 的节点
                // 就需要删除这个节点
                prev.next = cur.next;
                cur = prev.next;
            } else {
                // 如果没找到, 更新 prev 和 cur 的位置
                prev = prev.next;
                //当cur指向的节点被删除后，就要让cur回到链表正确位置上
                cur = cur.next;
            }
        }
        // 删除操作也需要单独考虑待删除元素是头结点的情况.
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    // 链表逆置
    public ListNode reverseList(ListNode head) {
        // 写任意代码的时候, 都要记得把特殊情况都得处理到位
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
                // curNode 就指向了链表的最后一个节点.
                // 也就是反转后的新链表的头结点
                newHead = curNode;
            }
            // 逆向
            curNode.next = prevNode;
            // 更新引用的位置
            prevNode = curNode;
            curNode = nextNode;
        }
        return newHead;
    }

    public static void print(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        Solution solution = new Solution();
//        ListNode result = solution.removeElements(a,2);
        ListNode result = solution.reverseList(a);
        print(result);
    }
}
