class Solution {
    HashMap <Integer, int [][]> map = new HashMap<>();
    int m, n;
    boolean visit[][] ;

    public boolean hasValidPath(int[][] grid) {

        map.put(1, new int[][] {{0,-1},{0,1}});
        map.put(2, new int[][] {{1,0},{-1,0}});
        map.put(3, new int[][] {{0,-1},{1,0}});
        map.put(4, new int[][] {{1,0},{0,1}});
        map.put(5, new int[][] {{-1,0},{0,-1}});
        map.put(6, new int[][] {{-1,0},{0,1}});

        m = grid.length;
        n = grid[0].length;

       visit = new boolean[m][n];

        return dfs_solve(grid, 0, 0);
        
    }

    public boolean dfs_solve(int [][] grid , int i, int j){

        if(i == m-1 && j == n-1) return true;
        visit[i][j] = true;

        int value = grid[i][j];
        int dir[][] = map.get(value);

        for(int k=0; k<2 ; k++){
            int newx = i + dir[k][0];
            int newy = j + dir[k][1];

            if(newx <0 || newx>=m || newy<0 || newy>=n || visit[newx][newy] == true) continue;

            if(next_valid(grid, newx, newy, i, j) == false) continue;

            if(dfs_solve(grid, newx, newy)) return true;

        }

        return false;
    }

    public boolean next_valid(int [][] grid , int newx, int newy, int i, int j){
        int value = grid[newx][newy];
        int dir[][] = map.get(value);

        for(int k=0; k<2 ; k++){
            int oldx = newx + dir[k][0];
            int oldy = newy + dir[k][1];

            if(oldx == i && oldy == j) return true;

        }
        return false;
    }
}