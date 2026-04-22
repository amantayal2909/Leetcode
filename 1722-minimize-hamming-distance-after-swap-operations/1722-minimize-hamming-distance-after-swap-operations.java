class Solution {
    class DSU{
       int parent[];
       int rank[];
       int n;

       public DSU(int size){
        parent = new int[size];
        this.n = size;
        rank = new int[size];
        for(int i=0 ;i<size; i++){
            parent[i]=i;
        }
       } 

       public int find_parent(int i){
        if(parent[i]==i)return i;

        return parent[i]=find_parent(parent[i]);
       }

        public void union_dsu(int i, int j){
        int x = find_parent(i);
        int y = find_parent(j);

        if(x==y)return;

        int rank_x= rank[x];
        int rank_y= rank[y];

        if(rank_x == rank_y){
            parent[x] = y;
            rank[y]++;

        }else if(rank_x> rank_y){
            parent[y] = x;

        }else{
            parent[x] = y;
        }

       }


    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int size = source.length;
        int ans=0;
        DSU d = new DSU(size);

        for(int i=0; i<allowedSwaps.length; i++){
            d.union_dsu(allowedSwaps[i][0], allowedSwaps[i][1]);
        }

        HashMap <Integer, HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=0 ;i<source.length; i++){
            int val = source[i];
            int parent = d.find_parent(i);

            if(!map.containsKey(parent)){
                map.put(parent,new HashMap<>());
            }

            HashMap<Integer,Integer> inside = map.get(parent);
            inside.put(val, inside.getOrDefault(val, 0) + 1);
        }

        for(int i=0 ;i<source.length; i++){
            int val = target[i];
            int parent = d.find_parent(i);

            HashMap<Integer,Integer> inside = map.get(parent);

            if(inside.containsKey(val) && inside.get(val) >0)
            {
               inside.put(val, inside.get(val) - 1); 
            }
            else
            {
                ans ++;
            }  

        }


        return ans;
    }
}