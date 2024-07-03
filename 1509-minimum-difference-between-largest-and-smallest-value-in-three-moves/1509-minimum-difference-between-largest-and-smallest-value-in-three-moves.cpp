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
                cout<<i<<j<<endl;
                j--;
            }
            
        }

    return diff;
    }
};

//0 1 5 8 10 14
//  1 4 3  2  4
//20 75 81 82 83 95
//20 75 81 82 95
