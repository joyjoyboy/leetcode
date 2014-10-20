class Solution {
public:
    string intToRoman(int num) {
        string res;
        std::stack<int> number;
        while(num){
            number.push(num % 10);
            num /= 10;
        }
        while(!number.empty()){
            int digit = number.top();
            int size = number.size();
            switch(size){
                case 1:
                    if(digit == 0){
                        break;
                    }
                    else if(digit == 4){
                        res.push_back('I');
                        res.push_back('V');
                        break;
                    }
                    else if(digit == 9){
                        res.push_back('I');
                        res.push_back('X');
                        break;
                    }
                    else if(digit >= 5){
                        res.push_back('V');
                        digit -= 5;
                        while(digit--){
                            res.push_back('I');
                        }
                        break;
                    }
                    else if(digit >= 1){
                        while(digit--){
                            res.push_back('I');
                        }
                        break;
                    }
                    else{
                        break;
                    }
                case 2:
                    if(digit == 0){
                        break;
                    }
                    else if(digit == 4){
                        res.push_back('X');
                        res.push_back('L');
                        break;
                    }
                    else if(digit == 9){
                        res.push_back('X');
                        res.push_back('C');
                        break;
                    }
                    else if(digit >= 5){
                        res.push_back('L');
                        digit -= 5;
                        while(digit--){
                            res.push_back('X');
                        }
                        break;
                    }
                    else if(digit >= 1){
                        while(digit--){
                            res.push_back('X');
                        }
                        break;
                    }
                    else{
                        break;
                    }
                case 3:
                    if(digit == 0){
                        break;
                    }
                    else if(digit == 4){
                        res.push_back('C');
                        res.push_back('D');
                        break;
                    }
                    else if(digit == 9){
                        res.push_back('C');
                        res.push_back('M');
                        break;
                    }
                    else if(digit >= 5){
                        res.push_back('D');
                        digit -= 5;
                        while(digit--){
                            res.push_back('C');
                        }
                        break;
                    }
                    else if(digit >= 1){
                        while(digit--){
                            res.push_back('C');
                        }
                        break;
                    }
                    else{
                        break;
                    }
                case 4:
                    while(digit--){
                        res.push_back('M');
                    }
                    break;
                default:
                
                    break;
            }
            number.pop();
        }
        return res;
    }
};
