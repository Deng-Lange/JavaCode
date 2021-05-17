package everyday;

import java.util.Scanner;

public class day4_2 {
    //给定一个十进制数 M，以及需要转换的进制数 N，将十进制数 M 转换为 N 进制数
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        StringBuilder s=new StringBuilder();
        String table="0123456789ABCDEF";
        boolean flag=false;
        if(m<0){
            m=-m;
            flag=true;
        }
        while(m!=0){
            s.append(table.charAt(m%n));
            m=m/n;
        }
        //flag为 true，说明是负数，就在末尾拼接一个负号
        //3 2 1
        if(flag){
            s.append("-");
        }
        //3 2 1 -
        s.reverse();
        System.out.println(s);
    }
}
