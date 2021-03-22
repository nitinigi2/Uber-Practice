package src.com.linklist;

public class ReverseDoublyList {
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

    public static Node reverseList(Node head){
        Node curr = head;
        Node rev = null;
        while (curr != null){
            Node temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            rev = curr;
            curr = curr.prev;
        }
        return rev;
    }

    public static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node("1", null, null);
        head.next = new Node("2", null, null);
        head.next.prev = head;
        head.next.next = new Node("3", null, null);
        head.next.next.prev = head.next;
        Node node = reverseList(head);
        printList(node);
    }

    // [null,1,100] -> [50,2,200] -> [100,3,null]
    //    50              100             200
}
