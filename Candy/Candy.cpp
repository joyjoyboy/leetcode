class Solution {
public:
    int candy(vector<int> &ratings) {
        int total = 0;
        std::vector<int> alloc;
        alloc.push_back(1);
        for(int i = 0; i < ratings.size() - 1; ++i){
            
            if(ratings[i + 1] > ratings[i]){
                int next = alloc.back() + 1;
                alloc.push_back(next);
            }
            else{
                alloc.push_back(1);
            }
            
        }
        
        for(int i = ratings.size() - 1; i > 0; --i){
            if(ratings[i] < ratings[i - 1]){
                if(alloc[i] >= alloc[i - 1]){
                    alloc[i - 1] = alloc[i] + 1;
                }
            }
            total += alloc[i];
        }
        total += alloc[0];
        
        return total;
    }
};
