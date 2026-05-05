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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)return head;
        int l = 0;
        ListNode curr = head, prev = null;
        while(curr!= null){
            l++;
            prev = curr;
            curr = curr.next;
        }
        int rotate = k % l;
        rotate = l - rotate;

        curr = head;
        prev.next = head;
        ListNode next_n = null;
        int count = 0;
        while(count<rotate){
            next_n = curr;
            curr = curr.next;
            count ++;
        }

        head = curr;
        next_n.next = null;
        return head;
        
    }
}