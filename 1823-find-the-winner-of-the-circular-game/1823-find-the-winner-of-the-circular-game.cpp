
  
 
class Solution {
public:
    int findTheWinner(int n, int k) {
        ListNode *head=new ListNode(1);
        ListNode *tail=head;

        for(int i=2;i<=n;i++){
          ListNode *n=new ListNode(i);
          tail->next=n;
          tail=n;
        }
        tail->next=head;

        while(head->next!=head){


           ListNode *t=head;
           ListNode *p=tail;
           int c=k;
            while(c-1){
            p=t;
            t=t->next;
            c--;
            }

            p->next=t->next;
            t=p->next;
            head=t;
        }
        return head->val;
        
    }
};