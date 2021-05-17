package Offer;

public class test46 {
    //给定一个数字，我们按照如下规则把它翻译为字符串：
    //0 翻译成 “a”，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
    //一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
    /*
    动态规划解析：
    记数字 num 第 i 位数字为 x_i，数字 num 的位数为 n；
    例如：num=12258 的 n=5，x_1=1。
    1、状态定义：设动态规划列表 dp，dp[i] 代表以 x_i 为结尾的数字的翻译方案数量。
    2、转移方程： 若 x_i 和 x_i−1 组成的两位数字可以被翻译，则 dp[i]=dp[i−1]+dp[i−2]；否则 dp[i]=dp[i−1]。
    可被翻译的两位数区间：当 x_i−1=0 时，组成的两位数是无法被翻译的（例如 00,01,02,⋯ ），因此区间为 [10,25]。
    dp[i]=dp[i−1]+dp[i−2]，10*x_i-1+x_i∈[10,25]
    dp[i]=dp[i−1]，10*x_i-1+x_i∈[0,10)∪(25,99]
    3、初始状态：dp[0]=dp[1]=1，即 “无数字” 和 “第 1 位数字” 的翻译方法数量均为 1；
    4、返回值：dp[n]，即此数字的翻译方案数量。
    方法一：字符串遍历：从左向右遍历
    方法二：数字求余：从右向左的遍历计算
     */
    //方法一：字符串遍历
    public int translateNum1(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
    //方法二：数字求余
    public int translateNum2(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
