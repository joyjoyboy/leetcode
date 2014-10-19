class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        profit = 0
        for i in range(len(prices)):
            if(i == len(prices) - 1):
                continue
            if(prices[i] < prices[i + 1]):
                profit += prices[i + 1] - prices[i]
        return profit
