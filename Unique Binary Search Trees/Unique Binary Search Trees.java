public class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        else{
            int res = 0;
            for(int i = 0; i < n; ++i){
                res += numTrees(i) * numTrees(n - i - 1);
            }
            return res;
        }
    }
}
