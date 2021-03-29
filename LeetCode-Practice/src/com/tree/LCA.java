package src.com.tree;

import java.util.ArrayList;
import java.util.List;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        int i=0,j=0;

        findPath(root, p, path1);
        findPath(root, q, path2);

        for(i=0,j=0;i<path1.size() && j<path2.size(); i++,j++){
            if(path1.get(i).val != path2.get(j).val){
                break;
            }
        }

        return path1.get(i-1);
    }

    public boolean findPath(TreeNode root, TreeNode n1, List<TreeNode> path){
        if(root == null) return false;

        path.add(root);

        if(root == n1){
            return true;
        }

        if(root.left != null && findPath(root.left, n1, path)){
            return true;
        }

        if(root.right != null && findPath(root.right, n1, path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}
