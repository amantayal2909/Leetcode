class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())return false;
        int n = s.length();

        String str = s + s;

        // for(int i=0; i<n; i++){
        //     String s1 = str.substring(i,i+n);
        //     if(s1.equals(goal))return true;
        
        // }
        if(str.contains(goal))return true;

        return false;
    }
}