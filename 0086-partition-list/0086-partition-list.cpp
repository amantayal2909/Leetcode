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
    ListNode* partition(ListNode* head, int x) {
        if(head==NULL || head->next==NULL )return head;
        ListNode *dum1=new ListNode(-1);
        ListNode *dum2=new ListNode(-1);

        ListNode *l=dum1;
        ListNode *g=dum2;
        
        ListNode *c=head;
        
        while(c){
            if(c->val<x){
                l->next=c;
                l=l->next;
            }
            else
            {
                g->next=c;
                g=g->next;
            }
            c=c->next;
        }
        l->next=NULL;
        g->next=NULL;
        if(dum1->next==NULL)return dum2->next;
        l->next=dum2->next;
        
        return dum1->next;
    }
};