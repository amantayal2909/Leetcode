class Solution {
    int dp[][][];
    public int solve(int[][] grid, int i, int j, int m, int n, int k){
        if(i>=m || j>=n || k<0)return Integer.MIN_VALUE;
        if(i == m-1 && j == n-1){
            if(grid[i][j] == 0)return 0;
            else if(k==0) return Integer.MIN_VALUE;
            return grid[i][j];
        }
        if(dp[i][j][k]!=-1)return dp[i][j][k];

        int k_minus = k;
        if(grid[i][j] != 0)
            k_minus--;

        int best = Integer.MIN_VALUE;
        int right = solve(grid, i, j+1, m, n, k_minus); 
        int down =  solve(grid, i+1, j, m, n, k_minus);

        if (right != Integer.MIN_VALUE) {
            best = Math.max(best, grid[i][j] + right);
        }
        if (down != Integer.MIN_VALUE) {
            best = Math.max(best, grid[i][j] + down);
        }

        return dp[i][j][k] = best;

    }
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][k+1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);
        int ans = solve(grid, 0, 0, m, n, k);
        return ans>=0 ? ans:-1;
    }
}