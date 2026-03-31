class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char word[] = new char[n+m-1];
        Arrays.fill(word,'$');

        boolean canChange[] = new boolean[n+m-1];
        Arrays.fill(canChange,false);

        for(int i=0;i<n;i++){
            if(str1.charAt(i) == 'T'){
                for(int j=0;j<m;j++){
                    if(((i+j)> (n+m-1)) || ((word[i+j] != '$') && (word[i+j]!=str2.charAt(j)))){
                        return "";
                    }
                    word[i+j]=str2.charAt(j);
                }
            }
        }

        for(int i=0;i<(n+m-1);i++){
            if(word[i] == '$') 
            {
                word[i]= 'a';
                canChange[i] = true;
            }
        }
        
        
        for(int i=0;i<n;i++){
            if(str1.charAt(i) == 'F'){

                boolean allok = false;
                boolean corrected = false;
                for(int j=0;j<m;j++){
                    if(word[i+j]!=str2.charAt(j)){
                        allok = true;
                        break;
                    }
                }

                if(allok == false){
                    for(int j= i+m -1 ; j>= i ;j--){
                        if(canChange[j] == true){
                            word[j] = 'b';
                            corrected = true;
                            break;

                        }
                    }

                    if(corrected == false)
                    return "";
                }


            }
        }

        return new String(word);
    }
}