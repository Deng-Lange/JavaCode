package Offer;

public class test17 {
    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数
    //比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
    /*
    递归生成全排列：
    基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串
    例如当 n=2 时（数字范围 1−99 ），固定十位为 0-9，按顺序依次开启递归，固定个位 0-9，终止递归并添加数字字符串
    1. 删除高位多余的 0：
    字符串左边界定义：声明变量 start 规定字符串的左边界，以保证添加的数字字符串 num[start] 中无高位多余的 0
    例如当 n=2 时，1−9 时 start=1，10−99 时 start=0
    左边界 start 变化规律：观察可知，当输出数字的所有位都是 9 时，则下个数字需要向更高位进 1，此时左边界 start 需要减 1 （即高位多余的 0 减少一个）
    例如当 n=3（数字范围 1−999 ）时，左边界 start 需要减 1 的情况有："009" 进位至 "010"，"099" 进位至 "100"
    设数字各位中 9 的数量为 nine，所有位都为 9 的判断条件可用以下公式表示：n−start=nine
    统计 nine 的方法：固定第 x 位时，当 i=9 则执行 nine=nine+1，并在回溯前恢复 nine=nine−1
    2. 列表从 1 开始：
    在以上方法的基础上，添加数字字符串前判断其是否为 "0"，若为 "0" 则直接跳过
     */
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers1(int n) {
        this.n = n;
        res = new StringBuilder(); //数字字符串集
        num = new char[n]; //定义长度为 n 的字符列表
        start = n - 1;
        dfs(0); //开启全排列递归
        res.deleteCharAt(res.length() - 1); //删除最后多余的逗号
        return res.toString(); //转化为字符串并返回
    }
    void dfs(int x) {
        if(x == n) { //终止条件：已固定完所有位
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) {
                res.append(s + ","); //拼接 num 并添加至 res 尾部，使用逗号隔开
            }
            if(n - start == nine) {
                start--;
            }
            return;
        }
        for(char i : loop) { //遍历 '0'-'9'
            if(i == '9') {
                nine++;
            }
            num[x] = i; //固定第 x 位为 i
            dfs(x + 1); //开启固定第 x + 1 位
        }
        nine--;
    }

    //不考虑大数越界情况
    public int[] printNumbers2(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }
}
