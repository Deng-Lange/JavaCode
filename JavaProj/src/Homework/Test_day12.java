package Homework;

import java.util.Arrays;
import java.util.Stack;

public class Test_day12 {
    //给你一个整数数组 nums，你需要找出一个 连续子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    //请你找出符合题意的最短子数组，并输出它的长度。
    //排序法
    public static int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
    //根据逆波兰表示法，求表达式的值。
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if ("+".equals(cur)) {
                stack.push(stack.pop() + stack.pop());
            }else if ("-".equals(cur)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 - num1);
            }else if ("*".equals(cur)) {
                stack.push(stack.pop() * stack.pop());
            }else if ("/".equals(cur)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 / num1);
            }else {
                stack.push(Integer.valueOf(cur));
            }
        }
        return stack.pop();
    }
    //Stack.peek()与Stack.pop()﻿﻿
    //peek()：返回栈顶的值 ；不改变栈的值，查看栈顶的对象而不移除它。
    //pop()：返回栈顶的值 ；会把栈顶的值删除。

    public static void main(String[] args) {
//        int[] arr={2,3,8,6,9,4,10};
//        System.out.println(findUnsortedSubarray(arr));
        String[] str = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(str));
    }
}
