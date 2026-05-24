class Solution {
    public boolean canReach(int[] nums, int start) {
        int size = nums.length;
        if(nums[start] == 0)return true;

        boolean visit[] = new boolean[size];
        Arrays.fill(visit,false);

        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        visit[start]= true;

        while(!q.isEmpty()){
            int qsize = q.size();

            for(int i=0;i<qsize; i++){
                int index = q.poll();
                int val = nums[index];

                int right_index = index +val;
                int left_index = index -val;

                if((right_index <size && nums[right_index]==0) 
                   || (left_index >=0 && nums[left_index]==0)){

                    return true;
                }

                if(right_index <size && visit[right_index]==false){
                    q.add(right_index);
                    visit[right_index] = true;
                }

                if(left_index >=0 && visit[left_index]==false){
                    q.add(left_index);
                    visit[left_index] = true;
                }

            }
        }

        return false;
    }
}