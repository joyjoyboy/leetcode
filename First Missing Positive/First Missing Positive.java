public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length;){
            if(A[i] > 0 && A[i] <= A.length && A[i] != i + 1 && A[i] != A[A[i] - 1]){
                int temp = A[i];
                A[i] = A[A[i] - 1];
                A[temp - 1] = temp;
            }
            else{
                ++i;
            }
        }
        for(int i = 0; i < A.length; ++i){
            if(A[i] != i + 1){
                return i + 1;
            }
        }
        return (A.length == 0) ? 1 : A.length + 1;
    }
}
