class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int high = 0;

        for(int i=0; i<gain.length; i++){

            high = gain[i] + high;
            ans = Math.max(ans, high); 
        } 

        return ans;
    }
}