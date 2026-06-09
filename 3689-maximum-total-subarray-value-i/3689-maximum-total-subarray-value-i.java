class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            large = Math.max(large, nums[i]);
            small = Math.min(small, nums[i]);
        }

        long ans = (large - small);
        ans = ans * k;

        return ans;
    }
}