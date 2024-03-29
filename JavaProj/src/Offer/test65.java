package Offer;

public class test65 {
    //写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    /*
    无进位和 n 与异或运算规律相同，进位 c 和与运算规律相同（并需左移一位）。
    因此，无进位和 n 与进位 c 的计算公式如下；
    n=a⊕b，非进位和：异或运算
    c=a&b<<1，进位：与运算+左移一位
    （和 s）=（非进位和 n）+（进位 c）。即可将 s=a+b 转化为：
    s=a+b ⇒ s=n+c
    循环求 n 和 c，直至进位 c=0；此时 s=n，返回 n 即可。
     */
    public int add(int a, int b) {
        //当进位为 0 时跳出
        while(b != 0) {
            //计算进位 c
            int c = (a & b) << 1;
            //计算无进位和 n，赋值给 a
            a = a ^ b;
            //将进位 c 赋值给 b
            b = c;
        }
        return a;
    }
}
