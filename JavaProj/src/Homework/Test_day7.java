package Homework;

import java.util.Arrays;

public class Test_day7 {
    //给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
    public static int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }
    //给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
    //数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
    //如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
    public static int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr={0,4,3,6,2};
//        int[] arry=sortArrayByParity(arr);
//        for(int i=0;i<arry.length;i++) {
//            System.out.print(arry[i] + " ");
//        }
        int[] arr={1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
    }
}
