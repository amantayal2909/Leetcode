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
    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode temp =  head;
        ListNode prev = null;

        while(curr!= null){
            temp = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = temp;
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int count = 0;
        ListNode curr = head;
        ListNode temp = head;
        while (count < k &&  curr != null){
            temp = curr;
            curr = curr.next;
            count ++;
        }
        if(count<k)return head;
        temp.next = null;
        ListNode start = reverse(head);  
        ListNode nextgroup = reverseKGroup(curr, k);
        head.next = nextgroup;
        head = start;

        return head;

    }
}