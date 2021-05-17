package everyday;

public class day12_1 {
    //给定两个 32 位整数 n 和 m，同时给定 i 和 j，
    //将 m 的二进制数位插入到 n 的二进制的第 j 到第 i 位，
    //保证 n 的第 j 到第 i 位均为零，且 m 的二进制位数小于等于 i-j+1，
    //其中二进制的位数从 0 开始由低到高。
    public int BinInsert(int n,int m,int j,int i){
        //将 m 右移 j 位
        m<<=j;
        //和 n 进行或运算
        return m|n;
    }
}
