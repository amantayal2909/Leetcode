class Solution {
public:
    string maximumOddBinaryNumber(string st) {
        int s=st.size();
        
        int count1=0;
        int count0=0;
        
        for(int i=0;i<s;i++){
            if(st[i]=='0')
                count0++;
            else
                count1++;
        }
        string ans="1";
        
        ans=string(count0,'0')+ans;
        count1--;
        ans=string(count1,'1')+ans;
        
        return ans;
         
    }
};