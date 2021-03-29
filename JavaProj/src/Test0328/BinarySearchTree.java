package Test0328;

class BinaryNode {
    public int key;
    public int value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class BinarySearchTree {
    // 空树就使用 null 表示
    private BinaryNode root = null;

    // 查找
    public Integer get(int key) {
        // 创建一个引用 cur 从 root 出发
        // 比较 key 和 cur.key 之间的大小关系，决定下一步往哪个方向找
        BinaryNode cur = root;
        while (cur != null) {
            if (key < cur.key) {
                // 往左子树方向找
                cur = cur.left;
            } else if (key > cur.key) {
                // 往右子树方向找
                cur = cur.right;
            } else {
                // 找到了
                return cur.value;
            }
        }
        // 没有找到匹配的 key
        return null;
    }

    // 插入：基于查找方法，在查找过程中时刻记录父节点的位置
    // 保证新节点插入到叶子节点上
    public void put(int key, int value) {
        if (root == null) {
            // 直接把新节点挂到 root 上就好了
            root = new BinaryNode(key, value);
            return;
        }
        // 创建一个 cur 从 root 出发，找到一个合适的插入位置
        BinaryNode cur = root;
        // 记录下 cur 的父节点
        BinaryNode parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                // 当 key 相同的时候，并不真的插入新节点
                // 而是用 value 来替换旧的节点的值
                cur.value = value;
                return;
            }
        }
        // 当循环结束，cur 就为 null，说明已经找到了要插入的位置
        // cur 为 null 的时候就说明新节点要插入到 parent 的子树位置
        BinaryNode newNode = new BinaryNode(key, value);
        if (newNode.key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    // 删除
    public void remove(int key) {
        // 1. 先查找待删除节点的位置，也需要同步记录该节点的父节点位置
        BinaryNode cur = root;
        BinaryNode parent = null;
        while (cur != null) {
            if (key < cur.key) {
                // 往左侧找
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                // 往右侧找
                parent = cur;
                cur = cur.right;
            } else {
                // 2. key 相等, 找到了待删除节点
                removeNode(parent, cur);
                return;
            }
        }
    }
    // 由于当前的 removeNode 方法只是给类自己的 remove 方法来使用
    // 没有其他用途，所以不应该暴露到类的外部
    private void removeNode(BinaryNode parent, BinaryNode cur) {
        if (cur.left == null) {
            // 1. 待删除的节点的左子树为 null
            if (cur == root) {
                // 1.1 待删除节点正是根节点
                root = cur.right;
            } else if (cur == parent.left) {
                // 1.2 待删除节点不是树根，且是父亲的左子树
                parent.left = cur.right;
            } else if (cur == parent.right) {
                // 1.3 待删除节点不是树根，且是父亲的右子树
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            // 2. 待删除节点的右子树为 null
            if (cur == root) {
                // 2.1 待删除节点正是根节点
                root = cur.left;
            } else if (cur == parent.left) {
                // 2.2 待删除节点不是根节点, 且为父亲的左子树
                parent.left = cur.left;
            } else if (cur == parent.right) {
                // 2.3 待删除节点不是根节点, 且为父亲的右子树
                parent.right = cur.left;
            }
        } else {
            // 3. 左右子树都存在的情况
            // 需要在 cur 的右子树中找到最小值（或者在 cur 的左子树中找到最大值）
            // 作为替罪羊节点，把替罪羊节点的 key，value 赋值给待删除节点
            // 删除替罪羊节点即可
            BinaryNode goat = cur.right;
            BinaryNode goatParent = cur;
            while (goat.left != null) {
                goatParent = goat;
                goat = goat.left;
            } //该循环结束，就找到了 cur 右子树中的最小值
            cur.key = goat.key;
            cur.value = goat.value;
            // 删除替罪羊节点，根据替罪羊是左右子树，分别采取不同的删除方式
            if (goat == goatParent.left) {
                goatParent.left = goat.right;
            } else {
                goatParent.right = goat.right;
            }
        }
    }
}
