package everyday;

import java.util.Scanner;

public class day11_2 {
    //求一个 byte 数字对应的二进制数字中 1 的最大连续数
    //例如 3 的二进制为 00000011，最大连续 2 个 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int count=0;
            int modCount=0;
            while(n!=0){
                // n&1 如果等于 1，说明最右一位为 1
                if((n&1)==1){
                    count++;
                    modCount=Math.max(count,modCount);
                }else{
                    count=0;
                }
                // n 左移一位，相当于删除了最右一位
                n>>=1;
            }
            System.out.println(modCount);
        }
    }
}
