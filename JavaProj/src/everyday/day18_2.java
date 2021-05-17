package everyday;

import java.util.Scanner;

public class day18_2 {
    /*
    问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。
    现要求各位实现字符串通配符的算法。
    要求：
    实现如下 2 个通配符：
    * ：匹配 0 个或以上的字符（字符由英文字母和数字 0-9 组成，不区分大小写，下同）
    ？：匹配 1 个字符
    先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
    返回匹配的结果，正确输出 true，错误输出 false
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            System.out.println(match(s1,s2,0,0));
        }
    }
    public static boolean match(String s1,String s2,int c1,int c2){
        if(c1==s1.length()&&c2==s2.length()){
            return true;
        }
        if(c1==s1.length()||c2==s2.length()){
            return false;
        }
        if(s1.charAt(c1)=='?'){
            //?匹配 1 个字符
            return match(s1,s2,c1+1,c2+1);
        }else if(s1.charAt(c1)=='*'){
            //*匹配 0 个字符||*匹配 1 个字符||*匹配多个字符
            return match(s1,s2,c1+1,c2)||match(s1,s2,c1+1,c2+1)||match(s1,s2,c1,c2+1);
        }else if(s1.charAt(c1)==s2.charAt(c2)){
            //对应位置字符相同
            return match(s1,s2,c1+1,c2+1);
        }else{
            return false;
        }
    }
}
