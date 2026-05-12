class Solution {
    public int minimumEffort(int[][] tasks) {
       // Arrays.sort(tasks, (a,b)-> Integer.compare(b[1],a[1]));

        Arrays.sort(tasks, (a,b) ->  Integer.compare( (b[1] - b[0]), (a[1] - a[0]) ) );
        int n = tasks.length;

        System.out.println(Arrays.deepToString(tasks));

        int total_energy = 0;
        int left_energy = 0;
        
        for(int i=0; i<n; i++){
            int consume = tasks[i][0];
            int require = tasks[i][1];

            if(require> left_energy){
                int diff = require - left_energy;
                total_energy += diff;
                left_energy += diff;
            }

            left_energy -= consume;


        }
        return total_energy;
    }
}