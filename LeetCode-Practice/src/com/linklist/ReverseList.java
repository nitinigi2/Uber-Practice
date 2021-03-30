package src.com.linklist;

public class ReverseList {
    // recursive solution
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null) return head;
        SinglyLinkedListNode rev = reverse(head.next);
        head.next.next = head;

        head.next = null;

        return rev;
    }

    // iterative solution
    static SinglyLinkedListNode reverseIterative(SinglyLinkedListNode head) {
        SinglyLinkedListNode curr = head;
        SinglyLinkedListNode prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data){
        this.data = data;
    }
}
