package btree.train;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _104_MaximumDepthOfBinaryTree {
    // DFS 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        int maxDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;
        return maxDepth;
    }

    // BFS 层序遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每轮循环遍历处理一层的节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                // 将遍历处理的节点的左右子节点入队，等到后序的处理
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }

    private class Node {
        TreeNode node;
        int depth;

        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // DFS 前序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, 1));
        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            TreeNode node = currNode.node;
            int currDepth = currNode.depth;
            // 求最大深度
            maxDepth = Math.max(maxDepth, currDepth);
            if (node.right != null) {
                stack.push(new Node(node.right, currDepth + 1));
            }
            if (node.left != null) {
                stack.push(new Node(node.left, currDepth + 1));
            }
        }
        return maxDepth;
    }
}
