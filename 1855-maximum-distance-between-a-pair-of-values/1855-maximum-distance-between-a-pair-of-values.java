class Solution {
    public int solve_get_last(int index,int target, int[] nums, int size) {
        // think of 
        // target is 2 , index is 0 nums is 10 10 1
        // but tak as 1 10 10
        // as index 2 1 0
        // so start =>2  end is index
        // use uperbound

        int end = index;
        int start = size-1;
        while(start>=end){
            int mid = end + (start-end)/2;
            if(nums[mid] >= target){
                end = mid+1;
            }
            else{
                start = mid-1;
            }

        }
        return start;

    }
    public int maxDistance(int[] nums1, int[] nums2) {

        // Approach N LOG N
        // int size1 = nums1.length;
        // int size2 = nums2.length;
        // int ans = 0;
        // for(int i=0; i<size1; i++){
        //     if(i>=size2) break;
        //     if(nums1[i]>nums2[i])continue;

        //     int current = i;
        //     int last = solve_get_last(i, nums1[i], nums2, size2);
        //     System.out.println(current+ " "+last);
        //     ans = Math.max(ans, last - i);
        // }

        // return ans;



        //APPROACH N+N = 2N

        int size1 = nums1.length;
        int size2 = nums2.length;
        int ans = 0;
        int i = 0, j =0;
        while(i<size1 && j<size2){
            if(nums1[i]<=nums2[j]){
                ans = Math.max(ans, j - i);
                j++;
            }
            else{
                i++;
            }
            
        }

        return ans;

    }
}