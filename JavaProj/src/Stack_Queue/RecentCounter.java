package Stack_Queue;

import java.util.LinkedList;

//写一个 RecentCounter 类来计算特定时间范围内最近的请求
//请你实现 RecentCounter 类：
//RecentCounter() 初始化计数器，请求数为 0
//int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间
//并返回过去 3000 毫秒内发生的所有请求数（包括新请求）
//确切地说，返回在 [t-3000, t] 内发生的请求数
//保证每次对 ping 的调用都使用比之前更大的 t 值

class RecentCounter {
    LinkedList<Integer> pingList;

    public RecentCounter() {
        pingList = new LinkedList<Integer>();
    }

    public int ping(int t) {
        pingList.add(t);
        while (t - 3000 > pingList.peek()) {
            pingList.poll();
        }
        return pingList.size();
    }
}
/*
当 t = 1， 时间范围就为 (0~1),  那么符合此条件的ping声时间包括 [1毫秒] 所以结果就是 1
当 t = 100， 时间范围就为 (0~100),  那么符合此条件的ping声时间包括 [1毫秒，100毫秒] 所以结果就是 2
当 t = 3001， 时间范围就为 (1~3001),  那么符合此条件的ping声时间包括 [1毫秒，100毫秒，3001毫秒] 所以结果就是 3
当 t = 3002， 时间范围就为 (2~3002),  那么符合此条件的ping声时间包括 [100毫秒，3001毫秒，3002毫秒] 所以结果就是 3
*/
