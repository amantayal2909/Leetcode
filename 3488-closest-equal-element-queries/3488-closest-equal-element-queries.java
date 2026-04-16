class Solution {
    public List<Integer> solveQueries(int[] nums, int[] q) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int size = nums.length;

        for(int i=0; i<size; i++){
            int key = nums[i];

            // If key not present, create new list
            map.putIfAbsent(key, new ArrayList<>());

            // Add value to list
            map.get(key).add(i);
        }

        int size1 = q.length;

        for(int i=0; i<size1; i++){
            int index = q[i];
            int num_val = nums[index];

            List<Integer> listt = map.get(num_val);

            if (listt == null || listt.size() == 1) {
                ans.add(-1);
                continue;
            }
            int mini = Integer.MAX_VALUE;
            // for(int j=0; j<listt.size(); j++){
            //     if(listt.get(j)!=index){
            //         int left = Math.abs(index-listt.get(j));
            //         int right = size - left;
            //         mini = Math.min(mini, Math.min(left, right));

            //     }
            // }

            int pos = Collections.binarySearch(listt, index);
            int leftpos = (pos-1 + listt.size()) %listt.size();
            int rightpos = (pos + 1) %listt.size();


            int left =  Math.abs(index -listt.get(leftpos));
            int left1 = (size - left);
            int right = Math.abs(index -listt.get(rightpos));
            int right1 = (size - right);

            mini = Math.min(mini, Math.min(left, right));
            mini = Math.min(mini, Math.min(left1, right1));
            ans.add(mini);
        }

        return ans;
    }
}

// for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//     int key = entry.getKey();
//     List<Integer> value = entry.getValue();

//     System.out.println(key + " -> " + value);
// }

//List<Integer> list = map.get(1);

// class Solution {
//     public int closestTarget(String[] words, String target, int start) {
//         int size1 = words.length;
        
//         int ans = Integer.MAX_VALUE;
//         for(int i=0; i<size1; i++){
//             if(words[i].equals(target)){
//             int left = Math.abs(i-start);
//             int right = size1 - left;

//             ans = Math.min(ans, Math.min(left, right));
//             }

//         } 
//         return ans ==  Integer.MAX_VALUE ? -1: ans;
//     }
// }