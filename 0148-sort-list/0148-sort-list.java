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
    public ListNode middle(ListNode head){
        ListNode slow =head, fast = head, prev = null;
        while(fast!= null && fast.next!= null){
            prev = slow;
            slow =slow.next;
            fast= fast.next.next;
        }
        return prev;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode mid = middle(head);
        ListNode head2 = mid.next;
        mid.next = null;

        head = sortList(head);
        head2 = sortList(head2);

        head = mergetwosorted(head, head2);
        return head;
    }
    public ListNode mergetwosorted(ListNode head, ListNode head2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode t1=head, t2=head2;

        while(t1!=null && t2!=null){
            if(t1.val < t2.val){
                prev.next = t1;
                prev = t1;
                t1= t1.next;
            }
            else{
                prev.next = t2;
                prev = t2;
                t2= t2.next;
            }
        }
        if(t1!=null)prev.next = t1;
        if(t2!=null)prev.next = t2;

        return dummy.next;
    }
}