package Test0321;

import java.util.Arrays;
import java.util.Stack;

public class MySort {
    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    //插入排序
    //1.针对比较小的数组，排序效率比较高
    //2.如果数组本身已经比较有序，此时排序效率也比较高
    //时间复杂度：O(N^2)  稳定性：稳定
    public static void insertSort(int[] arr) {
        // 这个循环就是在控制代码进行 N 次插入过程
        for (int bound = 1; bound < arr.length; bound++) {
            // 循环内部要实现插入一次的过程
            // 需要找到待排序区间的第一个元素, 放在哪里合适, 并且进行搬运赋值
            // 已排序区间: [0, bound)
            // 待排序区间: [bound, length)
            // 此处的 v 就是待排序区间的第一个元素, 也就是要被插入的元素
            int v = arr[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (arr[cur] > v) {
                    // 如果 cur 位置的元素比待插入元素大
                    // 说明 v 要插入到 arr[cur] 的前面.
                    // 就需要把 arr[cur] 给往后搬运
                    arr[cur + 1] = arr[cur];
                } else {
                    // 此时就相当于找到了要放置 v 的位置
                    break;
                }
            }
            // 如果发现 v 比 arr[cur] 大，就把 v 放到 arr[cur] 的后面
            // 后面的位置是 cur + 1
            arr[cur + 1] = v;
        }
    }

    //希尔排序（插入排序的改进版本）
    // gap 为分组系数，gap 如果为 3，则分为 3 组，每组相邻元素的下标差值就是 3
    // 再针对每个分组，分别进行插入排序
    // 当 gap 较大时，分的组多，每组元素比较少，分组进行插入排序时速度比较快
    // 当 gap 逐渐变小时，每组元素较多，但整体已经相对有序了，所以速度也很快
    // 时间复杂度：O(N^2)  稳定性：不稳定
    public static void shellSort(int[] arr) {
        // 先指定 gap 序列，此处使用希尔序列（gap系数的序列）
        // length/2,length/4,length/8,...,1
        int gap = arr.length / 2;
        while (gap >= 1) {
            // 通过这个辅助方法, 进行分组插排
            _shellSort(arr, gap);
            gap = gap / 2;
        }
    }
    public static void _shellSort(int[] arr, int gap) {
        // 分组插排的时候, 同组中的相邻元素的下标差就是 gap
        // 注意这里面取元素的顺序:
        // 先取 0 组中的第 1 个元素, 尝试往前插入排序;
        // 再取 1 组中的第 1 个元素, 尝试往前插入排序;
        // 再取 2 组中的第 1 个元素, 尝试往前插入排序;
        // ....
        // 再取 0 组中的第 2 个元素, 尝试往前插入排序;
        for (int bound = gap; bound < arr.length; bound++) {
            // 循环内部就要完成比较搬运的过程.
            // 比较搬运都是局限在当前组内的(不同组之间不能影响)
            int v = arr[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (arr[cur] > v) {
                    // 需要进行搬运
                    // v 要插入到 arr[cur] 的前面
                    // 就得把 arr[cur] 往后搬运一个格子，给 v 腾个地方
                    arr[cur + gap] = arr[cur];
                } else {
                    break;
                }
            }
            // 如果发现 v 比 arr[cur] 大，就把 v 放到 arr[cur] 的后面
            // 后面的位置不是 cur + 1，而是 cur + gap
            arr[cur + gap] = v;
        }
    }

    //选择排序
    //核心思路：基于打擂台的方式
    //每次从待排序区间中，找出最小值，放到擂台上
    //擂台就是待排序区间最开始的地方
    //时间复杂度：O(N^2)  稳定性：不稳定
    public static void selectSort(int[] arr) {
        // [0, bound) 已排序区间
        // [bound, length) 待排序区间
        int bound = 0;
        for (; bound < arr.length; bound++) {
            // 里层循环就是进行具体的打擂台的过程
            for (int cur = bound + 1; cur < arr.length; cur++) {
                // 擂台就是 bound 位置的元素
                // 取 cur 位置的元素和擂台进行比较
                if (arr[cur] < arr[bound]) {
                    // 新元素胜出了，就需要交换两个元素的位置
                    // 让新的元素称为擂主
                    swap(arr, cur, bound);
                }
            }
        }
    }

