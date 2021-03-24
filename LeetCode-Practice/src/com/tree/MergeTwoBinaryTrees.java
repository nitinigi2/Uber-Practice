package src.com.tree;
// https://leetcode.com/problems/merge-two-binary-trees/
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;

        int firstTreeNode = root1 == null ? 0 : root1.val;
        int secondTreeNode = root2 == null ? 0 : root2.val;

        TreeNode mergedNode = new TreeNode(firstTreeNode + secondTreeNode);

        mergedNode.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        mergedNode.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return mergedNode;
    }
}
