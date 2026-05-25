class Solution {
    public boolean canReach(String nums, int minJump, int maxJump) {
        int size = nums.length();
        if(size ==1)return true;

        boolean visit[] = new boolean[size];
        Arrays.fill(visit,false);

        Queue<Integer> q = new ArrayDeque<>();
        int start = 0;
        q.add(start);
        visit[start]= true;

        int farthest = 0;

        while(!q.isEmpty()){
            int qsize = q.size();

           // for(int I=0;I<qsize; I++){
                int index = q.poll();

                int min_index = Math.max((index + minJump), farthest+1);
                int max_index = Math.min((index + maxJump), size-1);


                for(int i=min_index; i<=max_index; i++){
                    if(nums.charAt(i) == '0' && i == size-1) return true;

                    if(nums.charAt(i) == '0' && visit[i] == false){
                        q.add(i);
                        visit[i] = true;
                    }
                }

                farthest = Math.max(farthest, max_index);

            //}
        }

        return false;
    }
}