class Solution {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        if(size == 1) return true;

        int arr[] = new int[size];
        Arrays.fill(arr,0);
        arr[0] = 1;


        for(int i=0; i<size; i++){

            if(arr[i]==0) return false;

            int val = nums[i];

            for(int j=1; j<=val && (i+j)<=size-1; j++){
                if((i+j) == size-1)
                    return true;
                arr[i+j]++;
            }

        }

    
        return false;
    }
}