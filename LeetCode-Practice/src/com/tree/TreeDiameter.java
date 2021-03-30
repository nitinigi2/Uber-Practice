package src.com.tree;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class TreeDiameter {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return Math.max(lHeight + rHeight, max);
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
