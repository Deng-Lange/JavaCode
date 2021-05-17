package Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test61 {
    //从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这 5 张牌是不是连续的。
    //2～10为数字本身，A为 1，J为 11，Q为 12，K为 13，而大、小王为 0，可以看成任意数字。
    //A不能视为 14。
    /*
    根据题意，此 5 张牌是顺子的充分条件如下：
    1、除大小王外，所有牌无重复 ；
    2、设此 5 张牌中最大的牌为 max，最小的牌为 min（大小王除外），则需满足：
       max−min<5
    因而，可将问题转化为：此 5 张牌是否满足以上两个条件？
    方法一： 集合 Set + 遍历
        1、遍历五张牌，遇到大小王（即 0 ）直接跳过。
        2、判别重复：利用 Set 实现遍历判重，Set 的查找方法的时间复杂度为 O(1)；
        3、获取最大/最小的牌：借助辅助变量 ma 和 mi，遍历统计即可。
    方法二：排序 + 遍历
        1、先对数组执行排序。
        2、判别重复：排序数组中的相同元素位置相邻，因此可通过遍历数组，
           判断 nums[i]=nums[i+1] 是否成立来判重。
        3、获取最大/最小的牌：排序后，数组末位元素 nums[4] 为最大牌；
           元素 nums[joker] 为最小牌，其中 joker 为大小王的数量。
     */
    public boolean isStraight1(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) {
                continue; //跳过大小王
            }
            max = Math.max(max, num); //最大牌
            min = Math.min(min, num); //最小牌
            if(repeat.contains(num)) {
                return false; //若有重复，提前返回 false
            }
            repeat.add(num); //添加此牌至 Set
        }
        return max - min < 5; //最大牌 - 最小牌 < 5，则可构成顺子
    }
    public boolean isStraight2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); //数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) {
                joker++; //统计大小王数量
            } else if(nums[i] == nums[i + 1]) {
                return false; //若有重复，提前返回 false
            }
        }
        return nums[4] - nums[joker] < 5; //最大牌 - 最小牌 < 5 则可构成顺子
    }
}
