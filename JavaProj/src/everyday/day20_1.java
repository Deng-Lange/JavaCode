package everyday;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class day20_1 {
    //写出一个程序，接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。
    public static void main(String[] args) throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=reader.readLine())!=null){
            //逆转：首尾元素交换
            char[] arr=str.toCharArray();
            int start=0;
            int end=arr.length-1;
            while(start<end){
                char tmp=arr[start];
                arr[start]=arr[end];
                arr[end]=tmp;
                start++;
                end--;
            }
            System.out.println(arr);
        }
    }
}
