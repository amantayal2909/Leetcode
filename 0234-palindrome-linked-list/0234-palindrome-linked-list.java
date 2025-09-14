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
    public boolean isPalindrome(ListNode head) {
        ListNode mid= middle(head);
        ListNode t2 = reverseList(mid);
        ListNode t1 = head;

        while(t1!= null && t2!= null){
            if(t1.val!=t2.val)return false;
            t1=t1.next;
            t2=t2.next;
        }
        return true;
        
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head;

        while(curr!= null){
            temp = curr.next;
            curr.next= prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static ListNode middle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
        }
        return slow;
    }
}