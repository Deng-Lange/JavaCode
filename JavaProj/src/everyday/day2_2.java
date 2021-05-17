package everyday;

import java.util.Scanner;

//倒置字符串
//1、整体字符串进行逆置
//2、每个单词进行逆置
//开始：s.begin()，结尾：s.end()
public class day2_2 {
    public static void reverse(char[] array,int start,int end){
        while(start<end){
            char tmp=array[start];
            array[start]=array[end];
            array[end]=tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            char[] ch=s.toCharArray();
            int len=ch.length;
            //逆置整个字符串
            reverse(ch,0,len-1);
            int i=0;
            while(i<len){
                int j=i;
                while(j<len&&ch[j]!=' '){
                    j++;
                }
                if(j<len){
                    //逆置一个单词
                    reverse(ch,i,j-1);
                    i=j+1;
                }else{
                    reverse(ch,i,j-1);
                    i=j;
                }
            }
            String str=new String(ch);
            System.out.println(str);
        }
    }
}
