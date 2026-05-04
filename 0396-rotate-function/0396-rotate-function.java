class Solution {
    public int maxRotateFunction(int[] nums) {
        /*
        f(0) = 0*4 + 1*3 + 2*2 + 3*6 = 25
        f(1) = 1*4 + 2*3 + 3*2 + 0*6 = 25 + (4+3+2+6 - 4*(6))
        f(2) = 2*4 + 3*3 + 0*2 + 1*6 = 16 + (4+3+2+6 - 4*(2))
        */

        int size = nums.length;
        int sum = 0;

        for(int i=0; i<size; i++){
            sum+=nums[i];
        }

        int previous = 0;
        for(int i = 0; i< size; i++){
            previous += (i*nums[i]);
        }

        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans,previous);

        for(int i = 1; i< size; i++){
            int current = previous + (sum - size*(nums[size-i]));
            ans = Math.max(ans,current);
            previous = current;
        }

        return ans;

    }
}