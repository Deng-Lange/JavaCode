package Stack_Queue;

import java.util.Stack;

//用栈实现队列
//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
//实现 MyQueue 类：
//void push(int x) 将元素 x 推到队列的末尾
//int pop() 从队列的开头移除并返回元素
//int peek() 返回队列开头的元素
//boolean empty() 如果队列为空，返回 true ；否则，返回 false

public class MyQueue {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    public void push(int x) {
        // 入队列的时候, 需要先把 B 中的元素都倒腾到 A 中, 再往 A 中插入新元素
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(x);
    }

    public int pop() {
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        // 先把 A 的所有元素都倒腾到 B 中, 然后再通过 B 进行 pop
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 删除 B 中的元素
        return B.pop();
    }

    public int peek() {
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 删除 B 中的元素
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

    public static void main(String[] args) {
        // 尝试在本地重现刚才的问题.
        // 按照人家给的用例, 一步一步操作下来, 看看是不是会有一样的现象.
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int ret = myQueue.peek();
        System.out.println("ret = " + ret);
        ret = myQueue.pop();
        System.out.println("ret = " + ret);
        boolean isEmpty = myQueue.empty();
        System.out.println(isEmpty);
    }
}
