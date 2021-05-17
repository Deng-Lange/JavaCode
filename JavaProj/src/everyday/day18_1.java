package everyday;

import java.util.Scanner;

public class day18_1 {
    //有一只兔子，从出生后第三个月起每个月都生一只兔子，
    //小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
    //每个月的兔子个数是 Fibonacci 数列
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            System.out.println(getTotalCount(m));
        }
    }
    /**
     * 统计出兔子总数
     * @param monthCount  第几个月
     * @return 兔子总数
     */
    public static int getTotalCount(int monthCount) {
        int first=1;
        int second=1;
        int num=0;
        for(int i=3;i<=monthCount;i++){
            num=first+second;
            first=second;
            second=num;
        }
        return num;
    }
}
