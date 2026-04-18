class Solution {
    public int reverse(int n){
        int a = 0;
        while(n>0){
            int r = n%10;
            a = a*10 + r;
            n = n/10;
        }
        return a;
    }
    public int mirrorDistance(int n) {
        int a = reverse(n);
        return Math.abs(n-a);
    }
}