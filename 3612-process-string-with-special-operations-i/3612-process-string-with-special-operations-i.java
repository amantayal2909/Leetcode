class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        int index = -1;
        int length = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '#'){
                ans.append(ans);
                length = 2*length;
                index = length -1;
            }
            else if(s.charAt(i) == '%'){
                ans.reverse();
            }
            else if(s.charAt(i) == '*'){
                if(index > -1){
                ans.deleteCharAt(index);
                length -= 1;
                index -= 1;
                }
            }
            else{
                ans.append(s.charAt(i));
                length +=1;
                index +=1;
            }
        }

        return ans.toString();
    }
}