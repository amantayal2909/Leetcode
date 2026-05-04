class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for(int i=1;i<=n;i++){
            int num = i;
            boolean changed = false;
            boolean invalid = false;
            while(num>0){
                int r = num%10;
                if(r == 3 || r==4 || r ==7){
                    invalid = true;
                    break;
                }else if(r ==2 || r==5 || r==6 || r==9){
                    changed = true;
                }
                num = num/10;
            }

            if(invalid == false && changed == true)count ++;

        }

        return count;
    }
}