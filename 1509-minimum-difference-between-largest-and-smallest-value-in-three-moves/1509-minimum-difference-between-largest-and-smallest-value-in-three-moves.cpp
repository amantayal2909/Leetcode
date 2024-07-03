class Solution {
public:
    int minDifference(vector<int>& nums) {
        int n=nums.size();
        if(n<=4)return 0;

        sort(nums.begin(),nums.end());

        int a=nums[n-4]-nums[0];
        int b=nums[n-1]-nums[3];
        int c=nums[n-3]-nums[1];
        int d=nums[n-2]-nums[2];

        int e=min(a,b);
        int f=min(c,d);
        return min(e,f);  
        //return min({a,b,c,d});
        
    }
};

//0 1 5 8 10 14
//  1 4 3  2  4
//20 75 81 82 83 95
//20 75 81 82 95
