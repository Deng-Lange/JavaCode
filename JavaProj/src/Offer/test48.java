package Offer;

import java.util.HashMap;
import java.util.Map;

public class test48 {
    //请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    /*
    动态规划解析：
    一、状态定义：设动态规划列表 dp，dp[j]代表以字符 s[j]为结尾的 “最长不重复子字符串” 的长度。
    二、转移方程：固定右边界 j，设字符 s[j]左边距离最近的相同字符为 s[i]，即 s[i]=s[j]。
        1.当 i<0，即 s[j]左边无相同字符，则 dp[j]=dp[j−1]+1；
        2.当 dp[j−1]<j−i，说明字符 s[i]在子字符串 dp[j−1]区间之外，则 dp[j]=dp[j−1]+1；
        3.当 dp[j−1]≥j−i，说明字符 s[i]在子字符串 dp[j-1]区间之中，则 dp[j]的左边界由 s[i]决定，即 dp[j]=j−i；
        当 i<0 时，由于 dp[j−1]≤j 恒成立，因而 dp[j−1]<j−i 恒成立，因此分支 1.和 2.可被合并。
            dp[j]=dp[j−1]+1, dp[j−1]<j−i
            dp[j]=j−i,       dp[j−1]≥j−i
    三、返回值：max(dp)，即全局的 “最长不重复子字符串” 的长度。
    方法一：动态规划 + 哈希表
    1.哈希表统计：遍历字符串 s 时，使用哈希表（记为 dic ）统计各字符最后一次出现的索引位置。
    2.左边界 i 获取方式：遍历到 s[j] 时，可通过访问哈希表 dic[s[j]] 获取最近的相同字符的索引 i。
    Java 的 getOrDefault(key,default)方法代表当哈希表包含键 key 时返回对应 value，不包含时返回默认值 default。
    方法二：双指针 + 哈希表
    本质上与方法一类似，不同点在于左边界 i 的定义。
    1.哈希表 dic 统计：指针 j 遍历字符 s，哈希表统计字符 s[j] 最后一次出现的索引。
    2.更新左指针 i：根据上轮左指针 i 和 dic[s[j]]，每轮更新左边界 i，保证区间[i+1,j]内无重复字符且最大。
        i=max(dic[s[j]],i)
    3.更新结果 res：取上轮 res 和本轮双指针区间[i+1,j]的宽度（即 j−i ）中的最大值。
        res=max(res,j−i)
     */
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // tmp存的是dp[j],dp[j-1]->dp[j]
            res = Math.max(res, tmp); // max(dp[j-1], dp[j])
        }
        return res;
    }
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
