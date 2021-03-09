package Test0308;

// 使用链表实现队列（先进先出）
public class MyQueue {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    // 创建一个链表的头结点
    // 为了方便的进行尾插, 也记录尾节点.
    private Node head = null;
    private Node tail = null;

    // 队列的核心操作
    // 1. 入队列--尾插, 返回值表示插入成功/失败 (也是为了和标准库的队列的 offer 接口看齐)
    public boolean offer(int val) {
        Node newNode = new Node(val);
        // 插入到链表尾部. 需要考虑当前链表是否为空
        if (head == null) {
            // 直接让 head 和 tail 指向新节点即可.
            head = newNode;
            tail = newNode;
            return true;
        }
        tail.next = newNode;
        tail = tail.next;
        return true;
    }

    // 2. 出队列--头删
    public Integer poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        if (head.next == null) {
            head = null;
            return ret;
        }
        head = head.next;
        return ret;
    }

    // 3. 取队首元素--获取头结点
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
