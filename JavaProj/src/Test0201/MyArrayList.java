package Test0201;

//继承自非受查异常 RuntimeException，不用显示处理
//如果继承自受查异常 Exception，则需要写throws try catch
class MyArrayListIndexOutOfRangeException extends RuntimeException {
    public MyArrayListIndexOutOfRangeException(String message) {
        super(message);
    }
}

// 为了代码简单, 就不写泛型版本了. 直接认为 ArrayList 中存的是若干的 String
public class MyArrayList {
    // 属性
    private String[] data = null;
    // 当前顺序表中的有效元素个数
    private int size = 0;
    // 当前顺序表中的最大容纳元素个数, 如果 size 超过了 capacity, 就需要扩容
    private int capacity = 100;

    // 方法. 增删改查

    //实例化一个数组
    public MyArrayList() {
        data = new String[capacity];
    }

    // 实现扩容
    private void realloc() {
        // 先把 capacity 变大. 具体变大的公式, 可以随意来确定.
        capacity = 2 * capacity;
        String[] newData = new String[capacity];
        // 把旧的数组中的数据拷贝到新数组中.
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        // 把新的大的数组赋值给原有的属性 data. 同时就会释放掉就的数组(GC)
        data = newData;
    }

    // 1. 把元素尾插到顺序表末尾 O(1)
    public void add(String elem) {
        if (size >= capacity) {
            // 需要先扩容
            realloc();
        }
        // 就直接把新的元素放到下标为 size 的位置上即可
        data[size] = elem;
        size++;
    }

    // 2. 把元素插入到任意中间位置 O(N)
    public void add(int index, String elem) {
        // 如果 index == size, 相当于把新元素插入到末尾
        if (index < 0 || index > size) {
            return;
        }
        if (size >= capacity) {
            realloc();
        }
        // 把 elem 放到 index 位置上. 不能覆盖掉已有的元素~~
        // 需要把 index 位置的元素, 依次往后搬运, 给 index 位置腾出一个空闲空间, 来放置 elem
        // size - 1 是从最后一个元素开始
        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
        // 搬运完毕, 把新的元素放到 index 位置上
        data[index] = elem;
        size++;
    }

    // 3. 按照下标位置删除元素, 这个方法的返回结果就是被删掉的元素 O(N)
    public String remove(int index) {
        // 仍然是需要进行搬运. 把 index 位置的元素覆盖掉即可
        if (index < 0 || index >= size) {
            return null;
        }
        String result = data[index];
        //i + 1 <= size - 1 (最后一个元素的下标) 等价于 i <= size - 2 等价于 i < size - 1 (i 是下标)
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return result;
    }

    // 4. 按照元素的值来删除元素, 这个方法返回成功失败 O(N)
    public boolean remove(String elem) {
        // 先找到元素所在的位置
        int index = 0;
        for (; index < size; index++) {
            if (data[index].equals(elem)) {
                break;
            }
        }
        if (index >= size) {
            // 没找到匹配的元素, 删除失败
            return false;
        }
        // 找到匹配的元素了, 从 index 位置开始进行搬运
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    // 5. 根据下标获取元素 O(1)
    public String get(int index) {
        if (index < 0 || index >= size) {
            // 此处可以返回 null, 也可以跑出一个异常
            // return null;
            throw new MyArrayListIndexOutOfRangeException("下标越界了! index: " + index);
        }
        return data[index];
    }

    // 6. 根据下标修改元素 O(1)
    public void set(int index, String elem) {
        if (index < 0 || index >= size) {
            // 此处可以返回 null, 也可以跑出一个异常
            // return null;
            throw new MyArrayListIndexOutOfRangeException("下标越界了! index: " + index);
        }
        data[index] = elem;
    }

    // 7. 判断元素是否存在 O(N)
    public boolean contains(String elem) {
        // 此处不太方便用 for each.
        // for each 是遍历了整个 data 的所有元素.
        // 实际上只需要遍历其中的前 size 个元素即可.
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    // 8. 查找元素位置(从前往后找) O(N)
    public int indexOf(String elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    // 9. 查找元素位置(从后往前找) O(N)
    public int lastIndexOf(String elem) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    //清空元素 O(1)
    public void clear() {
        size = 0;
    }

    //O(1)
    public int size() {
        return size;
    }

    //O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            //如果是最后一个元素，就不用加逗号了
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static void testAdd() {
        MyArrayList myArrayList = new MyArrayList();
        // 1. 验证尾插
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("python");
        System.out.println(myArrayList);

        // 2. 验证中间位置插入
        myArrayList.add(1, "javascript");
        System.out.println(myArrayList);
    }

    private static void testRemove() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("python");

        myArrayList.remove(1);
        System.out.println(myArrayList);

        myArrayList.remove("java");
        System.out.println(myArrayList);
    }

    private static void testGetAndSet() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("python");

        System.out.println(myArrayList.get(1));
        myArrayList.set(1, "javascript");
        System.out.println(myArrayList);

        //myArrayList.get(100);
    }

    private static void testContainsAndIndexOf() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("c++");
        myArrayList.add("python");

        System.out.println(myArrayList.contains("c++"));

        System.out.println(myArrayList.indexOf("c++"));

        System.out.println(myArrayList.lastIndexOf("c++"));
    }

    private static void testSizeEmptyClear() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("c++");
        myArrayList.add("python");

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());

        myArrayList.clear();

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());
    }

    public static void main(String[] args) {
        testRemove();
        testGetAndSet();
        testContainsAndIndexOf();
        testSizeEmptyClear();
    }
}
