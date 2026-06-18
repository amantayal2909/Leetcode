class Solution {
    public double angleClock(int hour, int minutes) {
        double min = 6 * minutes;
        if(hour == 12)hour = 0;
        double h = hour*30 + 0.5*minutes;

        double ans = Math.abs(h-min);

        return Math.min(ans, 360-ans);
    }
}