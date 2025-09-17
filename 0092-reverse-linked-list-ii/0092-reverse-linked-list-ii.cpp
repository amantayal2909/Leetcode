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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if(head==NULL || head->next==NULL || left==right)return head;
        int count=1;
        ListNode *l=head,*r,*p=NULL,*t,*n;
        while(count<left){
            p=l;
            l=l->next;
            count++;
        }
        r=l;
        while(count<right){
            r=r->next;
            count++;
        }
        n=r->next;
        r->next=NULL;
        ListNode *left1=reverse(l);
        
        if(p==NULL)head=left1;
        else
            p->next=left1;
        l->next=n;
        return head;
    }
};