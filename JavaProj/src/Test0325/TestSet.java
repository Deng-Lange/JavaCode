package Test0325;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // 1. 插入元素，使用 add 方法进行插入
        //    如果 key 重复了，就只保留一份
        //    set 是一个 "集合"
        set.add("C");
        set.add("C++");
        set.add("Java");
        set.add("Python");
        System.out.println(set);
        // 2. 判定元素是否存在，这是 Set 最大的意义
        boolean ret = set.contains("Python");
        System.out.println(ret);
        // 3. 删除元素
        set.remove("Python");
        System.out.println(set);

        // 4. 遍历 Set
        //  a) 和 b) 本质上是一样的
        //  a) 直接使用 for-each，语法糖
        // 一个啥样的对象可以使用 for-each 呢？
        // 只要这个对象支持迭代器(实现 Iterable 接口)
        for (String key : set) {
            System.out.println(key);
        }
        //  b) 使用迭代器 Iterator
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
