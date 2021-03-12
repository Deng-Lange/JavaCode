package Stack_Queue;

import java.util.Stack;

//实现一个最小栈
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//push(x) —— 将元素 x 推入栈中。
//pop() —— 删除栈顶的元素。
//top() —— 获取栈顶元素。
//getMin() —— 检索栈中的最小元素。

class MinStack {
    // 创建两个栈.
    Stack<Integer> A = new Stack<>();
    // B 里头存的就是当前 A 的最小值.
    Stack<Integer> B = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        // 先把 x 插入 A 中.
        A.push(x);
        // 比较 x 和 B 的栈顶, 看谁小, 谁小就插入谁.
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        int min = B.peek();
        if (x < min) {
            min = x;
        }
        //如果 x>min ，就把 min 再插入到 B 中一遍
        B.push(min);
    }

    public void pop() {
        if (A.isEmpty()) {
            return;
        }
        //A 删了栈顶元素，B 也要删栈顶元素
        A.pop();
        B.pop();
    }

    public int top() {
        if (A.isEmpty()) {
            return 0;
        }
        return A.peek();
    }

    public int getMin() {
        if (B.isEmpty()) {
            return 0;
        }
        return B.peek();
    }
}
