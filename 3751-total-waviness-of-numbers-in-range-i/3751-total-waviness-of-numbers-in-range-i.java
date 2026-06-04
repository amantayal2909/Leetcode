class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int digit=num1; digit<=num2; digit++){

            String dig = String.valueOf(digit);
            if(dig.length()<3) continue;

            int left;
            int right;
            int current;

            for(int i=1; i<dig.length()-1 ; i++){
                left = dig.charAt(i-1) - 48;
                right = dig.charAt(i+1) - 48;
                current = dig.charAt(i) - 48;
                if(current> left && current> right) ans ++;
                if(current< left && current< right) ans ++;

            }
        }

        return ans;

    }
}