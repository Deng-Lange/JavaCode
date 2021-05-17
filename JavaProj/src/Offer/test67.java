package Offer;

public class test67 {
    //把字符串转换成整数
    /*
    解题思路：根据题意，有以下四种字符需要考虑：
    1、首部空格：删除即可；
    2、符号位：三种情况，即 '+'，'-'，'无符号'；新建一个变量保存符号位，返回前判断正负即可。
    3、非数字字符：遇到首个非数字的字符时，应立即返回。
    4、数字字符：
       字符转数字：此数字的 ASCII 码与 0 的 ASCII 码相减即可；
       数字拼接：若从左向右遍历数字，设当前位字符为 c，当前位数字为 x，数字结果为 res，
                则数字拼接公式为：res=10×res+x，x=ascii(c)−ascii('0')
     */
    public int strToInt(String str) {
        //先去除空格，再将字符串转换为数组
        char[] c = str.trim().toCharArray();
        if(c.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') {
            sign = -1;
        } else if(c[0] != '+') {
            //无符号
            i = 0;
        }
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') {
                break;
            }
            if(res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}
