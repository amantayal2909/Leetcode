class Solution {
public:
    bool areSimilar(vector<vector<int>>& mat, int k) {
        int m= mat.size();
        int n= mat[0].size();

        if(k % n == 0) return true;

        k = k % n;
        int future;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i %2 == 0){
                    future = (j+k)%n;
                }
                else{
                    future = (j+n-k)%n;
                }
                if(mat[i][j]!=mat[i][future])
                return false;
            }
        }
        return true;


        return false;
    }
};