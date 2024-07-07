class Solution {
public:
    int numWaterBottles(int total, int ex) {
        int empty=total;
        int ans=total;
        int bottle=total;

        while(empty/ex){
        int r=empty%ex;
        int d=empty/ex;

        ans+=d;
        empty=r+d;

        }
        return ans;
    }
};