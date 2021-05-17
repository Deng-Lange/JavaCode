package everyday;

import java.util.Scanner;

public class day12_2 {
    //任意一个偶数（大于2）都可以由 2 个素数组成，组成偶数的 2 个素数有很多种情况，
    //本题目要求输出组成指定偶数的两个素数差值最小的素数对。
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int half=n/2;
            for(int i=half;i>0;i--){
                if(isPrime(i)&&isPrime(n-i)){
                    System.out.println(i);
                    System.out.println(n-i);
                    break;
                }
            }
        }
    }
    //判断素数
    private static boolean isPrime(int num) {
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
