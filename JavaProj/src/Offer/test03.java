package Offer;

import java.util.HashSet;
import java.util.Set;

public class test03 {
    //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
    //数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次
    //请找出数组中任意一个重复的数字
    /*
    方法一：原地置换
    1、题目明确说明了数组长度为 n，范围为 n-1，也就是若无重复元素排序后下标 0123 对应的数字就应该是 0123；
    2、对数组排序，其实也就是让萝卜归位，1号坑要放 1号萝卜，2号坑要放 2号萝卜，排序过程中查找有无重复元素。
    (a)没有重复元素的情况：
     nums[i]     3  1  0  2   萝卜
         i       0  1  2  3   坑
    0号坑说我要的是 0号萝卜，不要 3号萝卜，所以会去和 3号坑的萝卜交换，换完是这样的：
     nums[i]     2  1  0  3   萝卜
         i       0  1  2  3   坑
    然而 0号坑还没找到自己的萝卜，它不要 2号萝卜，又去和 2号坑的萝卜交换，换完是这样的：
     nums[i]     0  1  2  3   萝卜
         i       0  1  2  3   坑
    这时候刚好就是一一对应的，交换过程也不会出现不同坑有相同编号的萝卜。要注意交换用的是while，也就是0号坑只有拿到0号萝卜，1号坑才能开始找自己的萝卜。
    (b)有重复元素的情况：
     nums[i]     1  2  3  2    萝卜
         i       0  1  2  3    坑
    0号坑不要 1号，先和 1号坑交换，交换完这样的：
     nums[i]     2  1  3  2    萝卜
         i       0  1  2  3    坑
    0号坑不要 2号萝卜，去和 2号坑交换，交换完这样的：
     nums[i]     3  1  2  2    萝卜
         i       0  1  2  3    坑
    0号坑不要 3号萝卜，去和 3号坑交换，交换完这样的：
     nums[i]     2  1  2  3    萝卜
         i       0  1  2  3    坑
    0号坑不要 2号萝卜，去和 2号坑交换，结果发现 2号坑也是 2号萝卜，那就不换了，同时也说明有重复元素出现。
     */
    public static int findRepeatNumber1(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
    /*
    方法二：遍历数组
    1、初始化集合为空集合，重复的数字 repeat = -1
    2、遍历数组中的每个元素：将该元素加入集合中，判断是否添加成功
       如果添加失败，说明该元素已经在集合中，因此该元素是重复元素，
       将该元素的值赋给 repeat，并结束遍历
    3、返回 repeat
     */
    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,2,3};
        System.out.println(findRepeatNumber1(nums));
    }
}
