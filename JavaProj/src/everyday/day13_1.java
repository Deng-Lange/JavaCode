package everyday;

import java.util.Scanner;

public class day13_1 {
    //参数解析
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        //计算空格的个数
        int count=0;
        for(int i=0;i<str.length();i++){
            //遇到双引号时，要一直遍历，直到遇到第二个双引号
            //说明双引号中的参数遍历完了
            if(str.charAt(i)=='"'){
                do{
                    i++;
                }while(str.charAt(i)!='"');
            }
            //遇到双引号外的空格
            if(str.charAt(i)==' '){
                count++;
            }
        }
        //输出参数的总个数（空格的个数+1）
        System.out.println(count+1);
        //输出参数
        int flag=1;
        for(int i=0;i<str.length();i++){
            //碰到第一个双引号，flag 变为 0，碰到第二个双引号，flag变为 1
            //说明在 flag 为 0 时，我们一直在遍历双引号中的参数
            if(str.charAt(i)=='"'){
                flag^=1;
            }
            //除了双引号中的空格和双引号，其他字符都输出
            if(str.charAt(i)!=' '&&str.charAt(i)!='"'){
                System.out.println(str.charAt(i));
            }
            //双引号里面的空格要输出
            if(str.charAt(i)==' '&&flag==0){
                System.out.println(str.charAt(i));
            }
            //碰到双引号以外的空格就要换行
            if(str.charAt(i)==' '&&flag==1){
                System.out.println();
            }
        }
    }
}
