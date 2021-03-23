package Test0321;

import java.util.Arrays;

public class MySort {
    public static void insertSort(int[] arr) {
        // 这个循环就是在控制代码进行 N 次插入过程
        for (int bound = 1; bound < arr.length; bound++) {
            // 循环内部要实现插入一次的过程
            // 需要找到待排序区间的第一个元素, 放在哪里合适, 并且进行搬运赋值
            // 已排序区间: [0, bound)
            // 待排序区间: [bound, length)
            // 此处的 v 就是待排序区间的第一个元素, 也就是要被插入的元素
            int v = arr[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (arr[cur] > v) {
                    // 如果 cur 位置的元素比待插入元素大
                    // 说明 v 要插入到 arr[cur] 的前面.
                    // 就需要把 arr[cur] 给往后搬运
                    arr[cur + 1] = arr[cur];
                } else {
                    // 此时就相当于找到了要放置 v 的位置
                    break;
                }
            }
            arr[cur + 1] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
