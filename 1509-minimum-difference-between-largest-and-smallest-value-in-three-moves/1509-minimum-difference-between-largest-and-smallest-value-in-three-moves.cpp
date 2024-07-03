class Solution {
public:
    int minDifference(vector<int>& nums) {
        int n=nums.size();
        if(n<=4)return 0;

        sort(nums.begin(),nums.end());

        int diff=INT_MAX;
        for(int i=4; i>=1;i--){
            int j=4-i;
            while(j>=0){
                diff=min(diff,nums[n-i]-nums[j]);
                j--;
            }
            
        }

    return diff;
    }
};


