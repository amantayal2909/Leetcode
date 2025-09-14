/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //l1 = reverse(l1);
        //l2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        int sum = 0;

        while(l1!=null && l2!= null){
            sum = l1.val + l2.val + carry;
            carry = 0;
            if(sum>9)carry = 1;
            sum = sum%10;

            ListNode n = new ListNode(sum);
            prev.next = n;
            prev = n;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            sum = l1.val + carry;
            carry = 0;
            if(sum>9)carry = 1;
            sum = sum%10;

            ListNode n = new ListNode(sum);
            prev.next = n;
            prev = n;
            l1 = l1.next;
            
        }
        while( l2!= null){
            sum =  l2.val + carry;
            carry = 0;
            if(sum>9)carry = 1;
            sum = sum%10;

            ListNode n = new ListNode(sum);
            prev.next = n;
            prev = n;
            
            l2 = l2.next;
        }
        if(carry == 1){
            ListNode n = new ListNode(carry);
            prev.next = n;
            prev = n;
        }


        
        return dummy.next;
    }
    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode temp = head;
        ListNode prev = null;

        while(curr!= null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        return prev;
    }
}