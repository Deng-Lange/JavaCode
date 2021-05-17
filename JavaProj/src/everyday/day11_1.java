package everyday;

public class day11_1 {
    //有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号
    //根结点编号为 1，现在有两个结点 a，b
    //请设计一个算法，求出 a和 b点的最近公共祖先的编号
    //给定两个 int a,b 为给定结点的编号。请返回 a和 b的最近公共祖先的编号
    //注意这里结点本身也可认为是其祖先
    /*
    满二叉树的子节点与父节点之间的关系为 root = child / 2，
    如果 a!=b，就让其中的较大数除以 2，如此循环直到 a == b，
    即可得到两个数的最近公共祖先。
    即同时让两个节点向上查找公共祖先，直到找到共同的父节点。
     */
    public int getLCA(int a, int b) {
        if (a == b){
            return a;
        }
        return a>b? getLCA(a/2, b): getLCA(a, b/2);
    }
    public int getLCA2(int a, int b) {
        while (a != b) {
            if (a > b) {
                a /= 2;
            }else {
                b /= 2;
            }
        }
        return a;
    }
}
