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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head, temp = head;

        while(temp != null){
            curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }

        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newhead = slow;

        newhead = reverse(newhead);

        int maxsum = Integer.MIN_VALUE;

        while(newhead != null && head != null){
            long sum = newhead.val + head.val;
            maxsum = Math.max((int)sum, maxsum);
            newhead= newhead.next;
            head=head.next;
        }

        return maxsum;
    }
}