package Test0325;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // 1. 使用 put 方法插入键值对
        //    map 内部对于元素的顺序是有自己的一套规则的
        //    和插入顺序没啥关系
        //    如果 put 的 key已经存在，后来的 value 会覆盖原来的 value
        //    不存在就直接插入，存在就修改 value
        map.put("黑旋风", "李逵");
        map.put("及时雨", "宋江");
        map.put("行者", "武松");
        map.put("小李广", "花荣觉醒形态");
        map.put("及时雨", "宋公明");
        System.out.println(map);

        // 2. 使用 Map 最大的目的是根据 key 来找 value，使用 get 方法完成
        //    是在所有的 key 中查找对应的元素，和 value 无关
        //    getOrDefault 方法：
        //    当 key 存在时就获取到值，不存在 get 就会返回 null / 默认值
//        String value = map.get("李逵");
//        value = map.getOrDefault("小李广", "花荣");
//        System.out.println(value);

        // 3. 使用 size() 获取包含多少个 "键值对"
//        System.out.println(map.size());

        // 4. 使用 isEmpty 判定是否没有键值对(size 为 0)
//        System.out.println(map.isEmpty());

        // 5. 使用 clear 清空所有键值对
//        map.clear();
//        System.out.println(map.isEmpty());
//        System.out.println(map.size());

        // 6. 遍历 map (稍微复杂一点)，map 被设计出来的初衷，不是用于遍历
        //  a) 直接使用 for 循环 (for-each)
        //     此处的 Entry 理解成 "条目" 也就是一个键值对
        //     Entry 是 Map 的内部类
        //     map.entrySet() 其实就是把所有的键值对都取出来放到一个 Set 里
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        // 把所有的 key 取出来放到一个 Set 里，然后再遍历
//        for (String key : map.keySet()) {
//            System.out.println(key);
//        }
        // 把所有的 value 取出来放到一个 List 里，然后遍历
//        for (String value : map.values()) {
//            System.out.println(value);
//        }

        // 上面的 entrySet, keySet, values 方法都是比较低效的方法
        // 尽量还是少用
    }
}
