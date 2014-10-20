class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Nothing is nothing
        if(prices.empty())      return 0;
        // No difference, no gain
        if(prices.size() == 1)  return 0;
        
        int buy = 0;
        int max = 0;
        
        for(unsigned int i = 0; i < prices.size(); ++i){
            // Get the lowest buying price
            if(prices[i] < prices[buy]){
                buy = i;
            }
            max = (prices[i] - prices[buy]) > max ? (prices[i] - prices[buy]) : max;
        }
        
        return max;
    }
};
