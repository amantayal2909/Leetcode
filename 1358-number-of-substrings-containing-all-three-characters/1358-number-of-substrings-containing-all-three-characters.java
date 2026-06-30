// class Solution {
//     public int numberOfSubstrings(String s) {
        
//         int l = s.length();
//         int count = 0;

//         for(int i=0; i<l; i++){
            

//             for(int j=i+2; j<l; j++){
//                 String a = s.substring(i, j + 1);

//                 if(a.contains("a") && a.contains("b") && a.contains("c")){
//                     count += (l-j);
//                     break;
//                 }
//             }
//         }

//         return count;


//     }
// }



class Solution {
    public int numberOfSubstrings(String s) {
        
        int l = s.length();
        int count = 0;
        int fre[] = new int[3];
        int left = 0;

        for(int i=0; i<l; i++){
            fre[s.charAt(i) - 'a']++;

            while(fre[0]>0 && fre[1]>0 && fre[2]>0){
                count += (l-i);
                fre[s.charAt(left) - 'a'] --;
                left ++;
            }

            
        }

        return count;


    }
}



