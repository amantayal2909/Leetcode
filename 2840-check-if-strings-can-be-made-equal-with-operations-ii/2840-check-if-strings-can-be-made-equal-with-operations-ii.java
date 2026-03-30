class Solution {
    public boolean checkStrings(String s1, String s2) {
        int size = s1.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<size;i=i+2){
            char ch = s1.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }

        for(int i=0;i<size;i=i+2){
            char ch = s2.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>0){
                map.put(ch,map.get(ch)-1);
            }
            else{
                return false;
            }
        }
        map.clear();

        for(int i=1;i<size;i=i+2){
            char ch = s1.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }

        for(int i=1;i<size;i=i+2){
            char ch = s2.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>0){
                map.put(ch,map.get(ch)-1);
            }
            else{
                return false;
            }
        }



        return true;
    }
}