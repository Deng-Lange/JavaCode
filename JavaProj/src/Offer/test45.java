package Offer;

public class test45 {
    //输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    /*
    解题思路：
    此题求拼接起来的最小数字，本质上是一个排序问题。
    设数组 nums 中任意两数字的字符串为 x 和 y,则规定排序判断规则为：
    若拼接字符串 x+y>y+x，则 x “大于” y；反之，若 x+y<y+x，则 x “小于” y；
    x “小于” y 代表：排序完成后，数组中 x 应在 y 左边；“大于” 则反之。
    算法流程：
    1、初始化：字符串列表 strs，保存各数字的字符串格式；
    2、列表排序：应用以上 “排序判断规则”，对 strs 执行排序；
    3、返回值：拼接 strs 中的所有字符串，并返回。
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s);
        }
        return res.toString();
    }
    public void quickSort(String[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int low = left;
        int high = right;
        int i = low+1;
        String pivot = arr[low];
        while (i <= high) {
            //比较大小
            if ((pivot+arr[i]).compareTo(arr[i]+pivot) > 0 ) {
                swap(arr,i++,low++);
            } else if ((pivot+arr[i]).compareTo(arr[i]+pivot) < 0) {
                swap(arr,i,high--);
            } else {
                i++;
            }
        }
        quickSort(arr,left,low-1);
        quickSort(arr,high+1,right);

    }
    public void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
