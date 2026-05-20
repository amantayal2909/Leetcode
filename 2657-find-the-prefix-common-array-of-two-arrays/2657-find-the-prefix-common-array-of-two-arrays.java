class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer,Integer> map_a = new HashMap<>();
        HashMap<Integer,Integer> map_b = new HashMap<>();

        int size = A.length;
        int ans[] = new int[size];
        int count = 0;

        for(int i=0; i<size; i++){
            if(A[i]==B[i]){
                map_a.put(A[i],0);
                map_b.put(B[i],0);
                count++;
                ans[i] = count;
            }
            else{
                if(map_b.containsKey(A[i])){
                    count++;
                }
                map_a.put(A[i],0);
                if(map_a.containsKey(B[i])){
                    count++;
                }
                map_b.put(B[i],0);
                ans[i] = count;
            }
        }

        return ans;
    }
}