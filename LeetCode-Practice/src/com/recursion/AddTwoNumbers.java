package src.com.recursion;

//https://leetcode.com/problems/add-two-numbers/submissions/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode headOfAns = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;

        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(sum % 10);
                headOfAns = ans;
            } else {
                ans.next = new ListNode(sum % 10);
                //System.out.println(sum%10);
                ans = ans.next;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int sum = (curr1.val + carry);
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int sum = (curr2.val + carry);
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            curr2 = curr2.next;
        }

        if (carry != 0) {
            ans.next = new ListNode(carry);
        }

        return headOfAns;
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
