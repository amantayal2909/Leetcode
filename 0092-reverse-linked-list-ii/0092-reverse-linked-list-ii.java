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
        ListNode curr = head, temp = head;
        ListNode prev = null;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right)return head;

        int count = 1;
        ListNode left_node = head, left_behind = null;
        ListNode curr = head;

        while(count<left){
            left_behind = curr;
            left_node = curr.next;
            curr = curr.next;
            count ++;
        }
        ListNode right_node = curr, right_after = null;
        
        while(count<=right){
            right_node = curr;
            right_after = curr.next;
            curr = curr.next;
            count++;
        }

        right_node.next = null;
        ListNode h = reverse(left_node);
        
        left_node.next = right_after;

        if(left_behind == null){
          return h;  
        }
        left_behind.next = h;

        return head; 

    }
}