public class Solution {
    public int maxProfit(int[] prices) {
        if((prices.length == 0) || (prices.length == 1)){
            return 0;
        }
        
        int max = 0;
        int buy = 0;
        
        int[] forward = new int[prices.length];
        int[] reverse = new int[prices.length];
        
        // First iteration
        for(int i = 0; i < prices.length - 1; ++i){
            if(prices[i] < prices[buy]){
                buy = i;
            }
            max = (max > prices[i] - prices[buy]) ? max : (prices[i] - prices[buy]);
            forward[i] = max;
        }
        
        max = 0;
        int sell = prices.length - 1;
        
        // Second iteration
        for(int i = prices.length - 1; i >= 0; --i){
            if(prices[i] > prices[sell]){
                sell = i;
            }
            max = (max > prices[sell] - prices[i]) ? max : (prices[sell] - prices[i]);
            reverse[i] = max;
        }
        
        max = 0;
        // Third iteration
        for(int i = 0; i < prices.length; ++i){
            max = (max > forward[i] + reverse[i]) ? max : (forward[i] + reverse[i]);
        }
        
        return max;
    }
}
