package everyday;

import java.util.Scanner;
//不要二
public class day7_1 {
    /*
    根据题意，欧几里得距离为 2 的位置不能放蛋糕
    即为((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))=4
    该表达式只能为 0+4=4 或 4+0=4
    如果(x1-x2)*(x1-x2)为 0，则 x1=x2，y1-y2=2 => y1=y2+2
    如果(y1-y2)*(y1-y2)为 0，则 y1=y2，x1-x2=2 => x1=x2+2
    也就是说，如果(i,j)位置放了蛋糕，那么(i,j+2)和(i+2,j)的位置不能放蛋糕
    注意：要防止 i+2 和 j+2 越界
     */
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int w=sc.nextInt();
        int h=sc.nextInt();
        int count=0;
        int[][] array=new int[w][h];
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                if(array[i][j]==0){
                    count++;
                    if(i+2<w){
                        array[i+2][j]=1;
                    }
                    if(j+2<h){
                        array[i][j+2]=1;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
