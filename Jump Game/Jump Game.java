public class Solution {
    public boolean canJump(int[] A) {
        if(A.length == 0)       return false;
        else if(A.length == 1)  return true;
        
        int max = A[0];
        for(int i = 0; i < A.length - 1; ++i){
            max = Math.max(max, i + A[i]);
            if(max < i + 1)         return false;
            else if(max >= A.length - 1)        return true;
        }
        
        return true;
    }
}
