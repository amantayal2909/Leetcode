class Solution {
public:
    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<vector<int>> ans (m,vector<int>(n));
        int mod = 12345;

        int pref =1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=pref;
                pref = ((long long)pref * grid[i][j])%mod;
            }
        }

        int suff = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                ans[i][j]=((long long) ans[i][j]*suff) %mod;
                suff = ((long long)suff * grid[i][j])%mod;
            }
        }

        return ans;




    }
};