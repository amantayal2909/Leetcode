class Solution {
    public int xorAfterQueries(int[] nums, int[][] q) {
        int q_size = q.length;
        int ans = 0;
        int mod = 1000000007;
        for(int i=0; i<q_size; i++){
            int l= q[i][0];
            int r = q[i][1];
            int k = q[i][2];
            int v = q[i][3];

            for(int j =l; j<=r; j=j+k){
                nums[j] = (((long)nums[j] * v) % (mod));
            }
        }

        for(int i=0; i<nums.length; i++){
            ans = ans ^ nums[i];
        }

        return ans;

    }
}