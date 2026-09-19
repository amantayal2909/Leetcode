class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closex = Math.max(x1,Math.min(xCenter,x2));
        int closey = Math.max(y1,Math.min(yCenter,y2));

        if((xCenter-closex)*(xCenter-closex) + (yCenter-closey)*(yCenter-closey) <= radius*radius )
            return true;

        return false;
    }
}