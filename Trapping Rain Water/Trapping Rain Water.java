public class Solution {
    public int trap(int[] A) {
        
        if(A.length <= 2)       return 0;
        
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        
        maxLeft[0] = 0;
        for(int i = 1; i < A.length; ++i){
            maxLeft[i] = Math.max(maxLeft[i - 1], A[i - 1]);
        }
        
        maxRight[A.length - 1] = 0;
        for(int i = A.length - 2; i >= 0; --i){
            maxRight[i] = Math.max(maxRight[i + 1], A[i + 1]);
        }
        
        int ret = 0;
        for(int i = 0; i < A.length; ++i){
            int min = Math.min(maxLeft[i], maxRight[i]);
            if(min > A[i]){
                ret += min - A[i];
            }
        }
        
        return ret;
    }
}
