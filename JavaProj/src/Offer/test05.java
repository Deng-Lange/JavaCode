package Offer;

public class test05 {
    //请实现一个函数，把字符串 s 中的每个空格替换成 "%20"
    /*
    遍历添加
    1、初始化一个 StringBuilder，记为 res
    2、遍历列表 s 中的每个字符 c
       当 c 为空格时：向 res 后添加字符串 "%20"
       当 c 不为空格时：向 res 后添加字符 c
    3、将列表 res 转化为字符串并返回
     */
    public static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(c == ' '){
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s="I love java!";
        System.out.println(replaceSpace(s));
    }
}
