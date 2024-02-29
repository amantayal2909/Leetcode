/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isEvenOddTree(TreeNode* root) {
        queue<TreeNode *> q;
        q.push(root);
        string n1="odd";
        string n2="even";
        int l=0;
        
        while(!q.empty()){
            //TreeNode *t=q.front();
            
            int N=q.size();
            int p=INT_MAX;
            int n=INT_MIN;
            for(int i=0;i<N;i++){
                TreeNode *t=q.front();
                if(l%2==0){
                     if( t->val%2!=0 && n<t->val)
                         n=t->val;
                     else return false;
                }
                if(l%2!=0){
                    if( t->val%2==0 && p>t->val)
                       p=t->val;
                    else return false;
        
                }
                
                if(t->left)q.push(t->left);
                if(t->right)q.push(t->right);
                q.pop();
            }
            l++;
        }
        
        return true;
    }
};