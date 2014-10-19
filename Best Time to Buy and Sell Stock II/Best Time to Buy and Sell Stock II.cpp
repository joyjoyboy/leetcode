class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if(prices.empty())  return 0;
        if(prices.size() == 1)  return 0;
        int profit = 0;
        for(unsigned int i = 0; i < prices.size() - 1; ++i){
            if(prices[i + 1] > prices[i])
                profit += prices[i + 1] - prices[i];
        }
        return profit;
    }
};
