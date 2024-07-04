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
    ListNode* mergeNodes(ListNode* head) {
    

    ListNode *cur=head->next;
    ListNode *dummy= new ListNode(-1);
    ListNode *prev=dummy;
    int sum=0;

    while(cur) {
    if(cur->val==0){
        ListNode *a =new ListNode(sum);
        sum=0;
        prev->next=a;
        prev=a;
        
    } 
    sum=sum+ cur->val;
    cur=cur->next;  
    }

    return dummy->next;
    }
};