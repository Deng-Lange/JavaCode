package Offer;

public class test44 {
    //数字以0123456789101112131415…的格式序列化到一个字符序列中。
    //在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
    //请写一个函数，求任意第n位对应的数字。
    /*
    解题思路：
    1、将 101112⋯ 中的每一位称为数位，记为 n；
    2、将 10,11,12,⋯ 称为数字，记为 num；
    3、数字 10 是一个两位数，称此数字的位数为 2，记为 digit；
    4、每 digit 位数的起始数字（即：1,10,100,⋯），记为 start。
    digit=digit+1；start=start*10；各digit下的数位数量 count=9*start*digit
    根据以上分析，可将求解分为三步：
    1、确定 n 所在数字的位数，记为 digit；
    所求数位在某个 digit 位数中；所求数位从数字 start 开始的第 n 个数位
    2、确定 n 所在的数字，记为 num；
    所求数位在数字 num=start+(n-1)/digit 中
    3、确定 n 是 num 中的哪一数位，并返回结果。
    所求数位 res 在 num 的第 (n-1)%2 位
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
