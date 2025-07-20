class Solution {
public:
    vector<vector<int>> generate(int n) {
        vector<vector<int>> v;
        v.push_back({1});
        
        for(int i=1;i<n;i++)
        {
            vector<int> a(i+1,1);
            
            for(int j=1;j<i;j++)
            {
                a[j]= v[i-1][j]+v[i-1][j-1];
            }
            v.push_back(a);
            
        }
        return v;
    }
};