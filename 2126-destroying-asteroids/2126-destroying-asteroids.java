class Solution {
    public boolean asteroidsDestroyed(int m, int[] asteroids) {
        int size = asteroids.length;

        Arrays.sort(asteroids);
        long mass = m;

        for(int i=0;i<size; i++){
            if(mass>=asteroids[i]){
                mass+= asteroids[i];
            }
            else return false;
        }

        return true;
    }
}