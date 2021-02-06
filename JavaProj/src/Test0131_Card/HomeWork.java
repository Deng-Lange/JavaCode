package Test0131_Card;

import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class HomeWork {
    //员工的重要性
    public int getImportance(List<Employee> employees, int id) {
        for (Employee e: employees) {
            if (e.id == id) {
                if (e.subordinates.size() == 0) {  // 没有子结点，没有下属
                    return e.importance;
                }
                for (int subId: e.subordinates) {
                    e.importance += getImportance(employees, subId);
                }
                return e.importance;
            }
        }
        return 0;
    }
    //将数组分成和相等的三个部分
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num: arr) {
            sum += num;
        }
        // 数组A的和如果不能被3整除返回false
        if (sum % 3 != 0) {
            return false;
        }
        // 遍历数组累加，每累加到目标值cnt加1，表示又找到1段,
        // 找到2段后就返回true（i只能到数组A的倒数第二个元素，保证了有第3段）
        sum /= 3;
        int curSum = 0, cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            curSum += arr[i];
            if (curSum == sum) {
                cnt++;
                if (cnt == 2) {
                    return true;
                }
                curSum = 0;
            }
        }
        return false;
    }
}
