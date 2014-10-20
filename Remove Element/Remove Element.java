public class Solution {
    public int removeElement(int[] A, int elem) {
        int swapPtr = A.length - 1;
        if(swapPtr < 0){
            return 0;
        }
        while(A[swapPtr] == elem){
            --swapPtr;
            if(swapPtr < 0){
                break;
            }
        }
        for(int i = 0; i <= swapPtr;){
            if(A[i] == elem){
                int temp = A[i];
                A[i] = A[swapPtr];
                A[swapPtr] = temp;
                --swapPtr;
            }
            else{
                ++i;
            }
        }
        return swapPtr + 1;
    }
}
