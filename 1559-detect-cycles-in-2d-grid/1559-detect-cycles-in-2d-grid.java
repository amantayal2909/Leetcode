class Solution {
    boolean visited[][];
    int m, n;
    int dir[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    public boolean solve(char[][] grid, int i, int j, 
                        int prev_i, int prev_j, char alpha) {

        
        visited[i][j] = true;

        for(int k=0 ; k<4; k++){
            int next_i = i + dir[k][0];
            int next_j = j + dir[k][1];

            if(next_i>=m || next_j>=n || next_i<0 || next_j<0 || 
                grid[next_i][next_j]!= alpha) 
                continue;

            if(visited[next_i][next_j] == true){
                if(next_i == prev_i && next_j == prev_j)continue;

                return true;
            }

            if(solve(grid, next_i, next_j, i,j, alpha))
                return true;

        }

        return false;

    

    }
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];
        

        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                char alpha = grid[i][j];
                if(visited[i][j] == false){
                    if(solve(grid, i, j, -1, -1, alpha))return true;
                }
            }
        }
        return false;
    }
}