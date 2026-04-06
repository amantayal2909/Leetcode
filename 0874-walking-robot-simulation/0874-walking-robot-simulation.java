class Solution {
    public int robotSim(int[] cmd, int[][] obs) {
        int m = cmd.length;
        int n = obs.length;
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(new Pair<>(obs[i][0],obs[i][1]), 1);
        }

        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;

        int x =0, y=0, ans =0;
        int xd=0, yd=1; // north

        for(int i=0;i<m;i++){
            if(cmd[i]== -1){
                d = (d+1)%4;
                xd = dir[d][0];
                yd = dir[d][1];
            }
            else if(cmd[i]==-2){
                d = (d+3)%4;
                xd = dir[d][0];
                yd = dir[d][1];
            }
            else{
                for(int j=1;j<=cmd[i];j++){
                    if(map.containsKey(new Pair<>(x+xd,y+yd))) break;

                    x= x+xd;
                    y= y+yd;

                    ans = Math.max(ans, (x*x + y*y));
                }
            }

        }

        return ans;
    }
}