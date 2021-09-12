package map.train;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _653_TwoSumIV {
    // 双指针
    public boolean findTarget1(TreeNode root, int target) {
        if (root == null) return false;
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums); // O(n)
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }
        return false;
    }

    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        nums.add(node.val);
        inOrder(node.right, nums);
    }

    public boolean findTarget(TreeNode root, int target) {
        if (root == null) return false;
        return find(root, target, new HashSet<>());
    }

    private boolean find(TreeNode node, int target, Set<Integer> set) {
        if (node == null) return false;
        if (set.contains(target - node.val)) return true;
        set.add(node.val);
        return find(node.left, target, set) || find(node.right, target, set);
    }
}
