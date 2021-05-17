package Offer;

public class test29 {
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
    /*
    算法流程：
    1、空值处理：当 matrix 为空时，直接返回空列表 [] 即可
    2、初始化：矩阵左、右、上、下四个边界 l，r，t，b 用于打印的结果列表 res
    3、循环打印：“从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
       根据边界打印，即将元素按顺序添加至列表 res 尾部；
       边界向内收缩 1（代表已被打印）；
       判断是否打印完毕（边界是否相遇），若打印完毕则跳出
    4、返回值：返回 res 即可

    res[x++] 等价于先给 res[x]赋值，再给 x 自增 1；
    ++t>b 等价于先给 t 自增 1，再判断 t>b 逻辑表达式
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) {
                res[x++] = matrix[t][i]; // left to right.
            }
            if(++t > b) {
                break;
            }
            for(int i = t; i <= b; i++) {
                res[x++] = matrix[i][r]; // top to bottom.
            }
            if(l > --r) {
                break;
            }
            for(int i = r; i >= l; i--) {
                res[x++] = matrix[b][i]; // right to left.
            }
            if(t > --b) {
                break;
            }
            for(int i = b; i >= t; i--) {
                res[x++] = matrix[i][l]; // bottom to top.
            }
            if(++l > r) {
                break;
            }
        }
        return res;
    }
}
