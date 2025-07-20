class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> v = new ArrayList<>();
        List<Integer> a= new ArrayList<>();
        a.add(1);
        v.add(a);
        
        for (int i = 1; i < n; i++) {

            List<Integer> row = new ArrayList<>(i + 1);
            row.set(0,1);
            row.set(i,1);
    
            for (int j = 1; j < i; j++) {
                
                row.set(j,v.get(i-1).get(j-1) + v.get(i-1).get(j));
            }
            v.add(row);
        }
        return v;
    }
}