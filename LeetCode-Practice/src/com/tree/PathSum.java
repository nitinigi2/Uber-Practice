package src.com.tree;

// https://leetcode.com/problems/path-sum/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        if(root.left == null && root.right == null && root.val - targetSum == 0) return true;

        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
