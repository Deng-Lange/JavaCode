package Homework;

public class Test_day5 {
    //给定一个整数数组，判断是否存在重复元素。
    //如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
    //在对数字从小到大排序之后，数组的重复元素一定出现在相邻位置中。
    //因此，我们可以扫描已排序的数组，每次判断相邻的两个元素是否相等，如果相等则说明存在重复的元素。
    public static boolean containsDuplicate(int[] nums) {
        int[] new_nums = BubbleSort(nums);
        for(int i = 0; i < new_nums.length - 1; i++){
            if(new_nums[i] == new_nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static int[] BubbleSort(int[] array)
    {
        int a = array.length;
        for(int i = 0; i < a; i++) {
            for (int j = 0; j < a - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    //长按键入
    //思路与算法
    //根据题意能够分析得到：字符串 typed 的每个字符，有且只有两种「用途」：
    //作为 name 的一部分，此时会「匹配」 name 中的一个字符
    //作为长按键入的一部分，此时它应当与前一个字符相同。
    //如果 typed 中存在一个字符，它两个条件均不满足，则应当直接返回 false；否则，当 typed 扫描完毕后，我们再检查 name 的每个字符是否都被「匹配」了。
    //实现上，我们使用两个下标 i,j 追踪 name 和 typed 的位置。
    //当 name[i]=typed[j] 时，说明两个字符串存在一对匹配的字符，此时将 i,j 都加 1。
    //否则，如果 typed[j]=typed[j−1]，说明存在一次长按键入，此时只将 j 加 1。
    //最后，如果 i=name.length，说明 name 的每个字符都被「匹配」了。
    public static boolean isLongPressedName(String name, String typed) {
        int len_n = name.length();
        int len_t = typed.length();
        if(len_n>len_t){
            return false;
        }
        int i=0;
        int j=0;
        while(i<len_n&&j<len_t){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        return i ==len_n;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4};
//        System.out.print(containsDuplicate(nums));
        System.out.println(isLongPressedName("deng","deng"));
    }
}
