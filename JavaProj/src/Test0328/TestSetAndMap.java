package Test0328;

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class TestSetAndMap {
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次
    //找出那个只出现了一次的元素
    public int singleNumber2(int[] nums) {
        // <要查找的数值，出现的次数>
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            //遍历 nums，判断 x 是否在 map 中存在
            Integer value = map.get(x);
            if (value == null) {
                // 当前的 x 第一次出现
                map.put(x, 1);
            } else {
                // 当前的 x 出现过了
                map.put(x, value + 1);
            }
        }
        // 遍历 map，找出 value 为 1 的 key
        // map.entrySet()：将 map 转换成一个 set，
        // set 中的每个元素都是一个 entry 对象，
        // 然后再取里面的每个 entry 对象进行遍历，
        // 因为 map 没有继承 Iterable 接口，所以不能使用 for 循环进行遍历
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }
    //巧妙的解法：可以采用按位异或的方式实现
    //两次异或相同的值会抵消掉
    //a^0=>a,a^a=>0,a^b^b=>a,b^a^b=>a
    //将所有数字依次进行异或
    //异或的结果就是只出现一次的值
    public int singleNumber1(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }

    //给一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random，该指针可以指向链表中的任何节点或空节点
    //构造这个链表的深拷贝，深拷贝应该正好由 n 个全新节点组成，其中每个新节点的值都设为其对应的原节点的值
    //新节点的 next 指针和 random 指针也都应指向复制链表中的新节点
    //并使原链表和复制链表中的这些指针能够表示相同的链表状态，复制链表中的指针都不应指向原链表中的节点
    public Node copyRandomList(Node head) {
        // 1. 先遍历旧链表，把每个旧节点都创建对应的新节点，并且插入到 map 中
        // 以旧节点为 key，新节点为 value，插入到 map中
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2. 再次遍历旧链表，构造 next / random 的指向
        // 例如：预期让 新1.next=新2
        // 通过 map.get(旧1)获取 新1，map.get(旧1.next)获取 新2 (旧2=旧1.next)
        // 例如：预期让 新1.random=新3
        // 通过 map.get(旧1)获取 新1，map.get(旧1.random)获取 新3 (旧3=旧1.random)
        for (Node oldNode = head; oldNode != null; oldNode = oldNode.next) {
            // 把 next 相互连接
            Node newNode = map.get(oldNode);
            Node newNodeNext = map.get(oldNode.next);
            newNode.next = newNodeNext;
            // 把 random 也相互连接
            Node newNodeRandom = map.get(oldNode.random);
            newNode.random = newNodeRandom;
        }
        return map.get(head);
    }

    //给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头
    //S中每个字符代表了一种你拥有的石头的类型，想知道你拥有的石头中有多少是宝石
    //J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        // 遍历 jewels，插入到 set 中
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        // 遍历 stones，判定当前字符是否存在
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    //给一非空的单词列表，返回前 k 个出现次数最多的单词
    //返回的答案应该按单词出现频率由高到低排序，如果不同的单词有相同出现频率，按字母顺序排序
    public List<String> topKFrequent(String[] words, int k) {
        // 1. 先统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            //word 不存在，返回默认值 0，再 put 0+1 也就是 1 进去
            Integer value = map.getOrDefault(word, 0);
            map.put(word, value + 1);
//            Integer value = map.get(word);
//            if(value==null){
//                map.put(word,1);
//            }else{
//                map.put(word,value+1);
//            }
        }
        // 2. 此处直接使用排序实现，使用优先队列也可以，但是代码稍微更麻烦一些
        List<String> wordList = new ArrayList<>(map.keySet());
        //排序要指定比较规则，按出现次数排序
        Collections.sort(wordList, new Comparator<String>() {
            //匿名内部类
            @Override
            public int compare(String o1, String o2) {
                // 变量捕获：匿名内部类可以直接使用外部的变量
                // 本质上相当于编译器自动给该匿名内部类创建了一个同名同类型的属性
                // 并且在实例化的时候自动进行了传参
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2) {
                    // 如果出现次数相同，就按照 String 的默认比较规则排序
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });
        //取前 k 个元素
        return wordList.subList(0, k);
    }

    //旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现
    //现在给出预期输入的文字，以及实际输入的文字，请列出肯定坏掉的键
    //思路：把实际输出的内容放到一个 set 中，遍历预期输出的字符串
    //     看哪个字符在实际输出中不存在，就是坏了的键
    //注意：1、大小写字母在同一个键上，所以要忽略大小写
    //     在创建 set 之前可以先将所有字母都转换成大写
    //     2、输出的坏键不能重复，并且顺序和预期输出的字符串顺序一致
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 预期要输出的，比较长，比较全
            String expected = scanner.next();
            // 实际输出的，比较短，有残缺
            String actual = scanner.next();
            // 转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            // 核心操作是要找出 expected 中哪些字符在 actual 中不存在
            // 先把 actual 中的字符都放到一个 set 中
            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                actualSet.add(actual.charAt(i));
            }
            // 遍历 expected 字符串，依次判定当前字符是否在 actualSet 中是否存在
            // 题目要求，坏键不能打印多次
            // 就需要使用另外一个 set 来记录当前已经发现了多少坏键
            // 如果发现某个键坏了，先去这个 set 中查一下
            // 如果不存在就打印，如果存在就直接跳过
            Set<Character> brokenSet = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c=expected.charAt(i);
                if (actualSet.contains(c)) {
                    // 如果 c 存在，说明该按键是好的
                    continue;
                }
                // 如果 c 不存在，说明该键坏了
                // 先判定这个坏键之前有没有出现过
                if (brokenSet.contains(c)) {
                    //这个坏键在前面存在，直接跳过
                    continue;
                }
                // 这个坏键在前面不存在，可以打印
                System.out.print(c);
                brokenSet.add(c);
            }
            // 不要忘记换行，否则可能导致多组用例的结果在同一行
            System.out.println();
        }  // end while
    }  // end main
}
