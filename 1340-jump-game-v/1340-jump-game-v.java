class Solution {
    int dp[];
    public int solve(int[] arr, int current, int d, int n) {
        int count = 1;

        if(dp[current] != 0) return dp[current];

        //left
        for(int i=1; i<=d && (current-i)>=0; i++){
            
            if(arr[current-i]>= arr[current]) break;

            count = Math.max(count, 1+ solve(arr,current-i,d,n));
        }

        //right
        for(int i=1; i<=d && (current+i)<n; i++){
            
            if(arr[current+i]>= arr[current]) break;

            count = Math.max(count, 1+ solve(arr,current+i,d,n));
        }

        dp[current] = count;

        return count;
    }

    public int maxJumps(int[] arr, int d) {
        int count = 1;
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,0);

        for(int i =0; i<n ; i++){
            count = Math.max(count, solve(arr,i,d,n));
        }

        return count;
    }
}