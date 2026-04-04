class Solution {
    public String decodeCiphertext(String encodedText, int rows) {

        // for(int i=0 ;i<encodedText.length();i++){
        //     System.out.println(encodedText.charAt(i) + " 1");

        // }
        if(rows == 0 || encodedText.length() ==0) return "";
        int col = encodedText.length()/rows;

        
        StringBuilder ans = new StringBuilder();

        for(int startcol =0; startcol<col; startcol++){
            int i = 0;
            int j = startcol;

            for(;i<rows && j<col; i++,j++){
                ans.append(encodedText.charAt(i*col + j));
            }


        }
        int end = ans.length()-1;
        while(end>=0 && ans.charAt(end) == ' '){
            end --;
        }

        return ans.substring(0,end+1);
    }
}