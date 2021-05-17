package everyday;

import java.util.Scanner;

public class day15_1 {
    //查找输入整数二进制中 1 的个数
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            int cnt=0;
            // Integer.toBinaryString()
            //此方法返回 int 变量的二进制表示的字符串
            String binStr=Integer.toBinaryString(m);
            for (int i = 0; i < binStr.length(); i++) {
                if(binStr.charAt(i)=='1'){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
