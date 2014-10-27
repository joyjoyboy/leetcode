class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        int start = -1;
        int end = start;
        
        bool startFlag = false;
        for(unsigned int i = 0; i < n; ++i){
            if(A[i] == target){
                if(!startFlag){
                    startFlag = true;
                    start = i;
                    end = i;
                }
                else{
                    end = i;
                }
            }
            else{
                // Do nothing
            }
        }
        
        std::vector<int> ret;
        ret.push_back(start);
        ret.push_back(end);
        
        return ret;
    }
};
