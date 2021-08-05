package Sort;

import java.util.Arrays;
import java.util.Stack;

public class MySort {
    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    //插入排序
    //1.针对比较小的数组，排序效率很高
    //2.如果数组本身已经比较有序，此时排序效率也很高
    //时间复杂度：O(N^2)  空间复杂度：O(1) 稳定性：稳定
    public static void insertSort(int[] arr) {
        // 这个循环就是在控制代码进行 N 次插入过程
        for (int bound = 1; bound < arr.length; bound++) {
            // 循环内部要实现插入一次的过程
            // 需要找到待排序区间的第一个元素，放在哪里合适，并且进行搬运赋值
            // 已排序区间: [0, bound)
            // 待排序区间: [bound, length)
            // 此处的 v 就是待排序区间的第一个元素，也就是要被插入的元素
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

    // 希尔排序（插入排序的改进版本）
    // 针对序列进行分组，对每一组分别进行插入排序，
    // 再调整分组的变化，逐渐使整个数组逼近有序的状态
    // gap 为分组系数，gap 如果为 3，则分为 3 组，
    // 每组相邻元素的下标差值就是 3，再针对每个分组，分别进行插入排序
    // gap 的选择：size/2，size/4，size/8......
    // 当 gap 较大时，分的组多，每组元素比较少，分组进行插入排序时速度比较快
    // 当 gap 逐渐变小时，每组元素较多，但整体已经相对有序了，所以速度也很快
    // 时间复杂度：O(N^2)  空间复杂度：O(1) 稳定性：不稳定
    public static void shellSort(int[] arr) {
        // 先指定 gap 序列，此处使用希尔序列（gap系数的序列）
        // length/2，length/4，length/8，...，1
        int gap = arr.length / 2;
        while (gap >= 1) {
            // 通过这个辅助方法，进行分组插排
            _shellSort(arr, gap);
            gap = gap / 2;
        }
    }
    public static void _shellSort(int[] arr, int gap) {
        // 分组插排的时候，同组中的相邻元素的下标差就是 gap
        // 注意这里面取元素的顺序:
        // 先取 0 组中的第 1 个元素，尝试往前插入排序；
        // 再取 1 组中的第 1 个元素，尝试往前插入排序；
        // 再取 2 组中的第 1 个元素，尝试往前插入排序；
        // ....
        // 再取 0 组中的第 2 个元素，尝试往前插入排序；
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
    //时间复杂度：O(N^2) 空间复杂度：O(1) 稳定性：不稳定
    public static void selectSort(int[] arr) {
        // [0, bound) 已排序区间
        // [bound, length) 待排序区间
        for (int bound = 0; bound < arr.length; bound++) {
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
    //3、前面的部分从 0 号元素开始向下调整
    //时间复杂度：O(N*logN)  空间复杂度：O(1) 稳定性：不稳定
    public static void heapSort(int[] arr) {
        //1.先进行建堆（大堆）
        createHeap(arr);
        //2.循环进行交换堆顶元素和最后一个元素的过程，并且删除该元素，再从 0 位置进行向下调整
        int heapSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            //交换堆顶元素和最后一个元素
            swap(arr, 0, heapSize - 1);
            //删除最后一个元素
            heapSize--;
            //从 0 位置进行向下调整
            shiftDown(arr, heapSize, 0);
        }
    }
    public static void createHeap(int[] arr) {
        //先找出最后一个非叶子节点（最后一个节点的父节点）
        //从这个节点开始，依次进行向下调整
        //先减 1 找到最后一个元素的下标，再减 1 除 2 找到最后一个元素的父节点
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, arr.length, i);
        }
    }
    public static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;//左节点
        while (child < size) {     //判断 child 是否存在
            //先找出左右子树比较大的
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            // 经过上面的 if 之后，child 就指向了左右子树中的较大值.
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

    //冒泡排序
    //时间复杂度：O(N^2) 空间复杂度：O(1) 稳定性：稳定
    public static void bubbleSort(int[] arr) {
        // [0, bound) 已排序区间
        // [bound, length) 待排序区间
        for (int bound = 0; bound < arr.length; bound++) {
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
    //时间复杂度：平均：O(N*logN)
    //           最坏：O(N^2)，正好数组是逆序时
    //空间复杂度：平均：O(logN)，递归深度决定了空间复杂度
    //           最坏：O(N)，正好数组是逆序时
    //稳定性：不稳定
    public static void quickSort(int[] arr) {
        // 使用一个辅助方法进行递归
        // 辅助方法多了两个参数，用来表示针对数组上的哪个区间进行整理
        _quickSort(arr, 0, arr.length - 1);
    }
    // [left, right]
    public static void _quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            // 如果区间为空或者区间只有一个元素，不必排序
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
    1、基准值可以采用三数取中的方式（在开始元素，末尾元素，中间元素里取中间值）
    2、如果数组很大，就会导致递归的深度很深，如果待处理的区间已经比较小了，
       就不要继续递归了，可以采用插入排序
    3、如果递归的深度已经比较深了，而待处理区间仍然很大，可以采用堆排序
     */

    //快速排序的非递归版本
    public static void quickSortByLoop(int[] arr) {
        // 1. 创建一个栈，栈里面存放要去处理的区间
        Stack<Integer> stack = new Stack<>();
        // 2. 把第一组要去处理的区间入栈
        stack.push(0);
        stack.push(arr.length - 1);
        // 3. 循环取栈顶元素的区间，进行 partition 操作
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int beg = stack.pop();
            if (beg >= end) {
                // 只有一个元素/空区间，不需要处理
                continue;
            }
            // 4. 调用 partition 方法，进行整理
            int index = partition(arr, beg, end);
            // 5. 把得到的子区间再入栈
            // [beg,index-1] [index+1,end]
            stack.push(index + 1);
            stack.push(end);

            stack.push(beg);
            stack.push(index - 1);
        }
    }

    //归并排序：合并两个有序数组为一个有序数组
    //时间复杂度：O(N*logN)
    //空间复杂度：O(N)
    //稳定性：稳定
    public static void mergeSort(int[] arr) {
        // 创建一个新的方法辅助递归，新方法中多了两个参数
        // 表示是针对当前数组中的哪个部分进行排序
        // 前闭后开区间
        _mergeSort(arr, 0, arr.length);
    }
    // [left,right) 前闭后开区间
    // right-left 就是区间中的元素个数
    public static void _mergeSort(int[] arr, int left, int right) {
        if (right - left <= 1) {
            // 如果当前待排序的区间里只有 1 个元素或者没有元素
            // 就直接返回，不需要排序
            return;
        }
        // 先把当前 [left, right) 区间一分为二
        int mid = (left + right) / 2;
        // 分成了两个区间
        // [left, mid)  [mid, right)
        // 当左侧区间的 _mergeSort 执行完毕后,
        // 就认为 [left, mid) 就已经是有序区间了
        _mergeSort(arr, left, mid);
        // 当右侧区间的 _mergeSort 执行完毕后,
        // 就认为 [mid, right) 就已经是有序区间了
        _mergeSort(arr, mid, right);
        // 接下来把左右两个有序的数组, 合并到一起!!
        merge(arr, left, mid, right);
    }
    // merge 方法的功能是把两个有序数组合并成一个有序数组
    // 待合并的两个数组就分别是：[left,mid) [mid,right)
    public static void merge(int[] arr, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        // 创建一个临时的数组，用来存放合并结果.
        // 我们希望这个数组能存下合并后的结果 right-left
        int[] tmp = new int[right - left];
        // 当前要把新的元素放到 tmp 数组的哪个下标上
        int tmpSize = 0;
        int l = left;
        int r = mid;
        while (l < mid && r < right) {
            // 归并排序是稳定排序！
            // 此处的条件不要写作 arr[l] < arr[r]
            if (arr[l] <= arr[r]) {
                // arr[l] 比较小, 就把这个元素先插入到 tmp 数组末尾
                tmp[tmpSize] = arr[l];
                tmpSize++;
                l++;
            } else {
                // arr[r] 比较小, 就把这个元素插入到 tmp 数组的末尾
                tmp[tmpSize] = arr[r];
                tmpSize++;
                r++;
            }
        }
        // 当其中一个数组遍历完了之后，就把另外一个数组的剩余部分都拷贝过来
        while (l < mid) {
            // 剩下的是左半边数组
            tmp[tmpSize] = arr[l];
            tmpSize++;
            l++;
        }
        while (r < right) {
            // 剩下的是右半边数组
            tmp[tmpSize] = arr[r];
            tmpSize++;
            r++;
        }
        // 最后一步，再把临时空间的内容都拷贝回参数数组中.
        // 需要把 tmp 中的内容拷贝回 arr 的 [left, right) 这一段空间里
        // [left, right) 这个空间很可能不是从 0 开始的额.
        for (int i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }
    }

    //归并排序的非递归版本
    public static void mergeSortByLoop(int[] arr) {
        // gap 就表示当前待合并的有序数组的长度
        for (int gap = 1; gap < arr.length; gap *= 2) {
            // 外层循环
            // 第一次是把所有长度为 1 的有序数组两两合并
            // 第二次是把所有长度为 2 的有序数组两两合并
            // 第三次是把所有长度为 4 的有序数组两两合并
            for (int i = 0; i < arr.length; i += 2*gap) {
                // 里层循环执行一次就是让两个 gap 长的相邻数组合并一次
                // 两个数组分别就是 [left, mid) [mid, right)
                int left = i;
                int mid = i + gap;
                if (mid >= arr.length) {
                    mid = arr.length;
                }
                int right = i + 2 * gap;
                if (right >= arr.length) {
                    right = arr.length;
                }
                merge(arr, left, mid, right);
            }
        }
    }
    /*
    内部排序：完全在内存中进行
    外部排序：数据量太大，内存存不下，借助磁盘
    例如：内存只有 1G，需要排序的数据有 100G
    1、将数据分成 N 份，保证每一份都能在内存中放下；
    2、使用内部排序，把每一份数据进行排序，再写回到磁盘上（写文件）
    3、针对 N 个有序数组进行 N 路归并排序
       创建 N 个下标指向 N 个有序数组的起始位置，
       内存中存一个 N 个元素（N 个起始位置中最小值）的小堆
       堆中还要保存这个数据是从哪个文件中取出的（存一个文件流对象）
       取出堆顶元素（min），把 min 写入到结果集合（磁盘上）中，并将 min 从堆中删除
       从 min 元素对应的文件流中读取下一个元素存入堆中，调整堆使其是一个小堆
       再重复之前的过程
     */

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
