class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        row = len(grid)
        if row == 0:
            return 0
        col = len(grid[0])
        dp = list()
        for i in xrange(0, row):
            dp.append(list())
            for j in xrange(0, col):
                if i == 0 and j == 0:
                    dp[i].append(grid[i][j])
                elif i == 0:
                    dp[i].append(dp[i][j - 1] + grid[i][j])
                elif j == 0:
                    dp[i].append(dp[i - 1][j] + grid[i][j])
                else:
                    dp[i].append(min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j])
        return dp[row - 1][col - 1]
