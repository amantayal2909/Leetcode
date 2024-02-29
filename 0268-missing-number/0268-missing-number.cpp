// class Solution {
// public:
//     int missingNumber(vector<int>& arr) {
//          int n=arr.size();
//         int sum=(n*(n+1))/2;
//         for(int i=0;i<n;i++)
//         {
//             sum-=arr[i];
//         }
//         return sum;
//     }
// };


class Solution {
public:
    int missingNumber(vector<int>& arr) {
         int n=arr.size();
        int ans=0;
        for(int i=0;i<n;i++)
        {
           ans^=(i^arr[i]); 
        }
        return ans^n;
    }
};