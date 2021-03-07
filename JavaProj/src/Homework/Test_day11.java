package Homework;

public class Test_day11 {
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    public static boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
    //给定一组字符，使用原地算法将其压缩，压缩后的长度必须始终小于或等于原数组长度。
    public static int compress(char[] chars) {
        int left = 0;
        int size = 0;
        // 由于最后一个字符也需要判断，所以将右指针终点放到数组之外一格
        for (int right = 0; right <= chars.length; right++) {
            // 当遍历完成，或右指针元素不等于左指针元素时，更新数组
            if (right == chars.length || chars[right] != chars[left]) {
                chars[size++] = chars[left];    // 更新字符
                if (right - left > 1) {         // 更新计数，当个数大于 1 时才更新
                    for(char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return size;
    }

    public static void main(String[] args) {
//        String str="abcBA  ";
//        System.out.println(isPalindrome(str));
        char[] ch={'a','a','b','b','c','c','d'};
        System.out.println(compress(ch));
    }
}
