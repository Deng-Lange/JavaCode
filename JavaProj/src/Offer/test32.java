package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test32 {
    //题一：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
    /*
    算法流程：
    1、特例处理：当树的根节点为空，则直接返回空列表 []；
    2、初始化：打印结果列表 res = []，包含根节点的队列 queue = [root]；
    3、BFS 循环：当队列 queue 为空时跳出；
       出队：队首元素出队，记为 node；
       打印：将 node.val 添加至列表 tmp 尾部；
       添加子节点：若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue；
    4、返回值：返回打印结果列表 res 即可
     */
    public int[] levelOrder1(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    //题二：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
    /*
    算法流程：
    1、特例处理：当根节点为空，则返回空列表 []；
    2、初始化：打印结果列表 res=[]，包含根节点的队列 queue=[root]；
    3、BFS 循环：当队列 queue 为空时跳出；
      新建一个临时列表 tmp，用于存储当前层打印结果；
      当前层打印循环：循环次数为当前层节点数（即队列 queue 长度）；
           出队：队首元素出队，记为 node；
           打印：将 node.val 添加至 tmp 尾部；
           添加子节点：若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue；
      将当前层结果 tmp 添加入 res；
    4、返回值：返回打印结果列表 res 即可
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    //题三：请实现一个函数按照之字形顺序打印二叉树，
    //即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
    //第三行再按照从左到右的顺序打印，其他行以此类推。
    /*

     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) {
                    tmp.addLast(node.val); // 偶数层 -> 队列头部
                } else {
                    tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
