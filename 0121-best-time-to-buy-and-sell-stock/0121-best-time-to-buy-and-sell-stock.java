public class Solution
{
    public int maxProfit(int[] prices)
    {
       int n = prices.length;

       int buy = prices[0];
       int profit = Integer.MIN_VALUE;

       for(int i=1;i<n;i++){
        int current = prices[i];
        profit = Math.max(profit,(current-buy));
        buy = Math.min(buy, current);
       }
       return profit <0 ? 0 : profit;

      
    }
}