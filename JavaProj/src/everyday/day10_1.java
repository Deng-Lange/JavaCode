package everyday;

import java.util.Scanner;

public class day10_1 {
    //给你一个数 N，你想让其变为一个 Fibonacci 数，
    //每一步你可以把当前数字 X 变为 X-1 或 X+1，
    //现在给你一个数 N，求最少需要多少步可以变为 Fibonacci 数
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int i=0;
        for(;i<n;i++){
            if(fib(i)>=n){
                break;
            }
        }
        int p=Math.abs(fib(i)-n);
        int q=Math.abs(fib(i-1)-n);
        if(p>q){
            System.out.println(q);
        }else{
            System.out.println(p);
        }

//        Scanner scanner = new Scanner(System.in);
//        int n = 0;
//        int a = 0,b = 1,c = 1;
//        if (scanner.hasNextInt()) {
//            n = scanner.nextInt();
//        }
//        while (c < n) {
//            a = b;
//            b = c;
//            c = a + b;
//        }
//        int dis1 = n - b;
//        int dis2 = c - n;
//        System.out.println(dis1<dis2?dis1:dis2);
    }
    private static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
