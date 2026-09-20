class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int a = 26 - (s.charAt(i) - 97);

            sum += a*(i+1);
        }
        
        return sum;
    }
}