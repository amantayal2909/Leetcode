class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == 'b' || text.charAt(i) == 'a' || text.charAt(i) == 'l'
                    || text.charAt(i) == 'o' || text.charAt(i) == 'n'){
                map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) +1);

            }
        }
        int ans = 0;
        int b = map.getOrDefault('b', 0);
        ans = Math.min(b, map.getOrDefault('a', 0));

        ans = Math.min(ans, map.getOrDefault('l', 0)/2);
        ans = Math.min(ans, map.getOrDefault('o', 0)/2);

        ans = Math.min(ans, map.getOrDefault('n', 0));





        return ans;


    }
}