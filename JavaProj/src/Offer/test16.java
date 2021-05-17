package Offer;

public class test16 {
    //实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）
    //不得使用库函数，同时不需要考虑大数问题
    /*
    算法流程：
    1、当 x=0 时：直接返回 0 （避免后续 x=1/x 操作报错）
    2、初始化 res=1；
    3、当 n<=0 时：把问题转化至 n>=0 的范围内，即执行 x=1/x ，n=−n；
    4、循环计算：当 n=0 时跳出；
                当 n&1=1 时：将当前 x 乘入 res （即 res∗=x）；
                执行 x=x^2（即 x*=x）；
                执行 n 右移一位（即 n>>=1）。
    5、返回 res
     */
    public double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if(b <= 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
