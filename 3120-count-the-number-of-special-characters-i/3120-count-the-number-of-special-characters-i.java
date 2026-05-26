class Solution {
    public int numberOfSpecialChars(String word) {
        int fre[] = new int[26];
        int fre1[] = new int[26];

        Arrays.fill(fre,0);
        Arrays.fill(fre1,0);

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(c>= 97 && c<=122) fre[c-'a'] =1;
            if(c>=65 && c<=90) fre1[c-'A'] = 1;
        }

        int count =0;

        for(int i=0; i<26; i++){
            if(fre[i] ==1 && fre1[i] ==1) count++;
        }

        return count;

    }
}