package Homework;

import java.util.HashMap;
import java.util.Map;

public class Test_day9 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr={0,4,3,6,2};
        int[] arry=twoSum(arr,9);
        for(int i=0;i<arry.length;i++) {
            System.out.print(arry[i] + " ");
        }
    }
}
