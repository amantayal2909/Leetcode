class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put((long)num, map.getOrDefault((long)num,0)+1);
        }
        long one = 1;
        int ans = 0;
        if(map.containsKey(one)){
            int count = map.get(one);

            if(count%2 ==0)count --;

            ans = Math.max(count, ans);
        }

        for (long start : map.keySet()) {

            if (start == 1)
                continue;

            long curr = start;
            int length = 1;

            while (true) {

                // Current number must appear at least twice
                if (!map.containsKey(curr) || map.get(curr) < 2)
                    break;

                long next = curr * curr;

                // If square doesn't exist, current becomes the middle
                if (!map.containsKey(next))
                    break;

                length += 2;
                curr = next;
            }

            ans = Math.max(ans, length);
        }
        return ans;
    }
}