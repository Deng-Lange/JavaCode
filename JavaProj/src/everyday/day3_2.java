package everyday;

import java.util.Arrays;

//数组中出现次数超过一半的数字
public class day3_2 {
    //方法一：抵消法
    public int MoreThanHalfNum_Solution1(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int result=nums[0];
        int times=1;
        for(int i=0;i<nums.length;i++){
            if(times!=0){
                if(nums[i]==result){
                    ++times;
                }else{
                    --times;
                }
            }else{
                result=nums[i];
                times=1;
            }
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==result){
                ++count;
            }
        }
        return (count>nums.length/2)?result:0;
    }

    //方法二：数组排序法
    public int MoreThanHalfNum_Solution2(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int len=nums.length;
        int midNum=nums[len/2];
        int count=0;
        for(int i=0;i<len;i++){
            if(nums[i]==midNum){
                count++;
            }
        }
        if(count>len/2){
            return midNum;
        }
        return 0;
    }
}
