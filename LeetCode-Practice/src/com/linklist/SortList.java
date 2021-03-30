package src.com.linklist;

public class SortList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void bubbleSort(Node head){
        int n = 0;
        Node curr = head;
        while(curr != null) {
            curr = curr.next;
            n++;
        }
        Node slow = head;
        while(slow != null){
            Node fast = head;
            while(fast != null && fast.next != null){
                if(fast.data > fast.next.data){
                    int temp = fast.data;
                    fast.data = fast.next.data;
                    fast.next.data = temp;
                }
                fast = fast.next;
            }
            slow = slow.next;
        }
    }

    public static void mergeSort(Node head){

    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(-1);
        l1.next.next = new Node(5);
        l1.next.next.next = new Node(1);
        bubbleSort(l1);
        while(l1 != null){
            System.out.println(l1.data);
            l1 = l1.next;
        }
    }
}
