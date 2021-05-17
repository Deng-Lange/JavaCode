package Offer;

public class test53 {
    //题一：统计一个数字在排序数组中出现的次数。
    /*
    解题思路：
        排序数组中的搜索问题，首先想到二分法解决。
        排序数组 nums 中的所有数字 target 形成一个窗口，记窗口的左/右边界索引分别为
        left 和 right，分别对应窗口左边/右边的首个元素。
        本题要求统计数字 target 的出现次数，可转化为：
        使用二分法分别找到左边界 left 和右边界 right，
        易得数字 target 的数量为 right−left−1。
    算法解析：
    一、初始化：左边界 i=0，右边界 j=len(nums)−1。
    二、循环二分：当闭区间 [i,j] 无元素时跳出；
        计算中点 m=(i+j)/2（向下取整）；
        若 nums[m]<target，则 target 在闭区间 [m+1,j] 中，因此执行 i=m+1；
        若 nums[m]>target，则 target 在闭区间 [i,m−1] 中，因此执行 j=m−1；
        若 nums[m]=target，则右边界 right 在闭区间 [m+1,j] 中；左边界 left 在闭区间 [i,m−1] 中。
        因此分为以下两种情况：
        若查找右边界 right，则执行 i=m+1；（跳出时 i 指向右边界）
        若查找左边界 left，则执行 j=m−1；（跳出时 j 指向左边界）
    三、返回值：应用两次二分，分别查找 right 和 left，最终返回 right−left−1 即可。
    优化：
        可将二分查找右边界 right 的代码封装至函数 helper()。
        由于数组 nums 中元素都为整数，因此可以分别二分查找 target
        和 target−1 的右边界，将两结果相减并返回即可。
     */
    public int search1(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) {
            return 0;
        }
        // 搜索左边界 left
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }
    //优化
    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) {
                i = m + 1;
            }else {
                j = m - 1;
            }
        }
        return i;
    }
    //题二：一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，
    //并且每个数字都在范围 0～n-1 之内。在范围 0～n-1 内的 n 个数字中
    //有且只有一个数字不在该数组中，请找出这个数字。
    /*
    数组可以按照以下规则划分为两部分。
        左子数组：nums[i]=i；
        右子数组：nums[i]!=i；
        缺失的数字等于 “右子数组的首位元素” 对应的索引；
        因此考虑使用二分法查找 “右子数组的首位元素”。
    算法解析：
    一、初始化：左边界 i=0，右边界 j=len(nums)−1；代表闭区间 [i,j]。
    二、循环二分：当 i≤j 时循环（即当闭区间 [i,j] 为空时跳出）；
        计算中点 m=(i+j)//2 ，其中 "//" 为向下取整除法；
        若 nums[m]=m，则 “右子数组的首位元素” 一定在闭区间 [m+1,j] 中，因此执行 i=m+1；
        若 nums[m]!=m，则 “左子数组的末位元素” 一定在闭区间 [i,m−1] 中，因此执行 j=m−1；
    三、返回值：跳出时，变量 i 和 j 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素”。
        因此返回 i 即可。
     */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
