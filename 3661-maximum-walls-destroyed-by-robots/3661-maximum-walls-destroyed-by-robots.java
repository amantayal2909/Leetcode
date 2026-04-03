class Solution {
    
    public int query(int[] walls, int l, int r) {
        if (l > r) return 0;

        int left = lowerBound(walls, l);   // first ≥ l
        int right = upperBound(walls, r);  // first > r

        return right - left;
    }

    public int lowerBound(int[] walls, int x) {
        int l = 0, r = walls.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (walls[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int upperBound(int[] walls, int x) {
        int l = 0, r = walls.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (walls[mid] <= x) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int m = robots.length;
        int n = walls.length;
        Integer index[] = new Integer[m];
        for(int i=0;i<m;i++){
            index[i] = i;
        }
        Arrays.sort(index, (a,b) -> robots[a]-robots[b]);
        Arrays.sort(walls);

        int dp[][] = new int[m][2];
        //0 left 1 right

        int pos = robots[index[0]];
        int dis = distance[index[0]];

        dp[0][0] = query(walls, (pos-dis), pos);  
        if(m>1){
            dp[0][1] = query(walls,pos, Math.min(pos+dis, robots[index[1]]-1) );
        }
        else{
            dp[0][1] = query(walls,pos, pos+dis);
        }

        for(int i =1;i<m;i++){
            pos = robots[index[i]];
            dis = distance[index[i]];

            int current_right;
            if(i+1<m){
            current_right = query(walls,pos, Math.min(pos+dis, robots[index[i+1]]-1));
            }
            else{
            current_right = query(walls,pos, pos+dis);
            }

            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]) + current_right;



            //current left shoot
            //prev also left shoot no overlap
            dp[i][0] = dp[i-1][0] +  //add only left
            query(walls, Math.max(pos-dis, robots[index[i-1]]+1),   pos);

            //current left shoot
            //prev also right shoot overlap


            int cur_left_start = Math.max(pos-dis, robots[index[i-1]]+1);
            int cur_left_end = pos;


            int overlap_start = cur_left_start;
            int overlap_end = Math.min(robots[index[i-1]]+ distance[index[i-1]] , pos-1);

            int org_wall = query(walls,cur_left_start,cur_left_end);
            int overlap_wall = query(walls,overlap_start,overlap_end);

            int ans = dp[i-1][1] //add only right
                         + (org_wall - overlap_wall);

            dp[i][0] = Math.max(ans, dp[i][0]);

        }

        return Math.max(dp[m-1][0], dp[m-1][1]);
    }
}


//https://www.youtube.com/watch?v=xrB8KOfrJCA