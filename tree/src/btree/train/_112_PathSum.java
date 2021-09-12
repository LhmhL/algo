package btree.train;

import java.util.Stack;

public class _112_PathSum {
    // DFS 递归
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        sum = sum - root.val;
        //如果当前节点是叶子，检查 sum 值是否为 0，也就是是否找到了给定的目标和。
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        // 如果当前节点不是叶子，对它的所有孩子节点，递归调用 hasPathSum 函数，
        // 其中 sum 值减去当前节点的权值
        boolean hasPathLeft = hasPathSum(root.left, sum);
        boolean hasPathRight = hasPathSum(root.right, sum);

        return hasPathLeft || hasPathRight;
    }

    private class Node2 {
        TreeNode node; // 当前树节点
        int pathRemainSum; // 从根节点到当前节点的路径剩余和
        
        public Node2(TreeNode node, int pathRemainSum) {
            this.node = node;
            this.pathRemainSum = pathRemainSum;
        }
    }

    // DFS 前序遍历
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<Node2> stack = new Stack<>();
        stack.push(new Node2(root, sum - root.val));
        while (!stack.isEmpty()) {
            Node2 node = stack.pop();
            TreeNode currNode = node.node;
            int currPathRemainSum = node.pathRemainSum;
            // 如果当前节点为叶子节点，且当前节点的路径和等于目标和，则直接返回 true
            if (currNode.left == null && currNode.right == null && currPathRemainSum == 0) {
                return true;
            }
            if (currNode.right != null) {
                stack.push(new Node2(currNode.right, currPathRemainSum - currNode.right.val));
            }
            if (currNode.left != null) {
                stack.push(new Node2(currNode.left, currPathRemainSum - currNode.left.val));
            }
        }
        return false;
    }

    private class Node1 {
        TreeNode node; // 当前树节点
        int pathSum; // 从根节点到当前节点的路径和

        public Node1(TreeNode node, int pathSum) {
            this.node = node;
            this.pathSum = pathSum;
        }
    }

    // DFS 前序遍历
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<Node1> stack = new Stack<>();
        stack.push(new Node1(root, root.val));
        while (!stack.isEmpty()) {
            Node1 node = stack.pop();
            TreeNode currNode = node.node;
            int currPathSum = node.pathSum;
            // 如果当前节点为叶子节点，且当前节点的路径和等于目标和，则直接返回 true
            if (currNode.left == null && currNode.right == null && currPathSum == sum) {
                return true;
            }
            if (currNode.right != null) {
                stack.push(new Node1(currNode.right, currPathSum + currNode.right.val));
            }
            if (currNode.left != null) {
                stack.push(new Node1(currNode.left, currPathSum + currNode.left.val));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;
        node2.left = node4;
        node2.right = node5;
        node5.right = node8;

        boolean res = new _112_PathSum().hasPathSum(root, 22);
        System.out.println(res);
    }
}
