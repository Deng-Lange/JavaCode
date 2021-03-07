package Homework;

public class Test_day2 {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
//        int arr[] = {1,2,3,2,5,2};
//        int k = 2;
//        int len = removeElement(arr,k);
//        for(int i=0;i<len;i++){
//            System.out.print(arr[i]+" ");
//        }

        int arr[] = {1,3,5,6};
        int k = 4;
        int len = searchInsert(arr,k);
        System.out.println(len);
    }
}
