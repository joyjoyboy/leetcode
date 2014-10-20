class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        vector<vector<int> > res;
        int count = 0;
        while(count++ < numRows){
            vector<int>     element;
            if(count == 1){
                element.push_back(1);
            }
            else if(count == 2){
                element.push_back(1);
                element.push_back(1);
            }
            else{
                element.push_back(1);
                for(int i = 0; i < count - 2; ++i){
                    element.push_back(res[count - 2][i] + res[count - 2][i + 1]);
                }
                element.push_back(1);
            }
            res.push_back(element);
        }
        return res;
    }
};
