package everyday;

import java.util.Scanner;
//统计回文
public class day5_1 {
    //判断是否是回文
    public static boolean isHuiWen(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            //是否 s[i]=s[j]
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        int count=0;
        // i 可以等于 str1.length，也就是插入到末尾
        for(int i=0;i<=str1.length();i++){
            //构造一个初始化为指定字符串内容的字符串构建器
            StringBuilder sb=new StringBuilder(str1);
            //将str2插入到str1中的各个位置
            sb.insert(i,str2);
            //方法一：
//            if(isHuiWen(sb.toString())){
//                count++;
//            }
            //方法二：
            StringBuilder tmp=new StringBuilder(sb);
            StringBuilder reverseSb=tmp.reverse();
            if(reverseSb.toString().equals(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
