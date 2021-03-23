package Test0321;

import java.util.Comparator;
import java.util.PriorityQueue;

class BoyFriend{
    public String name;
    public int money; // 资产
    public int face;  // 颜值

    public BoyFriend(String name, int money, int face) {
        this.name = name;
        this.money = money;
        this.face = face;
    }
}

class BoyFriendComparator implements Comparator<BoyFriend> {
    @Override
    public int compare(BoyFriend o1, BoyFriend o2) {
        return o2.money - o1.money;
    }
}

public class Test {
    public static void main(String[] args) {
        PriorityQueue<BoyFriend> queue = new PriorityQueue<>(new BoyFriendComparator());
        queue.offer(new BoyFriend("马云", 10000, 5));
        queue.offer(new BoyFriend("蔡徐坤", 500, 70));
        queue.offer(new BoyFriend("汤老湿", 10, 75));
        queue.offer(new BoyFriend("路人甲", 5, 100));

        while (!queue.isEmpty()) {
            BoyFriend boy = queue.poll();
            System.out.println(boy.name);
        }
    }
}
