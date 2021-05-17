package everyday;

import java.util.Scanner;

public class day9_1 {
    //输入一个正整数 n，求 n! 末尾有多少个 0
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret =0;
        for(int i=n;i>=5;i--){
            int tmp =i;
            while(tmp%5==0){
                ret++;
                tmp=tmp/5;
            }
        }
        System.out.println(ret);
    }
}
