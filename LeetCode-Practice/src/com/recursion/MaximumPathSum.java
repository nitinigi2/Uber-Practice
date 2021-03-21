package src.com.recursion;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxSum;
    }

    public int findMaxPath(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, findMaxPath(root.left));
        int right = Math.max(0, findMaxPath(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
