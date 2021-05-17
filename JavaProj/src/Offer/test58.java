package Offer;

public class test58 {
    //题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
    //为简单起见，标点符号和普通字母一样处理。
    //例如输入字符串"I am a student."，则输出"student. a am I"。
    /*
    双指针法
    算法解析：
    1、倒序遍历字符串 s，记录单词左右索引边界 i，j；
    2、每确定一个单词的边界，则将其添加至单词列表 res；
    3、最终，将单词列表拼接为字符串，并返回即可。
     */
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            //搜索首个空格
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            //添加单词
            res.append(s.substring(i + 1, j + 1) + " ");
            //跳过单词间空格
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            //j指向下个单词的尾字符
            j = i;
        }
        //转化为字符串并返回
        return res.toString().trim();
    }
    //题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    //请定义一个函数实现字符串左旋转操作的功能。
    //比如，输入字符串"abcdefg"和数字 2，该函数将返回左旋转两位得到的结果"cdefgab"。
    /*
    方法一：字符串切片
     */
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
    /*
    方法二：列表遍历拼接
    若规定不允许使用切片函数，则使用此方法。
    算法流程：
    1、新建一个 StringBuilder，记为 res；
    2、先向 res 添加 “第 n+1 位至末位的字符”；
    3、再向 res 添加 “首位至第 n 位的字符”；
    4、将 res 转化为字符串并返回。
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for(int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
    /*
    方法三：字符串遍历拼接
    若规定 Java 只能用 String，则使用此方法。
    此方法与方法二思路一致，区别是使用字符串代替列表。
     */
    public String reverseLeftWords3(String s, int n) {
        String res = "";
        for(int i = n; i < s.length(); i++) {
            res += s.charAt(i);
        }
        for(int i = 0; i < n; i++) {
            res += s.charAt(i);
        }
        return res;
    }
}
