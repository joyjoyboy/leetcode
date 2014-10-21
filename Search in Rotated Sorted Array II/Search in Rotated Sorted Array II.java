public class Solution {
    public boolean search(int[] A, int target) {
        int head = 0;
        int end = A.length - 1;
        
        while(A[head] == A[end]){
            --end;
            if(end < 0){
                return target == A[0];
            }
        }
        
        while(head <= end){
            int mid = head + end;
            mid /= 2;
            
            if(target == A[mid])        return true;
            else if(target < A[mid]){
                if((A[head] < A[mid] && target >= A[head]) || (A[head] > A[mid] && target < A[head])){
                    end = mid - 1;
                }
                else{
                    head = mid + 1;
                }
            }
            else{   // target > A[mid]
                if((A[mid] < A[end] && target <= A[end]) || (A[mid] > A[end] && target > A[end])){
                    head = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
