// https://www.youtube.com/watch?v=z5pEhBhmG5E
class Solution {
    public void createSpf(int spf[], int n){

        Arrays.fill(spf,0);
        for(int i=2; i<n ; i++){
            if(spf[i]==0){
                spf[i] = i;

                for(long j = (long)i*i; j<n; j += i){
                    if(spf[(int)j] == 0) spf[(int)j] = i;
                }
            }
        }
    }
    public List<Integer> find_spf_factors(int val, int spf[]){
        Set<Integer> ans = new HashSet<>();
        while(val !=1){
            int num = spf[val];
            ans.add(num);
            val = val/num;
        }

        return new ArrayList<>(ans);
    }

    public int minJumps(int[] nums) {
      int n = nums.length;
      int high = 0; 
      for(int value: nums)high = Math.max(high, value);

      int spf[] = new int[high +1];

      createSpf(spf, high+1);

      Set <Integer> nums_set = new HashSet<>();
      for(int value : nums)nums_set.add(value);

      Map<Integer, List<Integer>> possible_index_to_jump = new HashMap<>();

      for(int i=0; i<n; i++){
        int val = nums[i];
        List<Integer> spf_factors = find_spf_factors(val, spf);

        for(int fact: spf_factors){
            if(nums_set.contains(fact)){
                if(!possible_index_to_jump.containsKey(fact)){
                    possible_index_to_jump.put(fact, new ArrayList<>());
                }
                possible_index_to_jump.get(fact).add(i);  // map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }
      }

      Queue<Integer> q = new ArrayDeque<>();
      boolean[] visited = new boolean[n];
      Arrays.fill(visited, false);
      q.add(0);
      visited[0] = true;
      int jumps = 0;

      Set<Integer> considered = new HashSet<>();

      while(!q.isEmpty()){
        int qsize = q.size();
        for(int i=0; i<qsize; i++){

            int curr = q.poll();
            int value = nums[curr];

            if(curr == n-1)return jumps;

            if(curr-1 >=0 && visited[curr-1] == false){
                visited[curr-1] = true;
                q.add(curr-1);
            }

            if(curr+1 < n && visited[curr+1] == false){
                visited[curr+1] = true;
                q.add(curr+1);
            }

            if(value == spf[value]){
                if(!considered.contains(value)){
                    List<Integer> index = possible_index_to_jump.get(value);
                    for(int ind: index){
                        if(visited[ind] == false){
                            q.add(ind);
                            visited[ind] = true;
                        }
                    }
                    considered.add(value);
                }
            }

        }
        jumps++;
      }

      return jumps;

    }
}