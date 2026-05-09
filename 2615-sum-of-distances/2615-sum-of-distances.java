class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i =0; i<n; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());

            map.get(nums[i]).add(i);
        }

        long sum = 0;
        long ans[] = new long[n];

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){

            List<Integer> index = entry.getValue();
            if(index.size()==1) 
            {
                ans[index.get(0)] = 0;
                continue;
            }

            int size = index.size();
            long prefix[] = new long[size];
            long suffix[] = new long[size];

            prefix[0]= index.get(0);
            for(int i=1; i<size; i++) prefix[i] = prefix[i-1] + index.get(i);

            suffix[size-1]= index.get(size-1);
            for(int i=size-2; i>=0; i--) suffix[i] = suffix[i+1] + index.get(i);


            for(int i=0; i<size; i++){
                int val = index.get(i);

                long left = 0;
                long right = 0;
                if(i>0)
                    left = ((long)i*val) - prefix[i-1];
                
                if(i<size-1)
                    right = suffix[i+1] - (long)(size-1-i)*val;

                ans[val] = left + right;
            }

        }

        return ans;
    }
}