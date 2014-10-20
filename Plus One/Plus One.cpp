class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {

        bool overflow = true;
        for(int i = digits.size() - 1; i >= 0; --i){
            if(digits[i] < 9){
                digits[i]++;
                overflow = false;
                break;
            }
            else{
                digits[i] = 0;
            }
        }
        if(overflow){
            digits.push_back(0);
            for(unsigned int i = 0; i < digits.size(); ++i){
                if(!i)      digits[i] = 1;
                else        digits[i] = 0;
            }
        }
        return digits;

    }
};
