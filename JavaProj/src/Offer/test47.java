package Offer;

public class test47 {
    //在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0），
    //你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。
    //给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
    /*
    解题思路：
    根据题目说明，易得某单元格只可能从上边单元格或左边单元格到达。
    设 f(i,j)为从棋盘左上角走至单元格(i,j)的礼物最大累计价值，易得到以下递推关系：
    f(i,j)等于 f(i,j−1)和 f(i−1,j)中的较大值加上当前单元格礼物价值 grid(i,j)
    即：f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
    因此，可用动态规划解决此问题，以上公式便为转移方程。
    动态规划解析：
    1、状态定义：设动态规划矩阵 dp，dp(i,j)代表从棋盘的左上角开始到达单元格(i,j)时能拿到礼物的最大累计价值。
    2、转移方程：
       当 i=0 且 j=0 时，为起始元素；
       当 i=0 且 j!=0 时，为矩阵第一行元素，只可从左边到达；
       当 i!=0 且 j=0 时，为矩阵第一列元素，只可从上边到达；
       当 i!=0 且 j!=0 时，可从左边或上边到达；
       dp(i,j)=grid(i,j)，                         i=0 且 j=0
       dp(i,j)=grid(i,j)+dp(i,j−1)，               i=0 且 j!=0
       dp(i,j)=grid(i,j)+dp(i−1,j)，               i!=0 且 j=0
       dp(i,j)=grid(i,j)+max[dp(i−1,j),dp(i,j−1)]，i!=0 且 j!=0
    3、初始状态：dp[0][0]=grid[0][0]，即到达单元格(0,0)时能拿到礼物的最大累计价值为 grid[0][0]；
    4、返回值：dp[m−1][n−1]，m，n分别为矩阵的行高和列宽，即返回 dp 矩阵右下角元素。
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                if(i == 0) {
                    grid[i][j] += grid[i][j - 1] ;
                } else if(j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
