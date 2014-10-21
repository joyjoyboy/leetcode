class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        std::vector<std::vector<int> >  res;
        
        // Initialization
        for(unsigned int i = 0; i < n; ++i){
            std::vector<int> row;
            for(unsigned int j = 0; j < n; ++j){
                row.push_back(0);
            }
            res.push_back(row);
        }
        
        // Exception handling
        if(!n)      return res;

        int count = 0;
        // Indices
        int x = 0;
        int y = 0;
        // Direction records the direction where the spiral matrix grows
        // 0 : right
        // 1 : down
        // 2 : left
        // 3 : up
        int direction = 0;
        while(count < n * n){
            count++;
            switch(direction){
                case 0:
                    res[x][y] = count;
                    if(y == n - 1){
                        direction = 1;
                        x++;
                    }
                    else if(res[x][y + 1]){
                        direction = 1;
                        x++;
                    }
                    else{
                        y++;
                    }
                    break;
                case 1:
                    res[x][y] = count;
                    if(x == n - 1){
                        direction = 2;
                        y--;
                    }
                    else if(res[x + 1][y]){
                        direction = 2;
                        y--;
                    }
                    else{
                        x++;
                    }
                    break;
                case 2:
                    res[x][y] = count;
                    if(y == 0){
                        direction = 3;
                        x--;
                    }
                    else if(res[x][y - 1]){
                        direction = 3;
                        x--;
                    }
                    else{
                        y--;
                    }
                    break;
                case 3:
                    res[x][y] = count;
                    if(x == 0){
                        direction = 0;
                        y++;
                    }
                    else if(res[x - 1][y]){
                        direction = 0;
                        y++;
                    }
                    else{
                        x--;
                    }
                    break;
                default:
                
                    break;
            }
        }

        return res;
    }
};
