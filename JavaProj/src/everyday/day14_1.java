package everyday;

import java.util.Scanner;

public class day14_1 {
    //根据输入的日期，计算是这一年的第几天。
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int y=sc.nextInt();
            int m=sc.nextInt();
            int d=sc.nextInt();
            int sum=0;
            //用一个数组存放每月的累积天数
            //二月按 28 天算，如果是闰月再加 1
            int[] day={31,59, 90, 120, 151, 181, 212,243, 273, 304, 334, 365};
            if(m>=2){
                sum+=day[m-2];
            }
            sum+=d;
            //判断二月是否是闰月
            if(y%400==0||y%4==0&&y%100!=0){
                sum+=1;
            }
            System.out.println(sum);
        }
    }
}
