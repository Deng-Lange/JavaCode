package Offer;

public class test39 {
    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
    /*
    方法一：摩尔投票法
    设输入数组 nums 的众数为 x，数组长度为 n
    推论一：若记众数的票数为 +1，非众数的票数为 −1，则一定有所有数字的票数和 >0
    推论二：若数组的前 a 个数字的票数和 =0，则数组剩余 (n−a) 个数字的票数和一定仍 >0，
           即后 (n−a) 个数字的众数仍为 x

    根据以上推论，记数组首个元素为 n_1，众数为 x，遍历并统计票数。
    当发生票数和 =0 时，剩余数组的众数一定不变，这是由于：
    当 n_1=x：抵消的所有数字，有一半是众数 x；
    当 n_1!=x：抵消的所有数字，众数 x 的数量为一半或 0 个。
    利用此特性，每轮假设发生票数和 =0 都可以缩小剩余数组区间
    当遍历完成时，最后一轮假设的数字即为众数

    算法流程:
    1、初始化：票数统计 votes = 0 ，众数 x
    2、循环：遍历数组 nums 中的每个数字 num ；
       当票数 votes 等于 0，则假设当前数字 num 是众数；
       当 num = x 时，票数 votes 自增 1；当 num != x 时，票数 votes 自减 1
    3、返回值：返回 x 即可
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums){
            if(num == x) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }
}
