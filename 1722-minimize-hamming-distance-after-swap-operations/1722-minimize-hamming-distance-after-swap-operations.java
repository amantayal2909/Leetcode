class Solution {
    public class DSU{
        int parent[];
        int rank[];
        int n;

        public DSU(int n){
            parent = new int[n];
            this.n = n;
            rank = new int[n];

            for(int i=0; i<n; i++)parent[i]=i;
        }

        public int find_parent(int x){
            if(parent[x] == x) return x;

            return parent[x] = find_parent(parent[x]);
        }

        public void union(int x, int y){
            int parentx = find_parent(x);
            int parenty = find_parent(y);

            if(parentx==parenty) return;

            int rankx = rank[parentx];
            int ranky = rank[parenty];

            if(rankx == ranky){
                parent[parentx] = parenty;
                rank[parenty]++;
            }
            else if(rankx > ranky){
                parent[parenty] = parentx;
                
            }
            else{
                parent[parentx] = parenty;
            }
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int ans = 0;

        DSU d1 = new DSU(n);
        for(int i=0; i<allowedSwaps.length; i++){
            d1.union(allowedSwaps[i][0], allowedSwaps[i][1]);
        }

        HashMap<Integer, HashMap<Integer,Integer>> group = new HashMap<>();

        for(int i=0; i<n; i++){
            int value = source[i];
            int parent = d1.find_parent(i);

            if(!group.containsKey(parent))
                group.put(parent, new HashMap<>());

            HashMap<Integer, Integer> inside = group.get(parent);

            inside.put(value, inside.getOrDefault(value,0)+1);
        }

        for(int i=0; i<n; i++){
            int value = target[i];
            int parent = d1.find_parent(i);

            HashMap<Integer, Integer> inside = group.get(parent);

            if(inside.containsKey(value) && inside.get(value)> 0){
                inside.put(value, inside.get(value)-1 );
            }
            else ans++;
            
        }



        return ans;

    }
}