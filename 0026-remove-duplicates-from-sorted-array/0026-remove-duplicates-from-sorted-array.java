class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        int s=nums.length;
        if(s==1)return 1;
        int j=0;

        while(i<s){
            if(nums[i]==nums[j]){
                i++;
            }
            else{
                j++;
                nums[j]=nums[i];
                i++;
            }
        }
        return j+1;
    }
}