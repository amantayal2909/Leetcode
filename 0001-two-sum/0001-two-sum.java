class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length;
        int result[]= new int[2];

        Map<Integer, Integer> m = new HashMap<>();

        for(i=0;i<j;i++){
            int second=target-nums[i];
            if(m.containsKey(second)){
                result[0]=i;
                result[1]=m.get(second);
                break;
            }
            else{
                m.put(nums[i],i);
            }

        }
        return result;




    }
}