// class Solution {
//     public int rotatedDigits(int n) {
//         int count = 0;

//         for(int i=1;i<=n;i++){
//             int num = i;
//             boolean changed = false;
//             boolean invalid = false;
//             while(num>0){
//                 int r = num%10;
//                 if(r == 3 || r==4 || r ==7){
//                     invalid = true;
//                     break;
//                 }else if(r ==2 || r==5 || r==6 || r==9){
//                     changed = true;
//                 }
//                 num = num/10;
//             }

//             if(invalid == false && changed == true)count ++;

//         }

//         return count;
//     }
// }




class Solution {
    public int rotatedDigits(int n) {
        int dp[] = new int[n+1];
        int count = 0;
        Arrays.fill(dp,0);
        //0 1 8 -->0
        //3 4 7 --> 1
        // 2 5 6 9 --> 2

        for(int i=1;i<=n;i++){
            int num = i;
            if(num < 10){
                if(num == 3 || num==4 || num ==7){
                    dp[num] = 1;
                }else if(num ==2 || num==5 || num==6 || num==9){
                    dp[num] = 2;
                    count ++;
                }
            }
            else{
                int prefix = dp[num/10];
                int suffix = dp[num%10];

                if(prefix ==1 || suffix ==1 )dp[num] = 1;
                else if(prefix ==0 && suffix ==0) dp[num] = 0;
                else{
                    dp[num] =2;
                    count++;
                }

            }
            

        }

        return count;
    }
}