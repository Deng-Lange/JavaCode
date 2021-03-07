package Test0306;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //都实现了List接口
        List<String> list = new ArrayList<>();//顺序表
        List<String> linkedList = new LinkedList<>();//链表

        // 回忆一下 List 的方法.
        // 1. 插入元素
        // 直接 add 是进行尾插. 如果是单链表, 此时要想尾插就比较麻烦, 需要先找到尾节点.
        // 实际上咱们标准库中的链表采用的是双向带环链表(首尾相接)
        // 另外一种典型的实现, 也可以记录链表的尾部(可以不带环)
        linkedList.add("hello"); // 对于标准库的 LinkedList 的尾插操作是 O(1)

        // 中间位置插入. 使用 add 参数来指定插入的位置.
        // 按照下标取元素, 依赖 "随机访问能力" . 由于现在是链表, 往指定下标插入元素,
        // 就需要先找到该下标对应的位置, 然后再进行插入.
        linkedList.add(10, "c++"); // 对于标准库的 LinkedList 的中间位置插入 O(N)

        // 2. 删除元素. 无论是按照下标删除, 还是按照元素的值来删除, 都需要先遍历链表找到
        //    要删除的节点, 然后再进行删除操作.
        linkedList.remove(10); // 对于标准库的 LinkedList 的删除操作时间复杂度 O(N)

        // 3. 查找元素. 无论是给定下标找值, 还是给定值找下标, 都需要进行链表遍历.
        linkedList.indexOf("c++"); // 对于标准库的 LinkedList 的查找操作时间复杂度也是 O(N)
        linkedList.get(10);

        // 4. 修改元素.
        linkedList.set(10, "java"); // 对于标准库的 LinkedList 的修改操作时间复杂度也是 O(N)
    }
}
