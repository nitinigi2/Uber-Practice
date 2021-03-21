package src.com.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/submissions/
public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            boolean isRightMost = true;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (isRightMost) {
                    ans.add(current.val);
                    isRightMost = false;
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
            }
        }
        return ans;
    }
}
