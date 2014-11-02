class Solution {
public:
    string simplifyPath(string path) {
        std::string out;
        
        std::stack<std::string> stk;
        std::string element;
        for(unsigned int i = 0; i < path.size(); ++i){
            char c = path[i];
            if((c == '/') || (i == (path.size() - 1))){
                // Handle the last character
                if(i == (path.size() - 1)){
                    if(c != '/'){
                        element.push_back(c);
                    }
                }
                
                if(!element.empty()){
                    // "./" could be removed without any side effect
                    if(element.compare(".") == 0){
                        // Do nothing
                    }
                    // "../" could remove the first element in the queue
                    // If the queue is empty, nothing will happen
                    else if(element.compare("..") == 0){
                        if(stk.empty()){
                            // Do nothing
                        }
                        else{
                            stk.pop();
                        }
                    }
                    // Normal path arguments
                    else{
                        stk.push(element);
                    }
                    element.clear();
                }
            }
            else{
                element.push_back(c);
            }
        }
        
        if(stk.empty()){
            out.push_back('/');
        }
        else{
            std::stack<std::string> reverse;
            while(!stk.empty()){
                reverse.push(stk.top());
                stk.pop();
            }
            
            while(!reverse.empty()){
                out.push_back('/');
                out.append(reverse.top());
                reverse.pop();
            }
        }
        
        return out;
    }
};
