package src.com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightPointerTree {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return null;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = queue.peek();
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                if(i != 0){
                    prev.next = curr;
                    prev = curr;
                }
            }
            prev.next = null;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
