class Solution {
public:
    int maxProduct(vector<int>& nums) {
       int n= nums.size();
       int pref =1;
       int ans = INT_MIN;

       for(int i=0;i<n;i++){
        pref = pref * nums[i];
        ans = max(ans,pref);
        if(pref == 0)pref = 1;
       } 

       int suffix=1;
       for(int i=n-1;i>=0;i--){
        suffix = suffix * nums[i];
        ans = max(ans,suffix);
        if(suffix == 0)suffix = 1;
       } 

       return ans;

    }
};