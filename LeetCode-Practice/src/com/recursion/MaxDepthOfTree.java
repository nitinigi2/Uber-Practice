package src.com.recursion;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
public class MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
