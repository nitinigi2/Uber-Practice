package src.com.linklist;

// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
public class MergeLists {

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode curr1 = head1;
        SinglyLinkedListNode curr2 = head2;
        SinglyLinkedListNode last = null;
        SinglyLinkedListNode ans = last;
        while(curr1 != null && curr2 != null){
            SinglyLinkedListNode newNode = null;
            if(curr1.data < curr2.data){
                newNode = new SinglyLinkedListNode(curr1.data);
                curr1 = curr1.next;
            }else{
                newNode = new SinglyLinkedListNode(curr2.data);
                curr2 = curr2.next;
            }
            if(last == null){
                last = newNode;
                ans = last;
            }else{
                last.next = newNode;
                last = last.next;
            }
        }

        while(curr1 != null){
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(curr1.data);
            if(last == null){
                last = newNode;
                ans = last;
            }else{
                last.next = newNode;
                last = last.next;
            }
            curr1 = curr1.next;
        }

        while(curr2 != null){
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(curr2.data);
            if(last == null){
                last = newNode;
                ans = last;
            }else{
                last.next = newNode;
                last = last.next;
            }
            curr2 = curr2.next;
        }

        return ans;
    }
}
