class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(c>= 97 && c<=122) {
                map.put(c,i);
            }

        }
        int count = 0;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(c>= 65 && c<=90) {
                char lower = Character.toLowerCase(c);

                if(map.containsKey(lower)){
                    int val = map.get(lower);

                    if(val<i) count++;
                    map.remove(lower);
                }
            }
        }

        return count;




    }
}