package everyday;

import java.util.Scanner;

public class day9_2 {
    //输入一个整数，将这个整数以字符串的形式逆序输出
    //不考虑负数的情况，若数字含有 0，则逆序形式也含有 0
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        while(num!=0){
            int a=num%10;
            System.out.print(a);
            num=num/10;
        }
    }
}
