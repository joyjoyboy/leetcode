//#define QUICKSORT

class Solution {
public:

    class Node{
        
    public:
        
        int val;
        int index;
        Node(int value, int i){
            val = value;
            index = i;
        }
    };

    int partition(std::vector<Node*>& input, int start, int end){
        Node* pivot = input[end];
        int i = start - 1;
        for(int j = start; j < end; ++j){
            if(input[j]->val <= pivot->val){
                i++;
                if(i != j){
                    Node* tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
        ++i;
        if(i != end){
            Node* tmp = input[i];
            input[i] = input[end];
            input[end] = tmp;
        }
        
        return i;
    }

    void quicksort(std::vector<Node*>& input, int start, int end){
        if(start < end){
            int mid = partition(input, start, end);
            quicksort(input, start, mid - 1);
            quicksort(input, mid + 1, end);
        }
        return;
    }

    vector<int> twoSum(vector<int> &numbers, int target) {
        int index1 = 0;
        int index2 = numbers.size() - 1;
        std::vector<int>    res;
        
        if(numbers.size() < 2){
            return res;
        }


#ifdef QUICKSORT        
        std::vector<Node*> container;
        for(unsigned int i = 0; i < numbers.size(); ++i){
            Node* tmp = new Node(numbers[i], i);
            container.push_back(tmp);
        }
        quicksort(container, 0, container.size() - 1);
#else        
        std::vector<int> numCopy(numbers);
        std::sort(numbers.begin(), numbers.end());
#endif


        while(index1 < index2){
            
            
#ifdef QUICKSORT
            int sum = container[index1]->val + container[index2]->val;
#else
            int sum = numbers[index1] + numbers[index2];
#endif


            if(sum == target){

                
#ifdef QUICKSORT    
                index1 = container[index1]->index;
                index2 = container[index2]->index;
#else                
                int newIndex1 = -1;
                int newIndex2 = -1;
                
                for(unsigned int i = 0; i < numCopy.size(); ++i){
                    if((numbers[index1] == numCopy[i]) || (numbers[index2] == numCopy[i])){
                        if(newIndex1 == -1)     newIndex1 = i;
                        else                    newIndex2 = i;
                    }
                }
                
                index1 = newIndex1;
                index2 = newIndex2;
#endif


                if(index1 < index2){
                    res.push_back(index1 + 1);
                    res.push_back(index2 + 1);
                }
                else{
                    res.push_back(index2 + 1);
                    res.push_back(index1 + 1);
                }
                return res;
            }
            else if(sum < target){
                ++index1;
            }
            else{
                --index2;
            }
        }
        return res;
    }
};
