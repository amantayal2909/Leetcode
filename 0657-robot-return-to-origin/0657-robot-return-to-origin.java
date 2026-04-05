class Solution {
    public boolean judgeCircle(String moves) {
        int count_h = 0;
        int count_v = 0;

        for(int i=0; i<moves.length(); i++){
            if(moves.charAt(i) == 'U') count_v++;
            else if(moves.charAt(i) == 'D') count_v--;
            else if(moves.charAt(i) == 'L') count_h++;
            else if(moves.charAt(i) == 'R') count_h--;
        }

        return (count_v ==0 && count_h ==0);
    }
}