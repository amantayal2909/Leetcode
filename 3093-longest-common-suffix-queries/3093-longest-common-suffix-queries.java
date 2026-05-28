class Solution {
    class Trie{
        Trie children[];
        int length;
        int index;

        public Trie(){
            children = new Trie[26];
            this.length = Integer.MAX_VALUE;
            this.index = -1;
        }

        public void insert(int index, int length, String word){
            Trie node = this;
            for(int i=0; i<length; i++){
                int alpha = word.charAt(i) - 'a';

                if(node.children[alpha] == null){
                    node.children[alpha] = new Trie();
                }

                node = node.children[alpha];
                
                if(node.length > length){
                    node.length = length;
                    node.index = index;
                }
                else if(node.length == length){
                    node.index = node.index<index ? node.index : index;
                }
                
            }
        }

        public int search(int length, String word){
            Trie node = this;
            for(int i=0; i<length; i++){
                int alpha = word.charAt(i) - 'a';

                if(node.children[alpha] == null){
                    break;
                }

                node = node.children[alpha];
                
            }

            return node.index;
        }



    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        
        int size = wordsContainer.length;
        Trie root = new Trie();
        int smalllength = Integer.MAX_VALUE;
        int smallindex = 0;

        for(int i=0;i<size; i++){
            
            String word = new StringBuilder(wordsContainer[i]).reverse().toString();
            int length = word.length();
            root.insert(i, length, word);

            if(smalllength > length){
                smalllength = length;
                smallindex = i;
            }

        }

        size = wordsQuery.length;
        int ans[] = new int[size];

        for(int i=0;i<size; i++){
            
            String word = new StringBuilder(wordsQuery[i]).reverse().toString();
            int length = word.length();
            int index = root.search(length, word);

            if(index == -1)ans[i] = smallindex;
            else
                ans[i] = index;

        }

        return ans;
    }
}