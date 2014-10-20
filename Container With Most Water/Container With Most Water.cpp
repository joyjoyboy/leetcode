class Solution {
public:

    int min(int left, int right){
        if(left < right)    return left;
        else                return right;
    }
    
    int max(int left, int right){
        if(left > right)    return left;
        else                return right;
    }

    int maxArea(vector<int> &height) {
        // 3 elements is the minimum requirement for forming a container
        if(height.size() < 2)       return 0;
        
        int leftIndex = 0;
        int rightIndex = height.size() - 1;
        
        int currVol = 0;
        int maxVol = 0;
        
        while(leftIndex < rightIndex){
            
            currVol = (rightIndex - leftIndex) * min(height[leftIndex], height[rightIndex]);
            maxVol = max(maxVol, currVol);
            
            if(height[leftIndex] <= height[rightIndex]){
                leftIndex++;
            }
            else{
                rightIndex--;
            }
        }
        
        return maxVol;
    }
};
