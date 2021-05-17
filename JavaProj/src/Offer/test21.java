package Offer;

public class test21 {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
    /*
    定义双指针 i，j 分列数组左右两端，循环执行：
    指针 i 从左向右寻找偶数；
    指针 j 从右向左寻找奇数；
    将偶数 nums[i] 和奇数 nums[j] 交换
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            while(left < right && nums[left] % 2 == 1)
                left++;
            while(left < right && nums[right] % 2 == 0)
                right--;
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
