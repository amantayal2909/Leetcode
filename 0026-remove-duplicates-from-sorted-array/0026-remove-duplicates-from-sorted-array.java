class Solution {
    public int removeDuplicates(int[] nums) {
       int l = nums.length;

       if(l == 1)return l;

       int i =0;
       int j =1;

       while(j<l){
        if(nums[i]==nums[j]){
            j++;
        }
        else{
            i++;
            nums[i]=nums[j];
        }
       } 

       return i+1;
    }
}