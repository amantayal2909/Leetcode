class Solution {
public:
    int minDifference(vector<int>& nums) {
        int n=nums.size();
        if(n<=4)return 0;

        sort(nums.begin(),nums.end());
        int a=nums[n-4]-nums[0];
        int b=nums[n-1]-nums[3];

    return min(a,b);
    }
};

//0 1 5 8 10 14
//  1 4 3  2  4
