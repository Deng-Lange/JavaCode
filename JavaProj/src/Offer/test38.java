package Offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class test38 {
    //输入一个字符串，打印出该字符串中字符的所有排列。
    //你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
    /*
    一、解题思路：对于一个长度为 n 的字符串（假设字符互不重复），其排列方案数共有：
    n×(n−1)×(n−2)…×2×1
    二、排列方案的生成：根据字符串排列的特点，考虑深度优先搜索所有排列方案。
    即通过字符交换，先固定第 1 位字符（ n 种情况）、再固定第 2 位字符（ n−1 种情况）
    最后固定第 n 位字符（ 1 种情况）
    三、重复排列方案与剪枝：当字符串存在重复字符时，排列方案中也存在重复的排列方案。
    为排除重复方案，需在固定某位字符时，保证每种字符只在此位固定一次，
    即遇到重复字符时不交换，直接跳过。从 DFS 角度看，此操作称为剪枝。
    四、递归解析：
    1、终止条件：当 x = len(c) - 1 时，代表所有位已固定（最后一位只有 1 种情况），
                则将当前组合 c 转化为字符串并加入 res，并返回；
    2、递推参数：当前固定位 x；
    3、递推工作：初始化一个 Set，用于排除重复的字符；将第 x 位字符与 i∈[x, len(c)] 字符分别交换，并进入下层递归；
                a、剪枝：若 c[i] 在 Set​中，代表其是重复字符，因此剪枝；
                b、将 c[i] 加入 Set，以便之后遇到重复字符时剪枝；
                c、固定字符：将字符 c[i] 和 c[x] 交换，即固定 c[i] 为当前位字符；
                d、开启下层递归：调用 dfs(x + 1)，即开始固定第 x+1 个字符；
                e、还原交换：将字符 c[i] 和 c[x] 交换（还原之前的交换）。
     */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        // 字符串转换为字符数组
        c = s.toCharArray();
        dfs(0);
        // 将列表List中的元素转导出为数组，导出的是String类型的数组。
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            // 添加排列方案
            // 将char变量c转换成字符串
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            // 重复，因此剪枝
            if(set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i, x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1);
            // 恢复交换
            swap(i, x);
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
