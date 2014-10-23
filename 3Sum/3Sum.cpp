class Solution {
public:

    void Sort(std::vector<int>& in){
        for(unsigned int i = 1; i < in.size(); ++i){
            for(unsigned int j = 0; j < i; ++j){
                if(in[j] > in[i]){
                    int tmp = in[j];
                    in[j] = in[i];
                    in[i] = tmp;
                }
            }
        }
    }

    vector<vector<int> > threeSum(vector<int> &num) {
        std::vector<std::vector<int> >  res;
        
        if(num.size() < 3){
            return res;
        }
        
        Sort(num);
        
        for(unsigned int i = 0; i < num.size() - 2; ++i){
            
            int start = i + 1;
            int end = num.size() - 1;
            int target = -num[i];
            while(start < end){
                int sum = num[start] + num[end];
                if(sum == target){
                    std::vector<int>    element;
                    std::vector<int>    prev;
                    
                    if(!res.empty()){
                        prev = res[res.size() - 1];
                        if((prev[0] == num[i]) && (prev[1] == num[start]) && (prev[2] == num[end])){
                            ++start;
                            --end;
                            continue;
                        }
                    }
                    
                    element.push_back(num[i]);
                    element.push_back(num[start]);
                    element.push_back(num[end]);
                    res.push_back(element);
                    
                    ++start;
                    --end;
                    
                }
                else if(sum < target){
                    ++start;
                }
                else{
                    --end;
                }
            }
            // Weird
            // This exception could be implicitly handled inside, but it would not pass the test
            // Explicit handling could save time
            while(num[i] == num[i + 1]){
                ++i;
            }
        }
        return res;
    }
};
