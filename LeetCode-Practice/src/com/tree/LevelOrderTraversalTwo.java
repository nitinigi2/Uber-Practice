package src.com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalTwo {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            addCurrentLevelNodesToList(queue, size, ans);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }

    public void addCurrentLevelNodesToList(Queue<TreeNode> queue, int size, List<List<Integer>> ans) {
        List<TreeNode> tempList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        tempList.addAll(queue);
        for(int i=0;i<size;i++){
            list.add(tempList.get(i).val);
        }
        ans.add(0, list);
    }
}
