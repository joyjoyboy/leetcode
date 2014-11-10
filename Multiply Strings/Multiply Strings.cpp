class Solution {
public:

    void addVec(std::vector<int>& v1, std::vector<int>& v2){
        int v1_len = v1.size();
        int v2_len = v2.size();
        if(v1_len >= v2_len){
            int carry = 0;
            for(unsigned int i = 0; i < v2_len; ++i){
                v1[i] += v2[i];
                v1[i] += carry;
                carry = v1[i] / 10;
                v1[i] = v1[i] % 10;
            }
            for(unsigned int i = v2_len; i < v1_len; ++i){
                v1[i] += carry;
                carry = v1[i] / 10;
                v1[i] = v1[i] % 10;
                if(!carry)      break;
            }
            if(carry){
                v1.push_back(carry);
            }
        }
        else{
            for(unsigned int i = v1_len; i < v2_len; ++i){
                v1.push_back(v2[i]);
            }
            
            int carry = 0;
            for(unsigned int i = 0; i < v2_len; ++i){
                if(i < v1_len){
                    v1[i] += v2[i];
                }
                v1[i] += carry;
                carry = v1[i] / 10;
                v1[i] = v1[i] % 10;
                if((i >= v1_len) && (!carry))       break;
            }
            if(carry){
                v1.push_back(carry);
            }
        }
        return;
    }

    string multiply(string num1, string num2) {
        std::vector<std::vector<int> >  res;
        std::string                     ret;
        
        // Case 0 handling
        if(((num1.size() == 1) && (num1[0] == '0')) || ((num2.size() == 1) && (num2[0] == '0'))){
            ret.push_back('0');
            return ret;
        }
        
        // ATTENTION:
        // In string, MSB takes the smallest index
        // In vector, LSB takes the smallest index, for convenience
        for(int i = num1.size() - 1; i >= 0; --i){
            int number1 = (num1[i] - '0');
            int carry = 0;
            std::vector<int>    tmpResult;
            
            for(int j = num2.size() - 1; j >= 0; --j){
                int number2 = (num2[j] - '0');
                int result = number1 * number2 + carry;
                carry = result / 10;
                result = result % 10;
                tmpResult.push_back(result);
            }
            if(carry){
                tmpResult.push_back(carry);
            }
            
            int count = num1.size() - i - 1;
            while(count--){
                tmpResult.insert(tmpResult.begin(), 0);
            }
            
            res.push_back(tmpResult);
        }
        
        for(unsigned int i = 1; i < res.size(); ++i){
            addVec(res[0], res[i]);
        }
        
        for(unsigned int i = 0; i < res[0].size(); ++i){
            char insertion = res[0][i] + '0';
            ret.insert(ret.begin(), insertion);
        }
        
        return ret;
    }
};
