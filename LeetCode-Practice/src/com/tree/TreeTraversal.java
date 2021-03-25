package src.com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    // iterative preorder traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return ans;
    }

    // iterative inorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){

            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }

        return ans;
    }

    // Add iterative solution of postorder
}
