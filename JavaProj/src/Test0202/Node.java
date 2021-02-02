package Test0202;

// 使用 Node 表示链表的节点
public class Node {
    public int val;
    public Node next = null;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}