package src.com.linklist;

public class InsertionDeletionInDoublyLinkedList {
    public static class Node {
        private String data;
        private Node next;
        private Node prev;

        public Node() {

        }

        public Node(String data, Node prev, Node next) {
            this.data = data;
            this.next = prev;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }
    }

    static Node head;

    public void insert(Node root, String value, int index) {
        if (index < 0) return;
        Node newNode = new Node(value, null, null);
        // insertion at front
        if (index == 0) {
            newNode.next = root;
            if (root != null)
                root.prev = newNode;
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null && index > 1) {
            curr = curr.next;
            index--;
        }
        // index is greater than list size
        if (curr.next == null && index > 1) {
            System.out.println("Invalid insertion index");
            return;
        }

        newNode.next = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
        if (newNode.next != null)
            newNode.next.prev = newNode;
    }

    public void delete(Node root, int index) {
        if (index < 0) {
            System.out.println("Invalid");
        }
        Node curr = root;

        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }

        if(root == curr){
            head = root.next;
            return;
        }
        if(curr == null){
            System.out.println("Invalid deletion index");
            return;
        }
        curr.prev.next = curr.next;
    }

    public static void printList(Node head) {
        //System.out.println("head: " + head);
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        InsertionDeletionInDoublyLinkedList list = new InsertionDeletionInDoublyLinkedList();
        list.insert(head, "10", 0);
        list.insert(head, "20", 1);
        list.delete(head, 1);
        printList(head);
    }
}
