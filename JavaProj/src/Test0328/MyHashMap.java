package Test0328;

class HashNode {
    public int key;
    public int value;
    public HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/*
哈希冲突如何处理：
1、闭散列：如果冲突了，就找下一个空闲的位置
   在数组中存数据时，不再使用 int 数组，而使用对象数组，在对象中保存数字的原始值
   闭散列的问题在于：一旦数组比较拥挤，性能就会下降的非常严重，
   要想解决这个问题就需要频繁扩容，保持数组尽量稀疏
2、开散列：数组上的元素不单单是一个元素，而是一个链表的头节点，
   一旦出现哈希冲突，就把当前对象插入到对应位置的链表上即可
   使用开散列解决冲突有可能出现某个下标位置链表特别长的情况，
   此时的优化手段：1)扩容 2)把较长的链表转换成红黑树/哈希表

哈希函数的设计：除留余数法
设散列表中允许的地址数为 m，取一个不大于 m，但最接近或者等于 m 的质数 p 作为除数，
按照哈希函数：Hash(key) = key % p (p<=m)，将关键码转换成哈希地址

字符串如何计算哈希值：md5
 */

// 面试经常出现
// 开散列/哈希桶 的方式来处理哈希冲突
public class MyHashMap {
    // array 数组用来保存哈希表中每个链表的头节点
    private HashNode[] array = new HashNode[16];
    // size 表示数组中有几个节点
    private int size = 0;

    // 插入节点
    public void put(int key, int value) {
        // 1. 先把 key 转成数组下标，使用除留余数的方式来计算 hash 值
        int index = key % array.length;
        // 2. 遍历该位置的链表，看 key 是否已经存在
        //    如果 key 已经存在，就不必插入新的点，直接修改 value 值即可
        for (HashNode cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                // 找到 key 已经存在，直接修改 value
                cur.value = value;
                return;
            }
        }
        // 3. 如果没找到存在相同的 key，就插入新节点
        HashNode newNode = new HashNode(key, value);
        // 直接链表头插即可
        newNode.next = array[index];
        array[index] = newNode;
        size++;
        // 4. 判定 size 是否达到一定的数值，如果达到就扩容
        // 负载因子达到多少才进行扩容？最好的办法是根据实际情况做实验试试
        // 负载因子越小，此时空间利用率越低
        // 负载因子越大，此时性能可能受到影响
        // 此处写的 0.75，java 标准库的 HashMap 负载因子阈值的默认值就是 0.75
        if (loadFactor() > 0.75) {
            resize();
        }
    }
    // 扩容
    private void resize() {
        // 创建一个更长的数组，把原来的元素给拷贝进去
        HashNode[] newArray = new HashNode[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            // 遍历当前链表
            HashNode next = null;
            for (HashNode cur = array[i]; cur != null; cur = next) {
                // 修改 cur.next 之前，先备份之前的位置
                next = cur.next;
                // 把当前 cur 指向的节点插入到新的数组上
                int indexNew = cur.key % newArray.length;
                cur.next = newArray[indexNew];
                newArray[indexNew] = cur;
            }
        }
    }
    // 负载因子
    private double loadFactor() {
        return (double)size / array.length;
    }

    //通过 key 获取 value
    public Integer get(int key) {
        // 先根据 key，计算得到一个 index
        // 再遍历链表即可
        int index = key % array.length;
        for (HashNode cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.value;
            }
        }
        return null;
    }
}
