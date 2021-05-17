package everyday;

import java.util.Scanner;

public class day7_2 {
    //求最小公倍数
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = gdc(a, b);
        int n = a * b / m;
        System.out.print(n);
    }
    //求最大公约数
    public static int gdc(int a, int b){
        if(a < b){
            int t = a;
            a = b;
            b = t;
        }
        while(b != 0){
            if(a == b){
                return a;
            }else{
                int k = a % b;
                a = b;
                b = k;
            }
        }
        return a;
    }
}
