package Offer;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;
    public Node left;
    public Node right;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class test35 {
    //给一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random，该指针可以指向链表中的任何节点或空节点
    //构造这个链表的深拷贝，深拷贝应该正好由 n 个全新节点组成，其中每个新节点的值都设为其对应的原节点的值
    //新节点的 next 指针和 random 指针也都应指向复制链表中的新节点
    //并使原链表和复制链表中的这些指针能够表示相同的链表状态，复制链表中的指针都不应指向原链表中的节点
    public Node copyRandomList(Node head) {
        // 1. 先遍历旧链表，把每个旧节点都创建对应的新节点，并且插入到 map 中
        // 以旧节点为 key，新节点为 value，插入到 map中
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2. 再次遍历旧链表，构造 next / random 的指向
        // 例如：预期让 新1.next=新2
        // 通过 map.get(旧1)获取 新1，map.get(旧1.next)获取 新2 (旧2=旧1.next)
        // 例如：预期让 新1.random=新3
        // 通过 map.get(旧1)获取 新1，map.get(旧1.random)获取 新3 (旧3=旧1.random)
        for (Node oldNode = head; oldNode != null; oldNode = oldNode.next) {
            // 把 next 相互连接
            Node newNode = map.get(oldNode);
            Node newNodeNext = map.get(oldNode.next);
            newNode.next = newNodeNext;
            // 把 random 也相互连接
            Node newNodeRandom = map.get(oldNode.random);
            newNode.random = newNodeRandom;
        }
        return map.get(head);
    }
}
