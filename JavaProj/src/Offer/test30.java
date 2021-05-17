package Offer;

import java.util.Stack;

public class test30 {
    // 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中
    // 调用 min、push 及 pop 的时间复杂度都是 O(1)
    //push(x) —— 将元素 x 推入栈中
    //pop() —— 删除栈顶的元素
    //top() —— 获取栈顶元素
    //getMin() —— 检索栈中的最小元素

    // 创建两个栈
    Stack<Integer> A = new Stack<>();
    // B 里头存的就是当前 A 的最小值
    Stack<Integer> B = new Stack<>();

    /** initialize your data structure here. */
    public test30() {

    }

    public void push(int x) {
        // 先把 x 插入 A 中.
        A.push(x);
        // 比较 x 和 B 的栈顶，看谁小，谁小就插入谁
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        int min = B.peek();
        if (x < min) {
            min = x;
        }
        // 如果 x>min，就把 min 再插入到 B 中一遍
        B.push(min);
    }

    public void pop() {
        if (A.isEmpty()) {
            return;
        }
        // A 删了栈顶元素，B 也要删栈顶元素
        A.pop();
        B.pop();
    }

    public int top() {
        if (A.isEmpty()) {
            return 0;
        }
        return A.peek();
    }

    public int min() {
        if (B.isEmpty()) {
            return 0;
        }
        return B.peek();
    }
}
