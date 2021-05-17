package Offer;

public class test13 {
    //地上有一个 m 行 n 列的方格，从坐标 [0,0] 到坐标 [m-1,n-1]
    //一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格
    //不能移动到方格外，也不能进入行坐标和列坐标的数位之和大于 k 的格子
    //例如，当 k 为 18 时，机器人能够进入方格 [35, 37]，因为3+5+3+7=18
    //但它不能进入方格 [35, 38]，因为3+5+3+8=19
    //请问该机器人能够到达多少个格子？
    /*
    1、递归参数：当前元素在矩阵中的行列索引 i 和 j，两者的数位和 si, sj
    2、终止条件：当行列索引越界||数位和超出目标值 k||当前元素已访问过时，返回 0，代表不计入可达解
    3、递推工作：
       标记当前单元格：将索引 (i, j) 存入 Set visited 中，代表此单元格已被访问过
       搜索下一单元格：计算当前元素的下、右两个方向元素的数位和，并开启下层递归
    4、回溯返回值：返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数
       代表从本单元格递归搜索的可达解总数
     */
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
                + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}
