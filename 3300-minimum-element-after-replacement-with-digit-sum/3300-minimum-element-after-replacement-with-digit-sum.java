class Solution {
    public int minElement(int[] nums) {
        int sum = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>9){

                int digit = nums[i];
                int sum_d = 0;
                while(digit>0){
                    int r = digit % 10;
                    sum_d += r;
                    digit = digit/10;
                }

                sum = Math.min(sum, sum_d);
            }
            else{
                sum = Math.min(sum,nums[i]);
            }
        }

        return sum;
    }
}