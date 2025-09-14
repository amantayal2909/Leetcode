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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = middle(head);
        ListNode l1 = reverse(mid);

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode temp1, temp2;

        while(head!= null && l1!= null){
            prev.next = head;
            prev = head;
            temp1 = head.next;
            head = head.next;

            prev.next = l1;
            prev = l1;
            temp2 = l1.next;
            l1 = l1.next;

        }

        head = dummy.next;
    }
    public static ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!= null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head;

        while(curr!= null){
            temp =curr.next;
            curr.next= prev;
            prev= curr;
            curr = temp;
        }
        return prev;
    }
}