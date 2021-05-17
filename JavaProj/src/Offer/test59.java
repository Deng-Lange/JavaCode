package Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class test59 {
    //题目一：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
    /*
    窗口对应的数据结构为双端队列，本题使用单调队列即可解决以上问题。
    遍历数组时，每轮保证单调队列 deque：
    deque 内仅包含窗口内的元素 ⇒ 每轮窗口滑动移除了元素 nums[i−1]，需将 deque 内的对应元素一起删除。
    deque 内的元素非严格递减 ⇒ 每轮窗口滑动添加了元素 nums[j+1]，需将 deque 内所有 <nums[j+1] 的元素删除。
    算法流程：
    1、初始化：双端队列 deque，结果列表 res，数组长度 n；
    2、滑动窗口：左边界范围 i∈[1−k,n−k]，右边界范围 j∈[0,n−1]；
        ①若 i>0 且队首元素 deque[0]==被删除元素 nums[i−1]：则队首元素出队；
        ②删除 deque 内所有 <nums[j] 的元素，以保持 deque 递减；
        ③将 nums[j] 添加至 deque 尾部；
        ④若已形成窗口（即 i≥0 ）：将窗口最大值（即队首元素 deque[0] ）添加至列表 res；
    3、返回值：返回结果列表 res；
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 删除 deque 内所有 <nums[j] 的元素，保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            // 将 nums[j] 添加至 deque 尾部
            deque.addLast(nums[j]);
            // 记录窗口最大值 (即队首元素 deque[0])
            if(i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
    //题目二：请定义一个队列并实现函数 max_value 得到队列里的最大值，
    //要求函数 max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
    //若队列为空，pop_front 和 max_value 需要返回 -1
    /*
    函数设计：
    1、初始化队列 queue，双向队列 deque；
    2、最大值 max_value()：
        当双向队列 deque 为空，则返回 -1；
        否则，返回 deque 首元素；
    3、入队 push_back()：
        将元素 value 入队 queue；
        将双向队列中队尾所有小于 value 的元素弹出（以保持 deque 非单调递减），
        并将元素 value 入队 deque；
    4、出队 pop_front()：
        若队列 queue 为空，则直接返回 -1；
        否则，将 queue 首元素出队；
        若 deque 首元素和 queue 首元素相等，则将 deque 首元素出队（以保持两队列元素一致）；
    设计双向队列为单调不增的原因：若队列 queue 中存在两个值相同的最大元素，
    此时 queue 和 deque 同时弹出一个最大元素，而 queue 中还有一个此最大元素；
    即采用单调递减将导致两队列中的元素不一致。
     */
    //初始化队列 queue，双向队列 deque
    Queue<Integer> queue;
    Deque<Integer> deque;
    public void MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    public int max_value() {
        //当双向队列 deque 为空，则返回 -1；否则，返回 deque 首元素；
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    public void push_back(int value) {
        //将元素 value 入队列 queue
        queue.offer(value);
        //将双向队列中队尾所有小于 value 的元素弹出
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        //并将元素 value 入双向队列 deque
        deque.offerLast(value);
    }
    public int pop_front() {
        //若队列 queue 为空，则直接返回 -1
        if(queue.isEmpty()) {
            return -1;
        }
        //若 deque 首元素和 queue 首元素相等，则将 deque 首元素出队
        if(queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        //将 queue 首元素出队并返回
        return queue.poll();
    }
}
