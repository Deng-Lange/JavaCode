package everyday;

import java.util.Scanner;

public class day4_1 {
    //计算糖果
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int A=(a+c)/2;
        int B1=(c-a)/2;
        int B2=(b+d)/2;
        int C=(d-b)/2;
        if(B1!=B2){
            System.out.println("No");
        }else{
            System.out.println(A+" "+B1+" "+C);
        }
    }
}
