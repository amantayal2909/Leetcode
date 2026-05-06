class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        System.out.println(m + " "+ n);

        char ans[][] = new char[n][m];

        for(int j=0;j<n;j++){
            int k=0;
            for(int i=m-1; i>=0; i--,k++){
                ans[j][k] = box[i][j];
            }
        }
        //row = n; col = m;
        for(int j=0;j<m;j++){
            int space = n-1;
            for(int i=n-1; i>=0; i--){
                if(ans[i][j] == '#'){
                    char temp = ans[space][j];
                    ans[space][j]=ans[i][j];
                    ans[i][j] = temp;
                    space --;
                }
                else if(ans[i][j] == '*'){
                    space = i-1;
                }
            }
        }

        return ans;
    }
}