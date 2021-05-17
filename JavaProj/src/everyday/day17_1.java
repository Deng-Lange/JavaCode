package everyday;

import java.util.Scanner;

public class day17_1 {
    //杨辉三角的变形
    /*
    以上三角形的数阵，第一行只有一个数 1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
    求第 n 行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入 3，则输出 2，输入 4 则输出 3。
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=2*n-1;
            int[][] a=new int[n][m];
            //初始化
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    a[i][j]=0;
                }
            }
            a[0][0]=1;
            //从第二行开始
            for(int i=1;i<n;i++){
                //每一行最后一列的下标是 2i
                //第一列和最后一列的数
                a[i][0]=a[i][2*i]=1;
                //从第二列开始
                for(int j=1;j<2*i;j++){
                    if(j==1){
                        //第二列的数是上一行对应位置两个数的和
                        a[i][j]=a[i-1][j]+a[i-1][j-1];
                    }else{
                        //其他列的数是上一行对应位置三个数的和
                        a[i][j]=a[i-1][j]+a[i-1][j-1]+a[i-1][j-2];
                    }
                }
                int k=0;
                for(;k<m;k++){
                    //第 n 行下标为 n-1
                    if(a[n-1][k]%2==0){
                        System.out.println(k+1);
                        break;
                    }
                }
                //没有偶数
                if(k==m){
                    System.out.println(-1);
                }
            }
        }
    }
}
