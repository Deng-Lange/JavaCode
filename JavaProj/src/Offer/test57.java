package Offer;

import java.util.ArrayList;
import java.util.List;

public class test57 {
    //题目一：
    //输入一个递增排序的数组和一个数字 s，在数组中查找两个数，使得它们的和正好是 s。
    //如果有多对数字的和等于 s，则输出任意一对即可。
    /*
    算法流程：
    初始化：双指针 i，j 分别指向数组 nums 的左右两端（俗称对撞双指针）
    循环搜索：当双指针相遇时跳出；
    计算和 s=nums[i]+nums[j]；
    若 s>target，则指针 j 向左移动，即执行 j=j−1；
    若 s<target，则指针 i 向右移动，即执行 i=i+1；
    若 s=target，立即返回数组 [nums[i],nums[j]]；
    返回空数组，代表无和为 target 的数字组合。
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) {
                i++;
            } else if(s > target) {
                j--;
            } else {
                return new int[] { nums[i], nums[j] };
            }
        }
        return new int[0];
    }
    //题目二：
    //输入一个正整数 target，输出所有和为 target 的连续正整数序列（至少含有两个数）。
    //序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
    /*
    方法一：求和公式
    设连续正整数序列的左边界 i 和右边界 j，则此序列的元素和 target 等于
    元素平均值(i+j)/2 乘以元素数量(j−i+1)，即：target=((i+j)×(j−i+1))/2。
    观察发现，当确定元素和 target 与左边界 i 时，可通过解一元二次方程，
    直接计算出右边界 j=(−1+√(1+4×(2×target+i^2−i)))/2
    因此，通过从小到大遍历左边界 i 来计算以 i 为起始数字的连续正整数序列。
    每轮中，由以上公式计算得到右边界 j，当 j 满足以下两个条件时记录结果：
    1、j 为整数：符合题目要求「连续正整数序列」；
    2、i<j：满足题目要求「至少含有两个数」；
     */
    public int[][] findContinuousSequence1(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if(i < j && j == (int)j) {
                int[] ans = new int[(int)j - i + 1];
                for(int k = i; k <= (int)j; k++){
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }
    /*
    方法二：滑动窗口（双指针）
    设连续正整数序列的左边界 i 和右边界 j，则可构建滑动窗口从左向右滑动。
    循环中，每轮判断滑动窗口内元素和与目标值 target 的大小关系，
    若相等则记录结果，若大于 target 则移动左边界 i（以减小窗口内的元素和），
    若小于 target 则移动右边界 j（以增大窗口内的元素和）。
    算法流程：
    初始化：左边界 i=1，右边界 j=2，元素和 s=3，结果列表 res；
    循环：当 i≥j 时跳出；
        当 s>target 时：向右移动左边界 i=i+1，并更新元素和 s；
        当 s<target 时：向右移动右边界 j=j+1，并更新元素和 s；
        当 s=target 时：记录连续整数序列，并向右移动左边界 i=i+1；
    返回值：返回结果列表 res；
     */
    public int[][] findContinuousSequence2(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
