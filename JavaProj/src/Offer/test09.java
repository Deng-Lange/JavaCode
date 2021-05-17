package Offer;

import java.util.Stack;

public class test09 {
    //用两个栈实现一个队列
    //队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
    //分别完成在队尾插入整数，在队头删除整数的功能
    //(若队列中没有元素，deleteHead 操作返回 -1 )
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    public test09() {

    }
    public void appendTail(int value) {
        //入队列的时候，需要先把 B 中的元素都倒腾到 A 中，再往 A 中插入新元素
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(value);
    }
    public int deleteHead() {
        if (A.isEmpty() && B.isEmpty()) {
            return -1;
        }
        //先把 A 的所有元素都倒腾到 B 中，然后再通过 B 进行 pop
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        //删除 B 中的元素
        return B.pop();
    }
}
