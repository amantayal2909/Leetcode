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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode prev = head;
        ListNode curr = head;
        ListNode temp = head;

        while(curr!= null  && curr.next != null)
        {
            if( curr.val == curr.next.val){
                curr=curr.next;
            }
            else if( curr.val != curr.next.val ){
                temp.next=curr.next;
                temp= temp.next;
                curr=curr.next;

            }
        }
        temp.next = null;

        return head;




    }
}