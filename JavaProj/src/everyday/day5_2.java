package everyday;

import java.util.Scanner;

//连续子数组的最大和
public class day5_2 {
    /*
    动态规划解析：
    1、状态定义：设动态规划列表 dp，dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和。
       为何定义最大和 dp[i] 中必须包含元素 nums[i]：保证 dp[i] 递推到 dp[i+1] 的正确性；
       如果不包含 nums[i]，递推时则不满足题目的连续子数组要求。
    2、转移方程：若 dp[i−1]≤0，说明 dp[i−1] 对 dp[i] 产生负贡献，即 dp[i−1]+nums[i] 还不如 nums[i] 本身大。
       当 dp[i−1]>0 时：执行 dp[i]=dp[i−1]+nums[i]；
       当 dp[i−1]≤0 时：执行 dp[i]=nums[i]。
    3、初始状态：dp[0]=nums[0]，即以 nums[0] 结尾的连续子数组最大和为 nums[0]。
    4、返回值：返回 dp 列表中的最大值，代表全局最大值。
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    //方法二：
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] array=new int[size];
        for(int i=0;i<size;i++){
            array[i]=sc.nextInt();
        }
        int sum=array[0];
        int max=array[0];
        for(int i=1;i<size;i++){
            sum=Math.max(sum+array[i],array[i]);
            if(sum>=max){
                max=sum;
            }
        }
        System.out.println(max);
    }
}
