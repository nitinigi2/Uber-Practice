package src.com.GS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem {

    static class BST {
        private Node root;

        public BST() {
            this.root = null;
        }

        public void put(int value) {
            if (root == null) {
                root = new Node(value);
                return;
            }
            root = insertRec(root, value);
        }

        public Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }
            if (root.val > value) {
                root.left = insertRec(root.left, value);
            } else if (root.val < value) {
                root.right = insertRec(root.right, value);
            }
            return root;
        }

        public boolean contains(int value) {
            Node temp = root;
            if (temp == null) {
                return false;
            }
            while (temp != null && temp.val != value) {
                if (temp.val > value) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            return temp != null && temp.val == value;
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left, acc);
            acc.add(node.val);
            inOrderTraversal(node.right, acc);
        }

        private static class Node {
            int val;
            Node left;
            Node right;

            public Node(int val) {
                this.val = val;
            }

            public Node() {

            }
        }
    }

    public static void testBST() {
        final BST searchTree = new BST();
        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);
        assertFalse(searchTree.contains(0));
        assertTrue(searchTree.contains(1));
        assertTrue(searchTree.contains(5));
        assertFalse(searchTree.contains(6));
        assertEquals(Arrays.asList(1, 2, 3, 5), searchTree.inOrderTraversal());
    }

    private static void assertFalse(boolean rez) {
        if (rez) {
            throw new RuntimeException("Test failed");
        } else {
            System.out.println("Test passed");
        }
    }

    private static void assertTrue(boolean rez) {
        if (!rez) {
            throw new RuntimeException("Test failed");
        } else {
            System.out.println("Test passed");
        }
    }

    private static void assertEquals(List<Integer> expected, List<Integer> result) {
        if (!expected.equals(result)) {
            System.out.println(String.format("Test failed \"%s\" not equeals to \"%s\"", expected, result));
        } else {
            System.out.println("Test passed");
        }
    }

    // TODO: write some more tests
    public static void main(String[] args) {
        testBST();
    }

}
