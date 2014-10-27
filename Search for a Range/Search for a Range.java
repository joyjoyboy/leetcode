public class Solution {
    public int[] searchRange(int[] A, int target) {
        int len = A.length;
        int[] res = new int[2];
        
        int start = 0;
        int end = len - 1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if(A[mid] == target){
                int left = mid - 1;
                int right = mid + 1;
                while(left >= 0 && A[left] == target)           --left;
                while(right <= len - 1 && A[right] == target)   ++right;
                res[0] = left + 1;
                res[1] = right - 1;
                return res;
            }
            else if(A[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        res[0] = -1;
        res[1] = -1;
        return res;
        
    }
}
