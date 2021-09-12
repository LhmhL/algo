package bstree;

import java.util.ArrayList;
import java.util.List;

public class BSTreeR<E extends Comparable<E>> {
    private class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(E data) {
            this.data = data;
            left = right = null;
        }
    }

    private TreeNode root;
    private int size;

    public BSTreeR() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
        root = removeMin(root);
        return res;
    }

    // 删除以 node 为根节点的子树的最小节点
    // 并返回删除完最小节点的子树的根节点
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        TreeNode leftRoot = removeMin(node.left);
        node.left = leftRoot;

        return node;
    }

    // 时间复杂度：O(logn)
    public E removeMax() {
        E res = maxValue();
        root = removeMax(root);
        return res;
    }

    // 删除以 node 为根节点的子树的最大节点
    // 并返回删除完最大节点的子树的根节点
    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) {
            TreeNode leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        TreeNode rightRoot = removeMax(node.right);
        node.right = rightRoot;

        return node;
    }

    // 时间复杂度：O(logn)
    public void remove(E e) {
        root = remove(root, e);
    }

    // 在以 node 为根节点的子树中删除节点 e
    // 并且返回删除后的子树的根节点
    private TreeNode remove(TreeNode node, E e) {
        if (node == null) return null;

        if (e.compareTo(node.data) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.data) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 要删除的节点就是 node
            if (node.left == null) {
                TreeNode rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                TreeNode leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // node 的 left 和 right 都不为空
            TreeNode successor = minValue(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            size--;
            return successor;
        }
    }
}
