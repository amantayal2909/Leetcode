/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode *reverse(ListNode *h){
        ListNode *p=NULL,*c=h, *n;
        
        while(c){
            n=c->next;
            c->next=p;
            p=c;
            c=n;
        }
        
        return p;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
         if(head==NULL || head->next==NULL || k<2)return head;
        int count=0;
        ListNode *t=head,*p;
        while(t && count<k){
            p=t;
            t=t->next;
            count++;
        }
        if(count !=k)return head;
        p->next=NULL;
        ListNode *head1=reverse(head);
        ListNode *n=reverseKGroup(t,k);
        head->next=n;
        return head1;
    }
};