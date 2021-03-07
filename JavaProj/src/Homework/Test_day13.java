package Homework;

import java.util.ArrayList;
import java.util.List;

public class Test_day13 {
    //给你一个整数数组 nums，数组中的元素互不相同。返回该数组所有可能的子集。
    //解集不能包含重复的子集。你可以按任意顺序返回解集。
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i=(int)Math.pow(2,n);i<(int)Math.pow(2,n+1);i++) {
            // 生成01字符串
            // .toBinaryString:返回int变量的二进制表示的字符串。
            // .substring(1):返回字符串的子字符串，1为起始位置
            String bitmask = Integer.toBinaryString(i).substring(1);
            // 对于nums中的每个数，如果01字符串中该位为1则加入子集，反之则跳过。
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j)=='1')
                    cur.add(nums[j]);
            }
            result.add(cur);
        }
        return result;
    }

    //给定一个 m*n 的整数矩阵 matrix ，找出其中最长递增路径的长度。
    //对于每个单元格，你可以往上下左右四个方向移动。不能在对角线方向上移动或移动到边界外（即不允许环绕）。
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(subsets(arr));
    }
}
