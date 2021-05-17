package Offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class test50 {
    //在字符串 s中找出第一个只出现一次的字符，如果没有，返回一个单空格，s只包含小写字母。
    /*
    方法一：哈希表
        算法流程：
        一、初始化：HashMap记为 dic；
        二、字符统计：遍历字符串 s 中的每个字符 c；
            若 dic 中不包含键(key) c：则向 dic 中添加键值对(c, True)，代表字符 c 的数量为 1；
            若 dic 中包含键(key) c：则修改键 c 的键值对为 (c, False)，代表字符 c 的数量 >1。
        三、查找数量为 1 的字符：遍历字符串 s 中的每个字符 c；
            若 dic中键 c 对应的值为 True：则返回 c。
        四、返回 ' '，代表字符串中没有数量为 1 的字符。
    方法二：有序哈希表
        在哈希表的基础上，有序哈希表中的键值对是按照插入顺序排序的。
        基于此，可通过遍历有序哈希表，实现搜索首个 “数量为 1 的字符”。
        哈希表是去重的，即哈希表中键值对数量 ≤ 字符串 s 的长度。
        因此，相比于方法一，方法二减少了第二轮遍历的循环次数。
        当字符串很长（重复字符很多）时，方法二则效率更高。
     */
    public char firstUniqChar1(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for(char c : sc) {
            if(dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }
}
