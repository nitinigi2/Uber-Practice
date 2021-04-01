package src.com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BST {

    // https://leetcode.com/problems/insert-into-a-binary-search-tree/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }else{
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    // https://leetcode.com/problems/convert-bst-to-greater-tree/
    public TreeNode convertToGreaterTree(TreeNode root){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int prevSum = 0;
        inorder(root, list);
        for(int i=list.size()-1;i>=0;i--){
            map.put(list.get(i), list.get(i) + prevSum);
            prevSum += list.get(i);
        }
        //System.out.println(list);
        convertTree(root, map);
        return root;
    }

    public void convertTree(TreeNode root, Map<Integer, Integer> map){
        if(root == null){
            return;
        }

        root.val = map.get(root.val);

        convertTree(root.left, map);
        convertTree(root.right, map);
    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root != null){
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
