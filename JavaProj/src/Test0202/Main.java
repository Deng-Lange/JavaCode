package Test0202;

public class Main {
    // 通过这个方法, 创建出一个固定内容的链表.
    // 使用头结点来代指整个链表.
    // 让方法把头结点返回回去就行了
    public static Node createList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return a;
    }

    public static void main(String[] args) {
        Node head = createList();

        // 1. 遍历链表, 打印链表的每个元素
        // 将引用 head 中的地址赋值给新的引用 cur
//        for (Node cur = head; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }

        // 2. 遍历链表, 找到链表的最后一个节点
//        head = null; // 链表的头节点是 null, 此时就表示一个空的链表(一个节点都没有的链表)
//
//        Node cur = head;
//        while (cur != null && cur.next != null) {
//            cur = cur.next;
//        }
//        // 一旦循环结束,
//        // cur 就指向了链表的最后一个节点.
//        System.out.println(cur.val);

        // 3. 遍历链表, 找到链表的倒数第二个节点.
        // 特点就是 .next.next 为 null
//        Node cur = head;
//        while (cur != null && cur.next != null && cur.next.next != null) {
//            cur = cur.next;
//        }
//        System.out.println(cur.val);

        // 4. 取链表的第 N 个节点. (从 1 开始算的)
//        int N = 3;
//        Node cur = head;
        // 走 N - 1 步
//        for (int i = 1; i < N; i++) {
//            cur = cur.next;
//        }
//        // 此时 cur 指向的元素, 就是正数第 N 个元素.
//        System.out.println(cur.val);

        // 5. 获取链表的长度
//        int count = 0;
//        for (Node cur = head; cur != null; cur = cur.next) {
//            count++;
//        }
//        System.out.println(count);

        // 结合 5,6 两个代码可以实现获取倒数第 N 个元素
        // 1 2 3 4
        // 倒数第 2 个就是正数第 3 个
        // 正数第 3 个 = size + 1 - N

        // 6. 遍历链表, 查找链表上是否存在某个元素
//        int toFind = 3;
//        Node cur = head;
//        for (; cur != null; cur = cur.next) {
//            if (cur.val == toFind) {
//                break;
//            }
//        }
//        if (cur != null) {
//            System.out.println("找到了");
//        } else {
//            System.out.println("没找到");
//        }
    }
}
