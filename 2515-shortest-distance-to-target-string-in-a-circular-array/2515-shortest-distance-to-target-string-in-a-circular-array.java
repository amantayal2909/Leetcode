class Solution {
    public int closestTarget(String[] words, String target, int start) {
        int size1 = words.length;
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<size1; i++){
            if(words[i].equals(target)){
            int left = Math.abs(i-start);
            int right = size1 - left;

            ans = Math.min(ans, Math.min(left, right));
            }

        } 
        return ans ==  Integer.MAX_VALUE ? -1: ans;
    }
}