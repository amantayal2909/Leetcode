class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customer) {
        long long int chef=customer[0][0];
        long long int ans=0;
        int n=customer.size();

        for(int i=0;i<customer.size();i++){
            int arr=customer[i][0];
            int time=customer[i][1];
            
            if(arr>chef)
            chef=arr;

            chef+= time;
            ans +=(chef-arr);
        }

        return (double)ans/n;
    }
};