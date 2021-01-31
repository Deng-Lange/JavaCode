package Test0131_Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        // 1. 创建 ArrayList 实例
        List<String> arrayList = new ArrayList<>();
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());

        // 2. 往 ArrayList 中添加一些元素
        // add 一个参数的版本, 是把元素添加到顺序表末尾(非常常用的操作)
        arrayList.add("c");
        arrayList.add("c++");
        arrayList.add("java");
        arrayList.add("python");
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        System.out.println("尾插四次的结果: " + arrayList);
        // add 的两个参数版本, 是把元素添加到指定的位置上.
        arrayList.add(2, "javascript");
        arrayList.add("javascript");
        System.out.println(arrayList.size());
        System.out.println("中间插入一次的结果: " + arrayList);

        // 3. 删除元素
//        arrayList.remove(2);
//        System.out.println("按位置删除: " + arrayList);

//        arrayList.remove("javascript");
//        System.out.println("按值删除: " + arrayList);

        // 4. 查找
        boolean ret = arrayList.contains("java");
        System.out.println("查找 java 的结果为: " + ret);

        int index = arrayList.indexOf("go");
        System.out.println("查找 go 的位置为: " + index);

        // 5. 获取元素/修改元素
        String elem = arrayList.get(0);
        System.out.println("0 号元素为" + elem);
        arrayList.set(0, "PHP");
        System.out.println("修改之后的顺序表为: " + arrayList);

        // 6. 遍历操作
        // a) 通过下标来进行遍历
        System.out.println("通过下标来遍历: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        // b) 通过迭代器来进行遍历
        System.out.println("通过迭代器遍历元素: ");
        // 先通过 iterator 方法获取到迭代器对象
        Iterator<String> iterator = arrayList.iterator();
        // 再通过 while 循环来进行遍历
        while (iterator.hasNext()) {
            String e = iterator.next();
            System.out.println(e);
        }
        // c) 直接使用 for-each 来遍历 (本质上是基于迭代器的方式来实现的)
        System.out.println("通过 for-each 进行遍历: ");
        for (String e : arrayList) {
            System.out.println(e);
        }

//        List<Integer> list = new ArrayList<>();
//        list.add(Integer.valueOf(2));
//        list.add(Integer.valueOf(3));
//        list.add(4);
//        list.add(5);
//        list.remove(2);
    }
}
