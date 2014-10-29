class Solution {
public:
    string addBinary(string a, string b) {
        std::stack<bool> first;
        std::stack<bool> second;
        
        for(unsigned int i = 0; i < a.size(); ++i){
            first.push((a[i] == '1') ? true : false);
        }
        for(unsigned int i = 0; i < b.size(); ++i){
            second.push((b[i] == '1') ? true : false);
        }
        
        std::stack<bool> res;
        bool op1;
        bool op2;
        bool carry = false;
        while(!first.empty() && !second.empty()){
            op1 = first.top();
            op2 = second.top();
            first.pop();
            second.pop();
            if(op1 && op2 && carry){
                res.push(true);
                carry = true;
            }
            else if((op1 && op2) || (op1 && carry) || (op2 && carry)){
                res.push(false);
                carry = true;
            }
            else if(op1 || op2 || carry){
                res.push(true);
                carry = false;
            }
            else{
                res.push(false);
                carry = false;
            }
        }
        
        while(!first.empty()){
            op1 = first.top();
            first.pop();
            if(op1 && carry){
                res.push(false);
                carry = true;
            }
            else{
                res.push(op1 || carry);
                carry = false;
            }
        }
        while(!second.empty()){
            op2 = second.top();
            second.pop();
            if(op2 && carry){
                res.push(false);
                carry = true;
            }
            else{
                res.push(op2 || carry);
                carry = false;
            }
        }
        
        if(carry){
            res.push(carry);
        }
        
        std::string ret;
        while(!res.empty()){
            op1 = res.top();
            res.pop();
            if(op1){
                ret.push_back('1');
            }
            else{
                ret.push_back('0');
            }
        }
        return ret;
    }
};
