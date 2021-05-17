package everyday;

import java.util.Scanner;
//字符串中找出连续最长的数字串
public class day3_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //方法一：
//        while(scanner.hasNext()){
//            String str=scanner.nextLine();
//            int max=0;
//            int count=0;
//            int end=0;
//            for(int i=0;i<str.length();i++){
//                if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
//                    count++;
//                    if(max<count){
//                        max=count;
//                        end=i;
//                    }
//                }else{
//                    count=0;
//                }
//            }
//            System.out.println(str.substring(end-max+1,end+1));
//        }
        //方法二：
        String str=scanner.nextLine();
        String ret="";
        String cur="";
        int i=0;
        for(;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>'0'&&ch<'9'){
                cur=cur+ch+"";
            }else{
                if(ret.length()<cur.length()){
                    ret=cur;
                }else{
                    cur="";
                }
            }
        }
        //处理最长数字串在最后的情况
        if(i==str.length()&&ret.length()<cur.length()){
            ret=cur;
        }
        System.out.println(ret);
    }
}
