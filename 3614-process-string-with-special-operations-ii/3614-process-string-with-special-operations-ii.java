class Solution {
    public char processStr(String s, long k) {
        
        
        long length = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '#'){
                length = 2*length;
            }
            else if(s.charAt(i) == '%'){
                continue;
            }
            else if(s.charAt(i) == '*'){
                if(length > 0){
                    length -= 1;
                }
            }
            else{
                length +=1;
            }
        }

        if(k >= length) return '.';

        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '#'){
                length = length / 2;
                if(k >= length) k = k-length;

            }
            else if(s.charAt(i) == '%'){
                k= length -k -1;
            }
            else if(s.charAt(i) == '*'){
                    length += 1;
            }
            else{
                length -=1;
            }


            if(length == k) return s.charAt(i);
        }

        return '.';

        
    }
}