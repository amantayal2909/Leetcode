class Solution {
    public int maxDistance(int[] colors) {
        int a= colors[0];
        int left= 0;
        for(int i= colors.length-1;i>0;i--){
            if(a!=colors[i]){
                left = i;
                break;
            }
        }
        a = colors[colors.length-1];
        int right= 0;
        for(int i=0;i<colors.length-2;i++){
            if(a!=colors[i]){
                right = colors.length-1 - i;
                break;
            }
        }
        return Math.max(left, right);
    }
}