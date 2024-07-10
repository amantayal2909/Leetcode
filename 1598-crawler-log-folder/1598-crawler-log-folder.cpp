class Solution {
public:
    int minOperations(vector<string>& logs) {
        int main=1;

        for(int i=0 ;i <logs.size();i++){
            string a=logs[i];
            if(a == "../"){
                if(main>1)
                  main--;
            }else if(a == "./"){   
            continue;
            }else{
            main++;
            }
           
        }
        
        return main-1;
    }
};