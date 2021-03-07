package Homework;

import java.util.Arrays;

public class Test_day6 {
    //给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    public static int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    //仅反转字母
    //给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
    public static String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
//        int[] arr={0,4,3,6,2};
//        int[] arry=sortedSquares(arr);
//        for(int i=0;i<arry.length;i++){
//            System.out.print(arry[i]+" ");
//        }

        System.out.println(reverseOnlyLetters("ab-cd"));
    }
}
