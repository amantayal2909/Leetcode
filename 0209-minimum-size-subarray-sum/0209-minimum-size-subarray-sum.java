
public class Solution
{
    public int minSubArrayLen(int k, int[] A)
    {
      int n = A.length;

      int left = 0;
      int right = 0;
      int ans = Integer.MAX_VALUE;
      int sum = 0;

      

      for(right =0; right<n ;right++){
        sum +=A[right];
        System.out.println(sum + " r ");

        while(sum>=k){
          ans = Math.min(ans, (right-left+1));
          sum-=A[left];
          System.out.print(sum + " l ");
          left++;
          System.out.print(left + " lef ");
        }

      }
      return ans == Integer.MAX_VALUE? 0: ans;


      
    }
}