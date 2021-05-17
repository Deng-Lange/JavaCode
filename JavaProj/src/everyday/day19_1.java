package everyday;

import java.util.Scanner;

public class day19_1 {
    /*
    有这样一道智力题：“某商店规定：3个空汽水瓶可以换1瓶汽水。小张手上有10个空汽水瓶，
    她最多可以换多少瓶汽水喝？” 答案是5瓶。
    方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，
    用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
    然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
    如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
    兑换的个数：n/3
    剩余的空瓶子：n/3 + n%3
    特殊情况：n==2 时，借一瓶
     */
    public static int getNum(int num){
        //累加汽水的个数
        int sum=0;
        //num不能等于 1，num为 1 会造成死循环
        while(num>1){
            //兑换的汽水的个数
            sum+=num/3;
            //剩余的空瓶子的个数
            num=num/3+num%3;
            //借一瓶的情况
            if(num==2){
                ++sum;
                break;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        while((num=sc.nextInt())!=0){
            System.out.println(getNum(num));
        }
    }
}
