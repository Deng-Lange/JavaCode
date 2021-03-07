package Homework;

public class Test_day8 {
    //给定一个由整数组成的非空数组所表示的非负整数,在该数的基础上加一
    //最高位数字存放在数组的首位,数组中每个元素只存储单个数字
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    //给你一个非空数组，返回此数组中第三大的数 。如果不存在，则返回数组中最大的数。
    public static int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1,max3 = max1;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i] > max3 && nums[i] != max2 && nums[i] != max1){
                if(nums[i] > max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                }else if(nums[i] > max2){
                    max3 = max2;
                    max2 = nums[i];
                }else
                    max3 = nums[i];
            }
            min = Math.min(min,nums[i]);
        }

        //没有第二大，就返回第一大。
        if(max2 == Integer.MIN_VALUE)
            return max1;

        //不存在第三大的数，可能是存在多个相同的第二大的数。
        //min的作用是用于排除第三大就是Integer.MIN_VALUE的情况
        if(max3 == Integer.MIN_VALUE && min != Integer.MIN_VALUE)
            return max1;

        return max3; //存在第三大
    }

    public static void main(String[] args) {
//        int[] arr={4,3,6,8};
//        int[] arry=plusOne(arr);
//        for(int i=0;i<arry.length;i++) {
//            System.out.print(arry[i] + " ");
//        }
        int[] arr={2,3,2,1};
        System.out.println(thirdMax(arr));
    }
}
