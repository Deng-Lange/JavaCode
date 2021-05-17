package everyday;

import java.util.Scanner;
//排序子序列
public class day2_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n+1];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int i=0;
            int count=0;
            while(i<n){
                if(a[i]<a[i+1]){
                    while(i<n&&a[i]<a[i+1]){
                        i++;
                    }
                    count++;
                    i++;
                }else if(a[i]==a[i+1]){
                    i++;
                }else{
                    while(i<n&&a[i]>a[i+1]){
                        i++;
                    }
                    count++;
                    i++;
                }
            }
            System.out.println(count);
        }
    }

}
