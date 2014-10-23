public class Solution {
    public int removeDuplicates(int[] A) {

        if(A.length <= 1)       return A.length;

        int prev = A[0];
        int currIndex = 0;
        boolean twice = false;
        
        for(int i = 1; i < A.length; ++i){
            if(A[currIndex] == A[i]){
                if(twice){
                    
                }
                else{
                    twice = true;
                    ++currIndex;
                    A[currIndex] = A[i];
                }
            }
            else{
                twice = false;
                ++currIndex;
                A[currIndex] = A[i];
            }
        }
        
        return currIndex + 1;
    }
}
