class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        
        int i=0, j=l-1;
        while(i<j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++; j--;
        }

        i=0; j=k-1;

        while(i<j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++; j--;
        }

        i=k; j=l-1;

        while(i<j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++; j--;
        }






    }
}