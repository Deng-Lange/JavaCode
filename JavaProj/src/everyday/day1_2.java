package everyday;

import java.util.HashMap;
import java.util.Scanner;

//删除公共字符
public class day1_2 {
    public static String rev(String x,String y){
        for(int i=0;i<x.length();i++){
            for(int j=0;j<y.length();j++){
                if(x.charAt(i)==y.charAt(j)){
                    x=rev2(x,i);
                }
            }
        }
        System.out.print(x+"\n");
        return x;
    }
    private static String rev2(String x, int i) {
        return x.substring(0,i)+x.substring(i+1);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        //方法一
        String x=scan.nextLine();
        String y=scan.nextLine();
        rev(x,y);
        //方法二
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        //1、遍历第二个字符串
        for(int i = 0;i < str2.length();i++) {
            //判断当前拿到的字符之前是否存在于 map 中
            if(map.get(str2.charAt(i)) == null) {
                map.put(str2.charAt(i),1);
            }else {
                map.put(str2.charAt(i),map.get(str2.charAt(i))+1);
            }
        }
        String ret = "";
        //2、遍历第一个字符串
        for(int i = 0;i < str1.length();i++) {
            if(map.get(str1.charAt(i)) == null) {
                ret += str1.charAt(i);
            }
        }
        System.out.println(ret);
    }

}
