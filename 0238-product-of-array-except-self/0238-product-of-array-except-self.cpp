class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int m = nums.size();
        vector<int> ans(m);

        int pref =1;
        int suff =1;
        for(int i=0;i<m;i++){
            ans[i]=pref;
            pref = pref*nums[i];
        }

        for(int i=m-1;i>=0;i--){
            ans[i]=ans[i]*suff;
            suff = suff*nums[i];
        }
        return ans;

    }
};