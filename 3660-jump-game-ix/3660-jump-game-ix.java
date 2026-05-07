class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int left_max[] = new int[n];
        int right_min[] = new int[n];

        left_max[0] = nums[0];
        for(int i=1; i<n;i++){
            left_max[i] = Math.max(left_max[i-1],nums[i]);
        }

        right_min[n-1] = nums[n-1];
        for(int i=n-2; i>=0;i--){
            right_min[i] = Math.min(right_min[i+1],nums[i]);
        }

        int ans[] = new int[n];

        ans[n-1] = left_max[n-1];
        for(int i=n-2; i>=0;i--){
           
           if(left_max[i] <= right_min[i+1]) ans[i]= left_max[i];

           else{
            ans[i]= ans[i+1];
           }
        }

        return  ans;
    }
}