package Test0308;

//栈的核心操作：
//入栈：把元素放到栈里
//出栈：把最后进来的元素删掉
//取栈顶元素：获取到最后一个进来的元素的结果

// 使用顺序表来实现栈（后进先出）
public class MyStack {
    private int[] data = new int[100];
    private int size = 0;//有效元素个数

    // 基本操作
    // 1. 入栈--尾插
    public void push(int val) {
        if (size >= data.length) {
            // 满了，在这里也可以进行扩容.
            return;
        }
        data[size] = val;
        size++;
    }

    // 2. 出栈，返回值就是被出栈了的那个元素--尾删
    public Integer pop() {
        if (size == 0) {
            //空栈
            return null;
        }
        // 栈顶元素就是最后一个元素
        int ret = data[size - 1];
        size--;
        return ret;
    }

    // 3. 取栈顶元素--根据下标获取元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }
}
