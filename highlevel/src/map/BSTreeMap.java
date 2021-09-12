package map;

import java.util.*;

/*
    有序的 Map
 */
public class BSTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class TreeNode {
        K key;
        V value;
        TreeNode left;
        TreeNode right;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private TreeNode root;
    private int size;

    public BSTreeMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) { // O(logn)
        root = add(root, key, value);
    }

    private TreeNode add(TreeNode node, K key, V value) {
        // 1. 递归终止条件
        if (node == null) {
            size++;
            return new TreeNode(key, value);
        }
        // 2. 递归调用
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else { // 键值对已经存在，那么更新 value
            node.value = value;
        }
        return node;
    }

    private TreeNode minValue(TreeNode node) { // O(logn)
        if (node.left == null) return node;
        return minValue(node.left);
    }

    private TreeNode removeMin(TreeNode node) { // O(logn)
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

    @Override
    public V remove(K key) { // O(logn)
        TreeNode node = getNode(root, key);
        if (node == null) return null;
        root = remove(root, key);
        return node.value;
    }

    private TreeNode remove(TreeNode node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
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

    @Override
    public void set(K key, V newValue) { // O(logn)
        TreeNode node = getNode(root, key);
        if (node != null) {
            node.value = newValue;
        } else {
            throw new NoSuchElementException("没有对应的 key ：" + key);
        }
    }

    @Override
    public V get(K key) { // O(logn)
        TreeNode node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private TreeNode getNode(TreeNode node, K key) { // O(logn)
        if (node == null) return null;
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public boolean containsKey(K key) { // O(logn)
        TreeNode node = getNode(root, key);
        return node != null;
    }

    public List<K> getAllKeys() {
        List<K> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, List<K> res) {
        if (node == null) return;
        inOrder(node.left, res);
        res.add(node.key);
        inOrder(node.right, res);
    }

    public static void main(String[] args) {
        BSTreeMap<Integer, Integer> map = new BSTreeMap<>();
        map.add(2,1);
        map.add(1,2);
        map.add(9,3);
        map.add(5,4);
        map.add(2,5);
        System.out.println(map.getAllKeys());
    }
}
