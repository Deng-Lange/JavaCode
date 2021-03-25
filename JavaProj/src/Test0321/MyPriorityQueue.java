package Test0321;

public class MyPriorityQueue {
    // array 表示用来存储堆的数组.
    // size 表示数组上有效元素的个数(有效元素不一定和 array.length 一样)
    // index 表示从哪个位置开始进行向下调整
    // 以大堆为例
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;//左子树下标
        // 循环条件的含义:
        // 如果 child < size, 就意味着 child 是存在的.
        // 如果 child >= size, 就说明 parent 已经是叶子节点.
        while (child < size) {
            // 第一次比较, 找出左右子树的最大值
            if (child + 1 < size && array[child + 1] > array[child]) {
                // 如果发现右子树存在, 且右子树比左子树大,
                // 就让 child 指向右子树
                child = child + 1;
            }
            // 这个条件结束后, child 指向左右子树中较大的那个
            // 第二次比较, 拿刚才的 child 位置的元素和 parent 进行比较
            // 看是否符合大堆的要求. 如果不符合就交换两个元素
            if (array[parent] < array[child]) {
                // 不符合大堆要求，交换
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                // 调整就完成了, 刚才 index 位置的节点已经被放到合适的位置了
                // 不需要继续调整了
                break;
            }
            // 更新循环变量
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //向上调整，以大堆为例
    public static void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        //如果 child 为 0，说明已经调整到最上面了
        while (child > 0) {
            // 比较父节点和子节点是否符合堆的要求
            if (array[parent] < array[child]) {
                // 如果不符合大堆的要求, 就交换这两个元素
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                // 只要发现现在的父子节点符合堆要求
                // 就认为现在这个堆已经调整完毕了
                break;
            }
            // 更新循环变量
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    // createHeap 方法, 看起来时间复杂度是 O(NlogN)
    // 实际上时间复杂度是 O(N)
    // 基于向下调整的建堆操作
    public static void createHeap(int[] array) {
        // 从后往前遍历数组，针对每个下标都进行向下调整
        // 最后一个元素的下标是 length - 1
        // 向下调整建堆是从最后一个非叶子节点开始往前循环
        // 最后一个非叶子节点正是最后一个节点的父节点
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    // 为了让后续的堆操作比较方便, 使用成员变量的方式来保存堆对应的数组
    private int[] data = new int[1000];
    private int size = 0;
    public MyPriorityQueue(int[] data, int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            this.data[i] = data[i];
        }
    }

    //往堆中插入元素
    public void offer(int val) {
        if (size >= data.length) {
            // 堆已经满了，插入失败
            return;
        }
        // 1. 先把新元素放到数组的末尾（尾插）
        data[size] = val;
        size++;
        // 2. 加入新的元素之后，可能就破坏了原有堆的结构
        //    就需要调整堆，让堆能够重新符合要求
        //    通过向上调整的方式，从新元素的位置进行向上调整
        //从最后一个元素开始进行调整
        shiftUp(data, size, size - 1);
    }

    //基于向上调整的方式建堆
    public void createHeap2(int[] array) {
        //循环遍历数组，把元素通过 offer 方法插入即可
        for(int x:array){
            offer(x);
        }
    }

    // 获取堆顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[0];
    }

    // 删除堆顶元素
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer result = data[0];
        // 先把 0 号元素和最后一个元素互换
        // 或者直接把最后一个元素给赋值到 0 号元素
        data[0] = data[size - 1];
        // 删除最后一个元素
        size--;
        // 从 0 号位置开始进行向下调整
        shiftDown(data, size, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4, 9, 5, 2, 7, 3, 6, 8};
        createHeap(array);

        MyPriorityQueue myPriorityQueue = new MyPriorityQueue(array, array.length);
        myPriorityQueue.offer(10);
        System.out.println(myPriorityQueue);
        Integer result = myPriorityQueue.poll();
        System.out.println(myPriorityQueue);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
/*
面试题：topk 问题

假设有一亿个数据，找出前 1000 个最大的数字
使用堆解决 topk 问题，有两种方案：
方案一、直接针对这一亿个数据的数组，进行建大堆
       接下来循环 1000 次，进行取堆顶元素/删除堆顶元素操作
       特点：得到的这前 1000 个数据是有序的
方案二、创建一个大小为 1000 的小堆，遍历这一亿个数据，依次往堆里插入
       如果堆没满，直接插入
       如果堆满了（小堆的堆顶元素就是这个堆里最小的元素），拿当前值和堆顶元素比较
       如果当前值小于堆顶元素，就 pass
       如果当前值大于堆顶元素，就删除堆顶元素，将当前值插入堆中
       特点：效率更高；得到的 1000 个数据不保证顺序

海量数据处理，内存存不下，怎么办
1、堆
2、哈希表

100 万亿个数据，内存存不下，找前 1000 个最大数据？（方案二）
将 100 万亿个数据存到磁盘上，内存中只存大小为 1000 的小堆，
每次从磁盘上读取一个数据，和堆顶元素比较并更新即可
 */
