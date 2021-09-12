package avltree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<E extends Comparable<E>> {
    private class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;
        int height = 1;

        public TreeNode(E data) {
            this.data = data;
            left = right = null;
        }
    }

    private TreeNode root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }

    private int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        // 平衡因子等于左右子节点的高度差
        return getHeight(node.left) - getHeight(node.right);
    }

    // 判断一棵二叉树是否是二叉查找树
    public boolean isBSTree() {
        // 先中序遍历二叉查找树，得到遍历的结果列表
        List<E> res = inOrder();
        int len = res.size();
        if (len <= 1) {
            return true;
        }
        // 然后判断结果列表是否是增序排列的
        for (int i = 1; i < len; i++) {
            if (res.get(i).compareTo(res.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    // 判断一棵二叉查找树是否是平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null) return true;
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    // 对节点 y 进行向右旋转操作，返回旋转后新的根节点 x
    //        y                                    x
    //       / \                                 /   \
    //      x   T4        向右旋转 (y)          z       y
    //     / \          --------------->      / \     / \
    //    z   T3                            T1   T2 T3   T4
    //   / \
    // T1   T2
    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode t3 = x.right;

        // 右旋转
        x.right = y;
        y.left = t3;

        // 更新 x 和 y 的高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        // 返回调整之后的根节点
        return x;
    }

    // 对节点 y 进行向左旋转操作，返回旋转后新的根节点 x
    //    y                             x
    //  /  \                          /   \
    // T4   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T3  z                     T4 T3 T1 T2
    //      / \
    //     T1 T2
    private TreeNode leftRotate(TreeNode y) {
        TreeNode x = y.right;
        TreeNode t3 = x.left;

        // 左旋转
        x.left = y;
        y.right = t3;

        // 更新 x 和 y 的高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        // 返回调整之后的根节点
        return x;
    }

    /*************************插入操作*******************************/
    // 时间复杂度：O(logn)
    public void add(E e) {
        root = add(root, e);
    }

    // 将节点 e 插入到以 node 为根节点的子树当中
    // 并返回插入节点后的二叉查找树的根节点
    private TreeNode add(TreeNode node, E e) {
        // 1. 递归终止条件
        if (node == null) {
            size++;
            return new TreeNode(e);
        }
        // 2. 递归调用
        if (e.compareTo(node.data) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.data) > 0){
            node.right = add(node.right, e);
        }

        // 平衡维护(node)
        // 更新父亲节点的高度值
        // 父亲节点的高度值等于左右子节点最大的高度值再加上 1
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        // 计算每个父亲节点的平衡因子
        int balanceFactor = getBalanceFactor(node);
        // LL型
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            // 处理左边不平衡，进行右旋转
            return rightRotate(node);
        }
        // RR型
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            // 处理右边不平衡，进行左旋转
            return leftRotate(node);
        }
        // LR型
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            // 先将 node.left 进行左旋，转成 LL型
            node.left = leftRotate(node.left);
            // 然后对 node 进行右旋
            return rightRotate(node);
        }
        // RL型
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            // 先将 node.right 进行右旋，转成 RR型
            node.right = rightRotate(node.right);
            // 再将 node 进行左旋
            return leftRotate(node);
        }
        return node;
    }

    // 时间复杂度：O(logn)
    public void add1(E e) {
        if (root == null) {
            root = new TreeNode(e);
        } else {
           add1(root, e);
        }
    }

    // 将节点 e 插入到以 node 为根节点的子树当中
    private void add1(TreeNode node, E e) {
        // 1. 递归终止条件
        if (e.compareTo(node.data) == 0) {
            return;
        } else if (e.compareTo(node.data) < 0 && node.left == null) {
            node.left = new TreeNode(e);
            size++;
            return;
        } else if (e.compareTo(node.data) > 0 && node.right == null) {
            node.right = new TreeNode(e);
            size++;
            return;
        }
        // 2. 递归调用
        if (e.compareTo(node.data) < 0) {
            add1(node.left, e);
        } else {
            add1(node.right, e);
        }
    }

    /*************************修改操作*******************************/
    // set 方法会破坏二叉查找树的性质
    /*public void set(E src, E target) {
        if (contains(target)) return;
        TreeNode srcNode = find(src);
        srcNode.data = target;
    }*/

    /*************************查询操作*******************************/
    public boolean contains(E target) {
        TreeNode node = find(target);
        return node != null;
    }

    // 时间复杂度：O(logn)
    public TreeNode find(E target) {
        return find(root, target);
    }

    private TreeNode find(TreeNode node, E target) {
        if (node == null) return null;
        if (target.compareTo(node.data) == 0) {
            return node;
        } else if (target.compareTo(node.data) < 0) {
            return find(node.left, target);
        } else {
            return find(node.right, target);
        }
    }

    // 前序遍历
    public List<E> preOrder() {
        List<E> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode node, List<E> res) {
        if (node == null) return;
        res.add(node.data);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    // 中序遍历
    public List<E> inOrder() {
        List<E> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, List<E> res) {
        if (node == null) return;
        inOrder(node.left, res);
        res.add(node.data);
        inOrder(node.right, res);
    }

    // 后序遍历
    public List<E> postOrder() {
        List<E> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode node, List<E> res) {
        if (node == null) return;
        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.data);
    }

    // 时间复杂度：O(logn)
    public E minValue() {
        if (root == null) {
            throw new RuntimeException("tree is null");
        }
        return minValue(root).data;
    }

    private TreeNode minValue(TreeNode node) {
        if (node.left == null) return node;
        return minValue(node.left);
    }

    // 时间复杂度：O(logn)
    public E maxValue() {
        if (root == null) {
            throw new RuntimeException("tree is null");
        }
        return maxValue(root).data;
    }
    private TreeNode maxValue(TreeNode node) {
        if (node.right == null) return node;
        return maxValue(node.right);
    }

    /*************************删除操作*******************************/
    // 时间复杂度：O(logn)
    public E removeMin() {
        E res = minValue();
        root = remove(root, res);
        return res;
    }

    // 时间复杂度：O(logn)
    public E removeMax() {
        E res = maxValue();
        root = remove(root, res);
        return res;
    }

    // 时间复杂度：O(logn)
    public void remove(E e) {
        root = remove(root, e);
    }

    // 在以 node 为根节点的子树中删除节点 e
    // 并且返回删除后的子树的根节点
    private TreeNode remove(TreeNode node, E e) {
        if (node == null) return null;

        TreeNode retNode;
        if (e.compareTo(node.data) < 0) {
            node.left = remove(node.left, e);
            retNode = node;
        } else if (e.compareTo(node.data) > 0) {
            node.right = remove(node.right, e);
            retNode = node;
        } else {
            // 要删除的节点就是 node
            if (node.left == null) {
                TreeNode rightNode = node.right;
                node.right = null;
                size--;
                // 注意：这里其实可以直接返回 retNode 的
                // 因为右子树是已经平衡了的，不需要再调整了
                // 这里不直接返回，是为了统一对 retNode 的处理
                retNode = rightNode;
            } else if (node.right == null) {
                TreeNode leftNode = node.left;
                node.left = null;
                size--;
                // 注意：这里其实可以直接返回 retNode 的
                // 因为左子树是已经平衡了的，不需要再调整了
                // 这里不直接返回，是为了统一对 retNode 的处理
                retNode = leftNode;
            } else {
                // node 的 left 和 right 都不为空
                TreeNode successor = minValue(node.right);
                successor.right = remove(node.right, successor.data);
                successor.left = node.left;
                node.left = null;
                node.right = null;
                // 因为递归 remove 中已经进行了 size-- 了，所以这里不需要了
                // size--;
                retNode = successor;
            }
        }

        if (retNode == null) return null;
        // 平衡维护(retNode)
        // 更新父亲节点的高度值
        // 父亲节点的高度值等于左右子节点最大的高度值再加上 1
        retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;
        // 计算每个父亲节点的平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        // LL型
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            // 处理左边不平衡，进行右旋转
            return rightRotate(retNode);
        }
        // RR型
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            // 处理右边不平衡，进行左旋转
            return leftRotate(retNode);
        }
        // LR型
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            // 先将 retNode.left 进行左旋，转成 LL型
            retNode.left = leftRotate(retNode.left);
            // 然后对 retNode 进行右旋
            return rightRotate(retNode);
        }
        // RL型
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            // 先将 retNode.right 进行右旋，转成 RR型
            retNode.right = rightRotate(retNode.right);
            // 再将 retNode 进行左旋
            return leftRotate(retNode);
        }
        return retNode;
    }
}
