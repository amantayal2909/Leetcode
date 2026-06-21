class Solution {
    public int maxIceCream(int[] costs, int coins) {
        

        int maxval = Integer.MIN_VALUE;
        for(int i=0; i<costs.length; i++) maxval = Math.max(maxval, costs[i]);

        int arr[] = new int[maxval +1];
        for(int i=0; i<costs.length; i++) arr[costs[i]]++;

        int k = 0;
        for(int i=0; i<=maxval; i++){
            for(;arr[i]>0;){
                costs[k] = i;
                k++;
                arr[i] -=1;
            }
        }
        


        int ans = 0;
        for(int i=0; i<costs.length; i++){
            if(costs[i] <= coins){
                ans ++;
                coins -= costs[i];
            }
            else break;
        }
        return ans;

    }
}