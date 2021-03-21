package src.com.recursion;
//https://leetcode.com/problems/validate-binary-search-tree/submissions/
public class ValidateBinaryTree {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root != null){
            if(!isValidBST(root.left)) return false;
            if(prev == null){
                prev = root;
            }else{
                if(prev.val >= root.val) return false;
                prev = root;
            }
            return isValidBST(root.right);
        }
        return true;
    }
}

