class Solution {
    public int[][] rotateGrid(int[][] grid, int steps) {
        int m = grid.length;
        int n = grid[0].length;

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;
        int i =0, j=0, k=0, rotation = 0;
        

        while(top <= bottom && left <= right){
            List<Integer> sep = new ArrayList<>();

            for(i = left; i<=right; i++) sep.add(grid[top][i]);
            for(i = top+1; i<=bottom; i++) sep.add(grid[i][right]);
            for(i = right-1; i>=left; i--) sep.add(grid[bottom][i]);
            for(i = bottom-1; i>=top+1; i--) sep.add(grid[i][left]);

            int length = sep.size();
            rotation = steps % length;
            
            Collections.rotate(sep, -rotation);
            k = 0;

            for(i = left; i<=right; i++, k++) grid[top][i] = sep.get(k);
            for(i = top+1; i<=bottom; i++, k++) grid[i][right] = sep.get(k);
            for(i = right-1; i>=left; i--, k++) grid[bottom][i] = sep.get(k);
            for(i = bottom-1; i>=top+1; i--, k++) grid[i][left] = sep.get(k);

            top++;
            bottom--;
            left++;
            right--;


        }

        return grid;
    }
}