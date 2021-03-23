package src.com.tree;


// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isChildSymmetric(root.left, root.right);
    }

    public boolean isChildSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return node1.val == node2.val && isChildSymmetric(node1.left, node2.right) && isChildSymmetric(node1.right, node2.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}