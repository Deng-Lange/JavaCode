package everyday;

import java.util.Scanner;

public class day16_1 {
    /*
    完全数计算：
    完全数所有的真因子（即除了自身以外的约数）的和恰好等于它本身。
    例如：28 有约数 1、2、4、7、14、28，除去它本身 28 外，其余 5 个数相加等于 28
    输入 n，请输出 n 以内（含 n）完全数的个数。计算范围：0<n<=500000
     */
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int count=0;
            for(int i=2;i<=n;i++){
                int sum=0;
                for(int j=2;j*j<=i;j++){
                    if(i%j==0){
                        if(i/j==j){
                            sum+=j;
                        }else{
                            sum+=j+i/j;
                        }
                    }
                }
                if(sum+1==i){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
