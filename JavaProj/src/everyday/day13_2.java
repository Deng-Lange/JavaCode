package everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day13_2 {
    /*
    题目：
    小易来到了一条石板路前，每块石板上从 1 挨着编号为：1、2、3.......
    这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为 K的石板，
    小易单次只能往前跳 K 的一个约数（不含 1 和 K）步，即跳到 K+X 的位置。
    小易当前处在编号为 N 的石板，他想跳到编号恰好为 M 的石板去，最少需要跳跃几次可以到达。
    解题思路：
    将 1 至 M 个石板看做一个结果数组 step，每个 step[i] 储存从起点到这一步最小的步数，
    其中 0 为不能到达。从起点开始对 step 进行遍历，
    先求 i 的所有约数（即从 step[i] 能走的步数），然后更新那几个能到达的位置的最小步数。
    如果不能到达则更新为此时位置的最小步数 +1，
    如果是能到达的就更新为 min（已记录的最小步数，此处的最小步数 +1），遍历一遍后得到结果。
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        // step 数组中存放当前位置的最小步数
        int[] step=new int[m+1];
        for(int i=0;i<m+1;i++){
            step[i]=Integer.MAX_VALUE;
        }
        step[n]=0;
        for(int i=n;i<m;i++){
            if(step[i]==Integer.MAX_VALUE){
                continue;
            }
            // list 存放 i 的约数
            List<Integer> list=div(i);
            // i 代表当前石板的编号
            // j 代表一次可以跳几块石板
            for(int j:list){
                if(i+j<=m&&step[i+j]!=Integer.MAX_VALUE){
                    step[i+j]=Math.min(step[i+j],step[i]+1);
                }else if(i+j<=m){
                    step[i+j]=step[i]+1;
                }
            }
        }
        if(step[m]==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(step[m]);
        }
    }
    //求约数
    public static List<Integer> div(int num){
        List<Integer> list=new ArrayList<>();
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                list.add(i);
                if(num/i!=i){
                    list.add(num/i);
                }
            }
        }
        return list;
    }
}
