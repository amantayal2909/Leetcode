class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum_max = 0;
        int ans_max= nums[0];

        int sum_min = 0;
        int ans_min= nums[0];

        int total_sum = 0;

        for(int i = 0; i<nums.length;i++){
            sum_max+=nums[i];
            ans_max = Math.max(ans_max,sum_max);
            if(sum_max<0)sum_max =0;

            ////minimum subarray
            sum_min+=nums[i];
            ans_min = Math.min(ans_min,sum_min);
            if(sum_min>0)sum_min =0;

            total_sum +=nums[i];
        }

        //all negative total sum- ans_MINI = 0
        //but value should be - negative like -3 -2 -4 -1 ---> -1
        if(ans_max <0) return ans_max;


        return Math.max(ans_max,(total_sum - ans_min));
    }
}

// Trick kya hai?

// Direct circular sochna mushkil hai
// Toh smart trick use karte hain:

// 👉 Formula:
// Circular max = total sum - minimum subarray

// Final logic (short me)
// Kadane se maxSubarray nikaal
// Kadane se minSubarray bhi nikaal
// totalSum nikaal
// answer = max(maxSubarray, totalSum - minSubarray)

// BUT:
// array is negative (kadane from 1st is negative) kadane form second is zer0
//if we do max it means it will retun zero but answer is -amount
// if (maxSubarray < 0) return maxSubarray;