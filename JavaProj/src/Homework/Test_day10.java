package Homework;

public class Test_day10 {
    //字符串转换整数
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }
    //给定一个按照"升序"排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //如果数组中不存在目标值 target，返回 [-1, -1]。
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 小于一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            } else {
                // nums[mid] > target，下一轮搜索区间是 [left, mid - 1]
                right = mid - 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                // 下一轮搜索区间是 [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] == target){
                // 下一轮搜索区间是 [mid, right]
                left = mid;
            } else {
                // nums[mid] < target，下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        String str = "  -47283648494754";
//        int res = myAtoi(str);
//        System.out.println(res);
        int[] arr={0,2,2,4,6,8};
        int[] arry=searchRange(arr,2);
        for(int i=0;i<arry.length;i++) {
            System.out.print(arry[i] + " ");
        }
    }
}
