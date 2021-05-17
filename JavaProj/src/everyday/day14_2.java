package everyday;

import java.util.Arrays;
import java.util.Scanner;

public class day14_2 {
    //一个袋子里面有 n个球，每个球上面都有一个号码（拥有相同号码的球是无区别的）。
    //如果一个袋子是幸运的：当且仅当所有球的号码的和大于所有球的号码的积。
    //例如：如果袋子里面的球的号码是{1，1，2，3}，这个袋子就是幸运的，因为 1+1+2+3>1*1*2*3
    //你可以适当从袋子里移除一些球（可以移除 0 个，但是别移除完），要使移除后的袋子是幸运的。
    //现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
    /*
    解题思路：
    1、将袋子里的球的号码从小到大排序
    2、当一个号码和前面的号码无法组成幸运袋子，就直接 break，无需再向后判断
    3、当我们返回上层递归时，需要回溯，继续计算前面的号码和后面位置的号码是否可以构成幸运袋子
    特殊情况：需要判断 a[i] 是否为 1
    a[i]=1 时，若不能满足，组合的数不能增加，但继续向后搜索，仍然有满足条件的可能
    因为 1 和任何数的和都大于 1 和任何数的积
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        //排序
        Arrays.sort(a);
        System.out.println(count(a,n,0,0,1));
    }
    public static int count(int[] a,int n,int pos,int sum,int multi){
        int count=0;
        for(int i=pos;i<n;i++){
            sum+=a[i];
            multi*=a[i];
            if(sum>multi){
                //满足条件，递归判断下一个位置的号码
                count=count+1+count(a,n,i+1,sum,multi);
            }else if(a[i]==1){
                //处理特殊情况
                count=count+count(a,n,i+1,sum,multi);
            }else{
                break;
            }
            //回溯
            sum=sum-a[i];
            multi=multi/a[i];
            //判断下一个位置的号码与当前号码是否一样
            while(i<n-1&&a[i]==a[i+1]){
                i++;
            }
        }
        return count;
    }
}
