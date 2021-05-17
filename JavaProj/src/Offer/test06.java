package Offer;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class test06 {
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
    /*
    1、创建一个栈，用于存储链表的节点
    2、创建一个指针，初始时指向链表的头节点
    3、当指针指向的元素非空时，重复下列操作：
       将指针指向的节点压入栈内
       将指针移到当前节点的下一个节点
    4、获得栈的大小 size，创建一个数组 print，其大小为 size
    5、创建下标并初始化 index = 0，重复 size 次下列操作：
       从栈内弹出一个节点，将该节点的值存到 print[index]
       将 index 的值加 1
    6、返回 print
    */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
