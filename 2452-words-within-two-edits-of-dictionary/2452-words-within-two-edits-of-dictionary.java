class Solution {
    public List<String> twoEditWords(String[] query, String[] dic) {
        int qsize = query.length;
        int dsize = dic.length;

        List<String> ans = new ArrayList<>();

        for(int i=0; i<qsize; i++){
            String a = query[i];
            for(int j=0; j<dsize; j++){
                String b = dic[j];
                int diff = 0;
                int n = b.length();

                for(int k=0; k<n; k++){
                    if(a.charAt(k) != b.charAt(k)){
                        diff ++;
                    }
                } 
                if(diff<=2){
                    ans.add(a);
                    break;
                }
            }
        }
        return ans;
    }
}