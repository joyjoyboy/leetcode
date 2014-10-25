public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0)         return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for(int i = 0; i < obstacleGrid.length; ++i){
            for(int j = 0; j < obstacleGrid[0].length; ++j){
                if(i == 0 && j == 0){
                    if(obstacleGrid[i][j] == 1)     dp[i][j] = 0;
                    else                            dp[i][j] = 1;
                }
                else if(i == 0){
                    if(obstacleGrid[i][j] == 1)     dp[i][j] = 0;
                    else                            dp[i][j] = dp[i][j - 1];
                }
                else if(j == 0){
                    if(obstacleGrid[i][j] == 1)     dp[i][j] = 0;
                    else                            dp[i][j] = dp[i - 1][j];
                }
                else{
                    if(obstacleGrid[i][j] == 1)     dp[i][j] = 0;
                    else                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
