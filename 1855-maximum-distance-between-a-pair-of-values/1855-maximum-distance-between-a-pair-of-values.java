class Solution {
    public int solve_get_last(int index,int target, int[] nums, int size) {
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
        int size1 = nums1.length;
        int size2 = nums2.length;
        int ans = 0;
        for(int i=0; i<size1; i++){
            if(i>=size2) break;
            if(nums1[i]>nums2[i])continue;

            int current = i;
            int last = solve_get_last(i, nums1[i], nums2, size2);
            System.out.println(current+ " "+last);
            ans = Math.max(ans, last - i);
        }

        return ans;

    }
}