    //堆排序（选择排序的优化）
    //思路：
    //1、建立一个大堆
    //2、把堆顶元素（最大值）和数组最后一个元素交换，此时最大值就来到了数组的末尾，
    //   并把最后一个元素从堆中删除
    //3、前面的部分从 0 开始向下调整
    //时间复杂度：O(N*logN)  稳定性：不稳定
    public static void heapSort(int[] arr) {
        //1.先进行建堆
        createHeap(arr);
        //2.循环进行交换堆顶元素和最后一个元素的过程，并且删除该元素，进行向下调整
        int heapSize = arr.length;
        for (int i = 0; i < heapSize; i++) {
            swap(arr, 0, heapSize - 1);
            //删除最后一个元素
            heapSize--;
            //从 0 这个位置进行向下调整
            shiftDown(arr, heapSize, 0);
        }
    }
    public static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;//左节点
        while (child < size) {     //判断 child 是否存在
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            // 经过上面的 if 之后, child 就指向了左右子树中的较大值.
            // 比较 child 和 parent 的大小
            if (arr[parent] < arr[child]) {
                // 不符合大堆要求
                swap(arr, parent, child);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void createHeap(int[] arr) {
        //先找出最后一个非叶子节点（最后一个节点的父节点）
        //从这个节点开始，依次进行向下调整
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, arr.length, i);
        }
    }

    //冒泡排序
    //时间复杂度：O(N^2)  稳定性：稳定
    public static void bubbleSort(int[] arr) {
        // [0, bound) 已排序区间
        // [bound, length) 待排序区间
        int bound = 0;
        for (; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur] < arr[cur - 1]) {
                    // 不符合升序，交换
                    swap(arr, cur, cur - 1);
                }
            }
        }
    }

    //快速排序
    //思路：先从数组中筛选出一个基准值（最后一个元素）
    //将数组整理成，以基准值为分界，左边都小于基准值，右边都大于基准值
    //创建两个下标 left，right
    //让 left 往右走，找一个比基准值大的元素
    //让 right 往左走，找一个比基准值小的元素
    //交换 left 和 right 的值，继续执行上面两步
    //直到 left 和 right 重合，将重合位置的元素和基准值交换
    //再针对基准值左右两部分分别递归的执行上面步骤
    //时间复杂度：O(N*logN)  稳定性：不稳定
    public static void quickSort(int[] arr) {
        // 使用一个辅助方法进行递归
        // 辅助方法多了两个参数，用来表示针对数组上的哪个区间进行整理
        _quickSort(arr, 0, arr.length - 1);
    }
    // [left, right]
    public static void _quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            // 如果区间为空或者区间只有一个元素, 不必排序
            return;
        }
        // 使用 partition 方法来进行刚才描述的整理过程
        // index 就是 left 和 right 重合的位置，整理之后的基准值的位置
        int index = partition(arr, left, right);
        // 递归处理左半区间
        _quickSort(arr, left, index - 1);
        // 递归处理右半区间
        _quickSort(arr, index + 1, right);
    }
    public static int partition(int[] arr, int left, int right) {
        // 选取基准值
        int v = arr[right];
        int i = left;
        int j = right;
        while (i < j) {
            // 先从左往右找到一个比基准值大的元素
            while (i < j && arr[i] <= v) {
                i++;
            }
            // 再从右往左找到一个比基准值小的元素
            while (i < j && arr[j] >= v) {
                j--;
            }
            //交换 left 和 right 的值
            swap(arr, i, j);
        }
        // 如果发现 i 和 j 重叠了，就需要把基准值元素和 i，j 重叠位置的元素交换
        // 重合位置的元素比基准值大
        swap(arr, i, right);
        return i;
    }
    /*
    快速排序的优化手段：
    1、基准值可以采用三数取中的方式
    2、如果数组很大，就会导致递归的深度很深，如果待处理的区间已经比较小了，
       就不要继续递归了，可以采用直接插入排序
    3、如果递归的深度已经比较深了，而待处理区间仍然很大，可以采用堆排序
     */

    //快速排序的非递归版本
    public static void quickSortByLoop(int[] arr) {
        // 1. 创建一个栈, 栈里面存放要去处理的区间
        Stack<Integer> stack = new Stack<>();
        // 2. 把第一组要去处理的区间入栈
        stack.push(0);
        stack.push(arr.length - 1);
        // 3. 循环取栈顶元素的区间, 进行 partition 操作
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int beg = stack.pop();
            if (beg >= end) {
                // 只有一个元素/空区间, 不需要处理
                continue;
            }
            // 4. 调用 partition 方法, 进行整理
            int index = partition(arr, beg, end);
            // 5. 把得到的子区间再入栈
            // [beg, index - 1] [index + 1, end]
            stack.push(index + 1);
            stack.push(end);

            stack.push(beg);
            stack.push(index - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        quickSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
}
