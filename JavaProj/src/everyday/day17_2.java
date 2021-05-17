package everyday;

import java.util.Scanner;

public class day17_2 {
    /*
    请设计一个算法完成两个超长正整数的加法。
    输入参数：
    String addend：加数
    String augend：被加数
    返回值：加法结果
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            String[] s=str.split(" ");
            //求相加结果
            System.out.println(AddLongInteger(s[0],s[1]));
        }
    }
    public static String AddLongInteger(String addend, String augend) {
        char[] c1=addend.toCharArray();
        char[] c2=augend.toCharArray();
        //判断是否合法
        //非法
        if(!check(c1)||!check(c2)){
            return "error";
        }
        //合法
        //保证让 c1 指向最长的数组
        if(c1.length<c2.length){
            char[] tmp=c1;
            c1=c2;
            c2=tmp;
        }
        int jw=0;
        int i=c1.length-1;
        int j=c2.length-1;
        for(;j>=0;j--){
            int add=c1[i]-'0'+c2[j]-'0'+jw;
            c1[i]=(char)(add%10+'0');
            jw=add/10;
        }
        for(;i>=0;i--){
            int add=jw+c1[i]-'0';
            c1[i]=(char)(add%10+'0');
            jw=add/10;
        }
        StringBuilder bf=new StringBuilder();
        if(jw!=0){
            bf.append(jw);
        }
        for(i=0;i<c1.length;i++){
            bf.append(c1[i]);
        }
        return bf.toString();
    }
    public static boolean check(char[] c){
        for(int i=0;i<c.length;i++){
            if(c[i]>'9'||c[i]<'0'){
                return false;
            }
        }
        return true;
    }
}
