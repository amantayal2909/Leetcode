class Solution {
    int m,n;
    Integer dp[][][];
    public int solve(int[][] coins, int i, int j, int skip) {
        if(i>=m || j>=n) return Integer.MIN_VALUE;
        
        if(i== m-1 && j == n-1){
            if(coins[i][j]>=0)return coins[i][j];
            else{
                if(skip>0) return 0;
                else return coins[i][j];
            }
        }

        int a = solve(coins,i+1,j,skip);
        int b = solve(coins,i,j+1, skip);

        if(coins[i][j]>=0){
            return coins[i][j]+ Math.max(a,b);
        }
        else{
            int ans_skip = Integer.MIN_VALUE;
            if(skip > 0 ){
                int right_skip = solve(coins,i+1,j  ,skip-1);
                int down_skip = solve(coins,i  ,j+1,skip-1);

                ans_skip = Math.max(right_skip,down_skip);
            }
            
            int ans_neg_without_skip = coins[i][j]+ Math.max(a,b);
            return Math.max(ans_skip,ans_neg_without_skip);

        }
        

       
    }
    public int solve_memo(int[][] coins, int i, int j, int skip) {
        if(i>=m || j>=n) return Integer.MIN_VALUE;
        
        if(i== m-1 && j == n-1){
            if(coins[i][j]>=0)return coins[i][j];
            else{
                if(skip>0) return 0;
                else return coins[i][j];
            }
        }
        if (dp[i][j][skip] != null) return dp[i][j][skip];

        int a = solve(coins,i+1,j,skip);
        int b = solve(coins,i,j+1, skip);

        int dp_ans;    
        if(coins[i][j]>=0){
            dp_ans = coins[i][j]+ Math.max(a,b);
        }
        else{
            int ans_skip = Integer.MIN_VALUE;
            if(skip > 0 ){
                int right_skip = solve(coins,i+1,j  ,skip-1);
                int down_skip = solve(coins,i  ,j+1,skip-1);

                ans_skip = Math.max(right_skip,down_skip);
            }
            
            int ans_neg_without_skip = coins[i][j]+ Math.max(a,b);
            dp_ans= Math.max(ans_skip,ans_neg_without_skip);

        }
        dp[i][j][skip] = dp_ans;
        return dp_ans;

       
    }
    public int solve_dp(int[][] coins, int I, int J, int skip) {
        

        for(int k= 0; k<=2; k++){
            if(coins[m-1][n-1]>=0){
                dp[m-1][n-1][k] =coins[m-1][n-1];
            }
            else{
                if(k>0){
                   dp[m-1][n-1][k] =0; 
                }else{
                    dp[m-1][n-1][k] =coins[m-1][n-1];
                }
            }
        }


        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(i == m-1 && j== n-1)continue;

                for(int k =0; k<=2;k++){
                    int right= (j+1 < n)? dp[i][j+1][k] : Integer.MIN_VALUE;
                    int down= (i+1 <m) ?dp[i+1][j][k] : Integer.MIN_VALUE;

                    if(coins[i][j]>=0){
                    dp[i][j][k] = coins[i][j]+ Math.max(right,down);
                    }
                    else{
                    int ans_skip = Integer.MIN_VALUE;
                    if(k > 0 ){
                        int right_skip = (j+1 < n)? dp[i][j+1][k-1] : Integer.MIN_VALUE;
                        int down_skip = (i+1 <m) ?dp[i+1][j][k-1] : Integer.MIN_VALUE;

                        ans_skip = Math.max(right_skip,down_skip);
                    }
            
                    int ans_neg_without_skip = coins[i][j]+ Math.max(right,down);
                    dp[i][j][k]= Math.max(ans_skip,ans_neg_without_skip);

                    }
                }

            }
        }

        
        return dp[I][J][skip];

       
    }
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        dp = new Integer[m][n][3];
        return solve_dp(coins,0,0,2);
        //return solve_memo(coins,0,0,2);
        //return solve(coins,0,0,2);
    }
}