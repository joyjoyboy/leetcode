public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int accu = (A[0] > 0) ? A[0] : 0;
        for(int i = 1; i < A.length; ++i){
            if(A[i] < 0){
                max = Math.max(max, A[i]);
                accu += A[i];
                accu = (accu > 0) ? accu : 0;
            }
            else{
                accu += A[i];
                max = Math.max(max, accu);
            }
        }
        
        return max;
    }
}
