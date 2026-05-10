class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n= nums.length;
        int i =0, j =0;
        int ans = 0;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        dp[0] = 0;
        for(i=0; i<n; i++){
            if(dp[i] == -1)continue;
            for(j = i+1; j<n ; j++){
                if(Math.abs(nums[i]- nums[j]) <= target){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }
        
        return dp[n-1];
    }
}