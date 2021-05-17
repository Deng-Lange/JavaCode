package Offer;

import java.util.Arrays;

public class test60 {
    //把 n个骰子扔在地上，所有骰子朝上一面的点数之和为 s。
    //输入 n，打印出 s 的所有可能的值出现的概率。
    //你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        //填充 dp 数组中的每个元素都是 1.0/6.0
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
