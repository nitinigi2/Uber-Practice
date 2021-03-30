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

    // 2, -1, 5, 1

    // 2, -1, 5 => [2, -1], [5] => [2, -1] =>
    // 1
    public static Node mergeSort(Node head){
        if(head == null || head.next == null) return head;
        Node mid = findMid(head);
        Node nextOfMiddle = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = merge(left, right);

        return sortedList;
    }

    private static Node merge(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;
        Node last = null;
        Node ans = last;
        while(curr1 != null && curr2 != null){
            Node newNode = null;
            if(curr1.data < curr2.data){
                newNode = new Node(curr1.data);
                curr1 = curr1.next;
            }else{
                newNode = new Node(curr2.data);
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
            Node newNode = new Node(curr1.data);
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
            Node newNode = new Node(curr2.data);
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

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(-1);
        l1.next.next = new Node(5);
        l1.next.next.next = new Node(1);
        bubbleSort(l1);
        System.out.println("Bubble sort: ");
        printList(l1);

        Node l2 = new Node(4);
        l2.next = new Node(-1);
        l2.next.next = new Node(10);
        l2.next.next.next = new Node(0);
        Node mergedNode = mergeSort(l2);
        System.out.println("Merge sort: ");
        printList(mergedNode);
    }

    public static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
