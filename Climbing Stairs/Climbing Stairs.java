public class Solution {
    public int climbStairs(int n) {
        // DP
        // res[n] = res[n - 1] + res[n - 2]
        // res[0] = 1
        // res[1] = 1
        // res[2] = 2......
		// So easy and simple
        
        if(n < 2){
            return 1;
        }
        
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; ++i){
            res[i] = res[i - 1] + res[i - 2];
        }
        
        return res[n];
    }
}
