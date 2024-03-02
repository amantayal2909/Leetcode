class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n=nums.size();
        vector<int> ans(n,0);
        int start=0;
        int end=n-1;
        int k=n-1;
        while(start<=end){
            if(abs(nums[start]) >abs(nums[end]))
               {
                   ans[k]=nums[start]*nums[start];
                   start++;
               }
               else
               {
                  ans[k]=nums[end]*nums[end];
                   end--; 
               }
               k--;
        }
        return ans;       
    }
};