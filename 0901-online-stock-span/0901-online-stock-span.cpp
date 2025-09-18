class StockSpanner {
public:
    stack <pair<int,int>> s;
    StockSpanner() {
        
    }
    
    int next(int price) {
        if(s.size()==0)
        {
            s.push({1,price});
            return 1;
        }
        int span=1;
        while(s.size()!=0 && s.top().second <=price)
        {
            span+= s.top().first;
            s.pop();
        }
        s.push({span,price});
        return span;

    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */