class Solution {
    public int minJumps(int[] nums) {
        int size = nums.length;
        if(size == 1)return 0;

        boolean visit[] = new boolean[size];
        Arrays.fill(visit,false);

        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0; i<size; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }
        int jump = 0;

        Queue<Integer> q = new ArrayDeque<>();
        int start = 0;
        q.add(start);
        visit[start]= true;

        while(!q.isEmpty()){
            int qsize = q.size();

            for(int i=0;i<qsize; i++){
                int index = q.poll();
                int val = nums[index];

                int right_index = index +1;
                int left_index = index -1;

                if(right_index == size - 1  || left_index == size-1) return jump+1;
                if(right_index <size && visit[right_index]==false){
                    q.add(right_index);
                    visit[right_index] = true;
                }

                if(left_index >=0 && visit[left_index]==false){
                    q.add(left_index);
                    visit[left_index] = true;
                }

                if(map.containsKey(val)){
                    List<Integer> arr = map.get(val);

                    for(int j=0; j<arr.size(); j++){
                        if(arr.get(j) == index) continue;

                        int map_index = arr.get(j);
                        if(map_index == size-1)return jump+1;

                        if(visit[map_index] == false){
                            q.add(map_index);
                            visit[map_index] = true;
                        }
                    }

                    map.remove(val);
                }

            }
            jump++;
        }

        return -1;
    }
}