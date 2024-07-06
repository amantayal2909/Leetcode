class Solution {
public:
    int passThePillow(int n, int time) {
        //return 0;


        // 1 2 3 4    5 4 3 2    1 2 3 4    5 4 3 2

        int slot=time/(n-1);

        if(slot%2==0){
            return time%(n-1) +1;
        }
        else
        return n-time%(n-1);

    }
};