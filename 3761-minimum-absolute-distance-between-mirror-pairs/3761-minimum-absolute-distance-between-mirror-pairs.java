class Solution {
    public static int upperBound(List<Integer> arr, int target) {
        int low = 0, high = arr.size(); // note: high = n

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) <= target) {
                low = mid + 1;  // move right
            } else {
                high = mid;     // possible answer
            }
        }
        return low; // index of first element > target
    }
    public int solve_reverse(int num){
        int a = 0;
        while(num>0){
            int r = num%10;
            a=a*10 + r;
            num = num/10;
        }

        return a;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();


        int size = nums.length;

        for(int i=0; i<size; i++){
            int key = nums[i];

            // If key not present, create new list
            map.putIfAbsent(key, new ArrayList<>());

            // Add value to list
            map.get(key).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<size; i++){
            int key = solve_reverse(nums[i]);
            //nums = 21 -> i =1
            //key = 12 -> list 0,4,7

            if(map.containsKey(key)){
                List<Integer> listt = map.get(key);
                int pos = upperBound(listt, i);

                if(pos == listt.size())continue;
                ans = Math.min(ans,Math.abs(i-listt.get(pos)));

            }

            // If key not present, create new list
            //map.putIfAbsent(key, new ArrayList<>());

            // Add value to list
            //map.get(key).add(i);
        }

        return ans == Integer.MAX_VALUE? -1: ans;

    }
}