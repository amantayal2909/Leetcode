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
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        ListNode *cur=head;
        ListNode *prev=NULL,*tail=cur->next;

        vector<int> a;
        a.push_back(0);
        int mini=INT_MAX;
        int i=1;int j=0;

        while(cur){
            tail=cur->next;
            if(prev!=NULL && tail && prev->val < cur->val && cur->val > tail->val){
               a.push_back(i); 
               mini=j>0?min(mini,a[j+1]-a[j]):mini;
               j++;
               
            }
            else if(prev && tail && prev->val > cur->val && cur->val < tail->val){
               a.push_back(i);
               mini=j>0?min(mini,a[j+1]-a[j]):mini;
               j++;
               
            }
            prev=cur;
            cur=cur->next;
            i++;
            
        }
            int n=a.size();
            if(n<=2)return {-1,-1};
           
            return {mini,a[n-1]-a[1]};
    }
};