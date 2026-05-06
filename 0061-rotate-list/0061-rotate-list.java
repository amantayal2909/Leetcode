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
        if(head == null || head.next == null )return head;
        
        ListNode curr = head;
        ListNode prev = null;
        int length = 0;

        while(curr!=null){
            length ++;
            prev=curr;
            curr=curr.next;
        }
        
        int rotate = k % length;
        if(rotate == 0)return head;
        rotate = length - rotate;

        prev.next = head;

        curr = head;
        ListNode temp = null;

        while(rotate>0){

            temp = curr;
            curr = curr.next;
            rotate--;

        }
        head = curr;
        temp.next=null;


        return head;
        
    }
}