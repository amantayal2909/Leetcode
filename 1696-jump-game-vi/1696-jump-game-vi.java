class Solution {
    int dp[];
    // public int solve(int[] nums, int current, int n, int k){

    //     if(current == n-1) return nums[current];
    //     if(dp[current] != Integer.MIN_VALUE) return dp[current];
    //     int sum = Integer.MIN_VALUE;

    //     for(int i=1; i<=k && (current+i)<n; i++){
    //         sum = Math.max(sum, nums[current] + solve(nums, current+i, n, k));
    //     }

    //     dp[current] = sum;
    //     return sum;

    // }
    
    // public int maxResult_memo(int[] nums, int k) {
    //     int n = nums.length;
    //     dp = new int[n];
    //     Arrays.fill(dp, Integer.MIN_VALUE);
    //     return solve(nums,0,n,k);
    // }



    //  DP
    // public int maxResult(int[] nums, int k) {
    //     int n = nums.length;
    //     dp = new int[n];
    //     dp[0] = nums[0];

    //     for(int j=1; j<n; j++){
    //     int sum = Integer.MIN_VALUE;

    //     for(int i=1; i<=k && (j-i)>=0; i++){
    //         sum = Math.max(sum, nums[j] + dp[j-i]);
    //     }

    //     dp[j] = sum;
        
    //     }

    //     return dp[n-1];
    // }



    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addFirst(0);

        for(int j=1; j<n; j++){
            
            if(queue.peekFirst() < j-k) queue.pollFirst();

            dp[j] = nums[j] + dp[queue.peekFirst()];

            while(!queue.isEmpty() && dp[j]>= dp[queue.peekLast()]) queue.pollLast();

            queue.addLast(j);
        }

        return dp[n-1];
    }


}