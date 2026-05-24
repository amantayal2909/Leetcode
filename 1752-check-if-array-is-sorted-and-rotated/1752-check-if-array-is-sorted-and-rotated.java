class Solution {
    public boolean check(int[] nums) {
        
        int size = nums.length;
        int count = 0;

        for(int i=1; i<size; i++){

            if(nums[i-1]>nums[i])count++;
        }

        if(nums[size-1]>nums[0])count++;

        if(count<=1)return true;

        return false;
    }
}