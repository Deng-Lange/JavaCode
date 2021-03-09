package Test0308;

//栈的核心操作：
//入栈：把元素放到栈里
//出栈：把最后进来的元素删掉
//取栈顶元素：获取到最后一个进来的元素的结果

// 使用链表来实现栈（后进先出）
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyStack2 {
    // 此处使用不带傀儡节点的链表来表示.
    // 如果使用带傀儡节点的链表的话, 就更简单了.
    private Node head = null;

    // 核心操作
    // 1. 入栈--头插
    public void push(int val) {
        Node newNode = new Node(val);
        // 把新节点进行头插
        // 由于当前是不带傀儡节点的, 所以就需要判定当前链表是空还是非空
        if (head == null) {
            head = newNode;
            return;
        }
        //非空
        newNode.next = head;
        head = newNode;
    }

    // 2. 出栈--头删，返回值就是被出栈了的那个元素
    public Integer pop() {
        if (head == null) {
            return null;
        }
        //只有一个元素，删完是空链表
        if (head.next == null) {
            int ret = head.val;
            head = null;
            return ret;
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }

    // 3. 取栈顶元素--取头结点
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
