class Solution {
    public int[] sortedSquares(int[] nums) {
        int s=nums.length;
        int result[] =new int[s];

        int i=0;
        int j=s-1;
        int k=s-1;

        while(i<=j){
            if(Math.abs(nums[i])<Math.abs(nums[j])){
                result[k]= nums[j]*nums[j];
                j--;
                k--;
            }
            else{
                result[k]= nums[i]*nums[i];
                i++;
                k--;
            }
        }

        return result;
    }
}