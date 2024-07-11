class Solution {
public:
    string reverseParentheses(string s) {
        stack<char> st;

        //string ans="";
        string bns="";

        for(int i=0 ;i<s.size();i++){
            if(s[i]==')'){
            string ans="";
            while(st.top()!='('){
                ans=ans+st.top();
                st.pop();
            } 
            st.pop();
            if(st.size()!=0){
                for(int j=0; j<ans.size();j++)
                    st.push(ans[j]);
            }        
            else
            return ans;    
            }
            
            else{
                st.push(s[i]);
            }
        }

        for(; st.size()!=0;){
        bns+=st.top();
        st.pop();
        }
                  //  st.push(ans[j]);
        return bns;
    }
};