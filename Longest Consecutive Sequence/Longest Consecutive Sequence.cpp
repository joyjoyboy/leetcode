class Solution {
public:
    int longestConsecutive(vector<int> &num) {
        std::map<int, int>  container;
        for(unsigned int i = 0; i < num.size(); ++i){
            container.insert(std::pair<int, int>(num[i], i));
        }
        
        int greaterThan = 0;
        int lessThan = 0;
        int max = INT_MIN;
        for(unsigned int i = 0; i < num.size(); ++i){
            if(container.find(num[i]) != container.end()){
                int increment = 1;
                while(container.find(num[i] + increment) != container.end()){
                    container.erase(container.find(num[i] + increment));
                    ++increment;
                    ++greaterThan;
                }
                int decrement = 1;
                while(container.find(num[i] - decrement) != container.end()){
                    container.erase(container.find(num[i] - decrement));
                    ++decrement;
                    ++lessThan;
                }
                max = (max > (greaterThan + lessThan + 1)) ? max : (greaterThan + lessThan + 1);
            }
            greaterThan = 0;
            lessThan = 0;
        }
        return max;
    }
};
