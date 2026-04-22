// class Solution {
//     public List<String> twoEditWords(String[] query, String[] dic) {
//         int qsize = query.length;
//         int dsize = dic.length;

//         List<String> ans = new ArrayList<>();

//         for(int i=0; i<qsize; i++){
//             String a = query[i];
//             for(int j=0; j<dsize; j++){
//                 String b = dic[j];
//                 int diff = 0;
//                 int n = b.length();

//                 for(int k=0; k<n; k++){
//                     if(a.charAt(k) != b.charAt(k)){
//                         diff ++;
//                     }
//                     if (diff > 2) break;
//                 } 
//                 if(diff<=2){
//                     ans.add(a);
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }



class Solution {
    public class Trie{
        Trie child [] = new Trie[26];
        boolean end = false; 
    }
    

    public void insert(Trie node, String a){
        int size = a.length();
        for(int i = 0 ; i<size ; i++){
            char c = a.charAt(i);

            if(node.child[c - 'a']== null){
                node.child[c-'a'] = new Trie();
            }
            node = node.child[c - 'a'];
        }

        node.end = true;
    }
    public int traverse(String a, int index, Trie node, int diff){
        if(diff>2) return diff;
        if(index == a.length()) return diff;
        
        char ch = a.charAt(index);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {

            if (node.child[i] != null) {

                int newDiff = diff;

                if (i != (ch - 'a')) {
                    newDiff++;
                }

                int res = traverse(a, index + 1, node.child[i], newDiff);

                minDiff = Math.min(minDiff, res);
            }
        }

        return minDiff;
    }

    public List<String> twoEditWords(String[] query, String[] dic) {
        int qsize = query.length;
        int dsize = dic.length;

        Trie root = new Trie();

        for(int j=0; j<dsize; j++){
            insert(root,dic[j]);
        }

        List<String> ans = new ArrayList<>();
        int diff = 0;

        for(int i=0; i<qsize; i++){
            String a = query[i];
            diff = 0;
            diff = traverse(a,0,root,0);
            if(diff<=2)
            {
                ans.add(a);
            }
            
        }
        return ans;
    }
}


