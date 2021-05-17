package Offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class test40 {
    //输入整数数组 arr，找出其中最小的 k 个数。
    //例如，输入 4、5、1、6、2、7、3、8 这 8 个数字，则最小的 4 个数字是1、2、3、4。

    //方法一：堆
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆
        // 添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                // 删除堆顶最大元素
                heap.poll();
            }
        }
        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }

    //方法二：快速选择算法（快速排序变形）
    /*
    一、解题思路：
    快速排序中有一步很重要的操作是 partition（划分），
    从数组中随机选取一个枢纽元素 v，然后原地移动数组中的元素，
    使得比 v 小的元素在 v 的左边，比 v 大的元素在 v 的右边。
    快速选择（quick select）算法的不同之处在于，接下来只需要递归地选择一侧的数组。
    快速选择算法想当于一个不完全的快速排序，因为我们只需要知道最小的 k 个数是哪些，
    并不需要知道它们的顺序。
    二、算法流程：
    getLeastNumbers2() 函数：
    1、若 k 大于数组长度，则直接返回整个数组；
    2、执行并返回 quick_sort() 即可；
    quick_sort() 函数：
    注意，此时 quick_sort() 的功能不是排序整个数组，而是搜索并返回最小的 k 个数。
    1、哨兵划分：
       划分完毕后，基准数为 arr[i]，左/右子数组区间分别为 [l,i−1]，[i+1,r]；
    2、递归或返回：
       若 k<i，代表第 k+1 小的数字在左子数组中，则递归左子数组；
       若 k>i，代表第 k+1 小的数字在右子数组中，则递归右子数组；
       若 k=i，代表此时 arr[k] 即为第 k+1 小的数字，则直接返回数组前 k 个数字即可；
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1);
    }
    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        /*
        哨兵划分操作：以 arr[l]为基准数，
        从右向左查找首个小于基准数的元素 arr[j]；
        从左向右查找首个大于基准数的元素 arr[i]；
        交换 arr[i]和 arr[j]；
        当 i==j 时，交换 arr[l]和 arr[i]；
        此操作完成后，基准数为 arr[i]，
        并且左子数组中所有数字小于基准数，右子数组中所有数字大于基准数。
         */
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        //对左子数组或者右子数组开启递归
        if (i > k) {
            return quickSort(arr, k, l, i - 1);
        }
        if (i < k) {
            return quickSort(arr, k, i + 1, r);
        }
        //第一个参数为原有数组对象，第二个参数为要截取的长度
        return Arrays.copyOf(arr, k);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
