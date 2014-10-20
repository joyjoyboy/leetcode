public class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < right){
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            ret = Math.max(ret, width * h);
            if(height[left] < height[right])        ++left;
            else                                    --right;
        }
        
        return ret;
    }
}
