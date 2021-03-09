package Test0308;

// 使用数组来实现环形队列
public class MyQueue2 {
    private int[] data = new int[100];
    // 队列有效区间 [head, tail)
    private int head = 0;
    private int tail = 0;
    private int size = 0;//记录元素个数，区分空队列和满队列

    // 核心操作
    // 1. 入队列
    public boolean offer(int val) {
        if (size == data.length) {
            // 队列满了. 此处也可以实现扩容逻辑.
            return false;
        }
        // 把新元素放到 tail 对应的下标上.
        data[tail] = val;
        // 自增 tail
        tail++;
        // 一旦 tail 到达了数组的末尾, 就需要让 tail 从头开始
        if (tail == data.length) {
            tail = 0;
        }
        // 更新 size 的值.
        size++;
        return true;
    }

    // 2. 出队列
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = data[head];
        // 更新 head 的位置
        head++;
        // 一旦 head 到达了数组的末尾, 就需要让 head 从头开始
        if (head == data.length) {
            head = 0;
        }
        // 更新 size 的值.
        size--;
        return ret;
    }

    // 3. 取队首元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }
}
