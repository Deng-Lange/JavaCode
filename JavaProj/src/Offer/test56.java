package Offer;

import java.util.HashMap;
import java.util.Map;

public class test56 {
    //题一：一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
    //请写程序找出这两个只出现一次的数字。
    /*
    异或运算有个重要的性质，两个相同数字异或为 0，即对于任意整数 a 有 a⊕a=0，
    因此，若将 nums 中所有数字执行异或运算，留下的结果则为出现一次的数字 x，
    数组 nums 有两个只出现一次的数字，因此无法通过异或直接得到这两个数字。
    如果我们可以把所有数字分成两组，使得：
    两个只出现一次的数字在不同的组中；相同的数字会被分到相同的组中。
    那么对两个组分别进行异或操作，即可得到答案的两个数字。
    那么如何实现这样的分组呢？
    记这两个只出现了一次的数字为 a 和 b，那么所有数字异或的结果就等于 a 和 b 异或的结果，
    记为 x，如果我们把 x 写成二进制的形式 x_k，x_{k-1}...x_2，x_1，x_0，其中 x_i∈{0,1}，
    那么 x_i=0 和 x_i=1 的含义是什么？它意味着如果把 a 和 b 写成二进制的形式，
    a_i 和 b_i 的关系：x_i=1 表示 a_i 和 b_i 不等，x_i=0 表示 a_i 和 b_i 相等。
    假如我们任选一个不为 0 的 x_i，按照第 i 位给原来的序列分组，
    如果该位为 0 就分到第一组，否则就分到第二组，这样就能满足以上两个条件。
    算法流程：
    1、先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
    2、在异或结果中找到任意为 1 的位。根据这一位对所有的数字进行分组。
    3、在每个组内进行异或操作，得到两个数字。
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums) {             // 1. 遍历异或
            n ^= num;                     // n 就是两个只出现一次的数字的异或结果
        }
        while((n & m) == 0) {             // 2. 循环左移，计算 m
            m <<= 1;
        }
        for(int num: nums) {              // 3. 遍历 nums 分组
            if((num & m) != 0) {
                x ^= num;                 // 4. 当 num & m != 0
            }
            else {
                y ^= num;                 // 4. 当 num & m == 0
            }
        }
        return new int[] {x, y};          // 5. 返回出现一次的数字
    }

    //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
    //请找出那个只出现一次的数字。
    /*
    统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。
    方法一：有限状态自动机
        异或运算：x^0=x，x^1=~x
        与运算：x&0=0，x&1=x
    方法二：遍历统计
    方法三：HashMap
     */
    public int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
    public int singleNumber2(int[] nums) {
        //使用与运算，可获取二进制数字 num 的最右一位 n_1
        //n_1=num&i
        //配合无符号右移操作，可获取 num 所有位的值，即 n_1~n_32
        //num=num>>>1
        //建立一个长度为 32 的数组 counts
        //可记录所有数字的各二进制位的 1 的出现次数
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;//更新第 j 位
                num >>>= 1;//第 j 位-->第 j+1 位
            }
        }
        //将 counts 各元素对 3 求余，则结果为 “只出现一次的数字” 的各二进制位
        //利用左移操作和或运算，可将 counts 数组中各二进制位的值恢复到数字 res 上
        //循环区间是 i∈[0，31]
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
    public int singleNumber3(int[] nums) {
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

    public static void main(String[] args) {
        int i=5;
        //int s=(i++)+(++i)+(i--)+(--i);
        int x=i++;//x=5,再++完i=6
        int y=x+(++i);//y=5+7=12,i=7
        int z=y+(i--);//z=12+7=19,再--完i=6
        int w=z+(--i);//w=19+5=24
        System.out.println(w);
    }
}
