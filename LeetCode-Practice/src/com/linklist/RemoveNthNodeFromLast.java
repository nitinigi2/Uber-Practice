package src.com.linklist;


public class RemoveNthNodeFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        int indexFromStart = size - n;

        curr = head;
        ListNode prev = null;
        while (curr != null && indexFromStart > 0) {
            prev = curr;
            curr = curr.next;
            indexFromStart--;
        }
        //System.out.println(prev.val + " " + curr.val);
        if (prev != null) {
            prev.next = curr.next;
        } else {
            head = curr.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
