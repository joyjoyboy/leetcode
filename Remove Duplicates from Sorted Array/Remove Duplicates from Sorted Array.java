public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len == 0 || len == 1){
            return len;
        }
        
        int firstIndex = 0;
        int secondIndex = 1;
        while(secondIndex < len){
            if(A[firstIndex] == A[secondIndex]){
                // Do nothing
            }
            else{
                ++firstIndex;
                A[firstIndex] = A[secondIndex];
            }
            ++secondIndex;
            
        }
        return firstIndex + 1;
    }
}
