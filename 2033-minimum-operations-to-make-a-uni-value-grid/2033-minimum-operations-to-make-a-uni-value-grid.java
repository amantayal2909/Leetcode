class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        int rem = grid[0][0] % x, count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] % x != rem) return -1;
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int mid = m*n/2;
        for(int num : list){
            count += Math.abs((list.get(mid) - num) / x);
        }

        return count;
    }
}