public class Solution {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        
        while(start <= end){
            int mid = start + end;
            mid /= 2;
            boolean leftRotated = false;
            boolean rightRotated = false;
            if(A[start] > A[mid])            leftRotated = true;
            if(A[mid] > A[end])        rightRotated = true;
            
            if(A[mid] == target){
                return mid;
            }
            else if(A[mid] < target){
                if(leftRotated){
                    if(A[start] <= target){
                        end = mid - 1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(rightRotated){
                    if(A[end] >= target){
                        start = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
