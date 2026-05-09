class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int common_rem = grid[0][0] % x;

        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0 ; j<n ; j++){
                int r = grid[i][j] % x;
                if(r != common_rem) return -1;

                arr.add(grid[i][j]);
            }
        }

        Collections.sort(arr);
        int length = arr.size();

        int mid = length/2;

        int steps = 0;
        for(int i=0; i<length ; i++){
            steps += Math.abs(arr.get(i)-arr.get(mid))/x;
        }


        return steps;




    }
}