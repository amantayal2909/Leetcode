class Solution { //techdose
    public long solve(List<Integer> robot, int left,List<Integer> factory, int right, long dp[][]){
        if(left <0)return 0;
        if(right <0) return (long)1e15;

        if(dp[left][right] != -1) return dp[left][right] ;

        long left_tree = solve(robot, left, factory, right-1, dp);
        long right_tree = Math.abs(robot.get(left)-factory.get(right)) + solve(robot, left-1, factory, right-1, dp);

        dp[left][right] = Math.min(left_tree,right_tree);
        return dp[left][right] ;

    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        int left = robot.size();

        Arrays.sort(factory, (a,b)-> a[0]-b[0]);

        List<Integer> factories  = new ArrayList<>();
        for(int i=0;i<factory.length;i++){
            int count = factory[i][1];
            int pos = factory[i][0];
            for(int j=0; j<count ;j++){
                factories.add(pos);
            }

        }
        int right = factories.size();
        long dp[][] = new long[left][right];
        for (int i = 0; i < left; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(robot, left-1, factories, right-1, dp);

    }
}