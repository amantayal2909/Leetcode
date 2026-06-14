class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        for(int i=0; i<words.length; i++){
            String a = words[i];

            int sum = 0;
            
            for(int j=0; j<a.length(); j++){
                int count = a.charAt(j) - 'a';
                sum += weights[count];
            }

            sum = sum % 26;
            sum = 26-sum -1;

            char ch = (char)(sum + 'a');
            ans = ans + ch;

        }

        return ans;
    }
}