public class Solution {
    public int largestRectangleArea(int[] height) {
        
        // This stack stores indices only
        // Maintain a monotonically increasing stack
        Stack<Integer> s = new Stack<Integer>();
        int everMax = 0;
        
        if(height.length == 0){
            return 0;
        }
        
        for(int i = 0; i < height.length;){
            // Current element is greater than previous one in the stack
            if(s.isEmpty() || height[i] >= height[s.peek()]){
                s.push(i);
                ++i;
            }
            // Current element is not greater than previous one in the stack
            // Elements in the stack that is greater than current element will be popped out
            else{
                // This denotes the height of current rectangle
                int heightIndex = s.pop();
                // This denotes the start of the length of current rectangle
                int prevIndex = (s.isEmpty()) ? -1 : s.peek();
                do{
                    // The width spreads from prevIndex to current index (minus 1)
                    int width = i - 1 - prevIndex;
                    everMax = Math.max(everMax, height[heightIndex] * width);
                    if(s.isEmpty() || height[s.peek()] < height[i]){
                        break;
                    }
                    heightIndex = s.pop();
                    prevIndex = (s.isEmpty()) ? -1 : s.peek();
                }while(height[heightIndex] >= height[i]);
                s.push(i);
                ++i;
            }
        }
        
        do{
            int heightIndex = s.pop();
            int prevIndex = (s.isEmpty()) ? -1 : s.peek();
            int width = height.length - 1 - prevIndex;
            everMax = Math.max(everMax, height[heightIndex] * width);
        }while(!s.isEmpty());
        
        return everMax;
    }
}
