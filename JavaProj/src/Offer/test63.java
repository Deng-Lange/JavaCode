package Offer;

public class test63 {
    //假设把某股票的价格按照时间先后顺序存储在数组中，
    //请问买卖该股票一次可能获得的最大利润是多少？
    /*
    动态规划解析：
    1、状态定义：设动态规划列表 dp，
       dp[i] 代表以 prices[i] 为结尾的子数组的最大利润（以下简称为前 i 日的最大利润）。
    2、转移方程：由于题目限定 “买卖该股票一次” ，
       因此前 i 日最大利润 dp[i] 等于前 i−1 日最大利润 dp[i−1] 和第 i 日卖出的最大利润中的最大值。
       前 i 日最大利润 = max(前(i−1)日最大利润,第i日价格−前i日最低价格)
       dp[i]=max(dp[i−1],prices[i]−min(prices[0:i]))
    3、初始状态：dp[0]=0，即首日利润为 0；
    4、返回值：dp[n−1]，其中 n 为 dp 列表长度。
    效率优化：
    1、时间复杂度降低：前 i 日的最低价格 min(prices[0:i]) 时间复杂度为 O(i)。
       而在遍历 prices 时，可以借助一个变量（记为成本 cost）每日更新最低价格。
       优化后的转移方程为：
       dp[i]=max(dp[i−1],prices[i]−min(cost,prices[i])
    2、空间复杂度降低：由于 dp[i] 只与 dp[i−1]，prices[i]，cost 相关，
       因此可使用一个变量（记为利润 profit ）代替 dp 列表。
       优化后的转移方程为：
       profit=max(profit,prices[i]−min(cost,prices[i])
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
