package btree.train;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _226_InvertBinaryTree {
    // BFS 层序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            // 翻转 curr 的左右子树
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return root;
    }

    // DFS 递归
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        // 递归调用翻转左子树,并返回左子树的根节点
        TreeNode left = invertTree2(root.left);
        // 递归调用翻转右子树,并返回右子树的根节点
        TreeNode right = invertTree2(root.right);

        // 翻转当前的节点
        root.left = right;
        root.right = left;

        return root;
    }

    // DFS 递归
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        // 递归调用翻转左子树
        invertTree2(root.left);
        // 递归调用翻转右子树
        invertTree2(root.right);

        // 翻转当前的节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

    // DFS 前序遍历
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            // 翻转 curr 的左右子树
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return root;
    }
}
