package src.com.linklist;

public class CheckCircularLIst {
    public static class Node{
        private String data;
        private Node next;

        public Node(String data, Node next){
            this.data = data;
            this.next = next;
        }

        public String getData(){
            return this.data;
        }

        public Node getNext(){
            return this.next;
        }
    }

    static boolean isCircularList(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                if(slow == head) {
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node("1", null);
        head.next = new Node("2", null);
        head.next.next = new Node("3", null);
        head.next.next.next = new Node("4", null);

        System.out.print(isCircularList(head)? "Yes\n" :
                "No\n" );

        // Making linked list circular
        head.next.next.next.next = head;

        System.out.print(isCircularList(head)? "Yes\n" :
                "No\n" );
    }
}

