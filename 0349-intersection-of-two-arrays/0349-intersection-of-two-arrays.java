class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
        
      int n1=nums1.length;
      int n2=nums2.length;
      int i=0;
      int j=0;
      int prev=Integer.MIN_VALUE;
        
      ArrayList<Integer> a = new ArrayList<>();  
        
        while(i<n1 && j<n2){
            if(nums1[i]==nums2[j]){
                if(prev !=nums1[i]){
                    a.add(nums1[i]);
                    prev=nums1[i];
                }
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
                i++;
            else 
                j++;
        }
        
        int ans[]=new int[a.size()];
        for (int k = 0; k < a.size(); k++) {
            ans[k] = a.get(k);
        }
        return ans;
    }
}