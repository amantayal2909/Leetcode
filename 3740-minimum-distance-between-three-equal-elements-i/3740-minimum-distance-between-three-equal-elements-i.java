class Solution {
    public int minimumDistance(int[] nums) {
        int size = nums.length;
        HashMap <Integer, List<Integer>> mp = new HashMap<>();

        for(int i=0; i<size; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int ans = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            int key = entry.getKey();
            List<Integer> list = entry.getValue();

            if(list.size()>=3){
                for(int i=0; i<list.size()-2;i++){
                    int dis = 2 *(list.get(i+2)-list.get(i));
                    ans = Math.min(ans,dis);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}