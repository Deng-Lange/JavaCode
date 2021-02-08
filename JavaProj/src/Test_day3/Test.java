package Test_day3;

public class Test {
    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        } return result;
    }

    //赎金信
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int index = magazine.indexOf(c, chars[c - 'a']);
            if (index == -1) {
                return false;
            }
            chars[c - 'a'] = index + 1;
        }
        return true;
    }

    //是否是回文数
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
//        int i = 7;
//        do {
//            System.out.println(--i);
//            --i;
//        } while (i != 0);
//        System.out.println(i);

//        System.out.println(getValue(2));

//        System.out.println(canConstruct("a","bc"));

        System.out.println(isPalindrome(121));
    }
}
