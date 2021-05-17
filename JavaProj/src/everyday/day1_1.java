package everyday;

import java.util.Arrays;
import java.util.Scanner;
//组队竞赛
public class day1_1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int num=input.nextInt();
            long[] arr=new long[3*num];
            for(int i=0;i<arr.length;i++){
                arr[i]=input.nextLong();
            }
            Arrays.sort(arr);
            long sum=0;
            for(int i=0;i<num;i++){
                sum+=arr[arr.length-2*(i+1)];
            }
            System.out.println(sum);
        }
    }
}
