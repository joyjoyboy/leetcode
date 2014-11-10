public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        int i = 0;
        int currlen = 0;
        List<String> ret = new ArrayList<String>();
        List<String> workingList = new ArrayList<String>();
        while(i < words.length){
            String currWord = words[i];
            currlen += currWord.length();
            
            // Adding currWord might break the size limit
            if(currlen >= L){
                
                // currWord will not be included in this string
                // it will be revisited in the next iteration
                if(currlen > L){
                    currlen -= currWord.length();
                    // A space is pre-allocated because currWord was assumed to be added to the string
                    --currlen;
                    --i;
                }
                // currWord just helped form a valid string
                // it is added to the workinglist and is processed afterwards
                // it will not be revisited again
                else{
                    workingList.add(currWord);
                }
                
                // to-be added str
                String element = new String();
                
                if(workingList.size() == 0){
                    // Exception. This case won't happen unless L is less than 0, which is illegal
                }
                // Only one element in the working list
                // All spaces will be distributed after this single word
                else if(workingList.size() == 1){
                    element = element.concat(workingList.get(0));
                    while(currlen < L){
                        element = element.concat(" ");
                        ++currlen;
                    }
                }
                // More than one element in the working list
                // Spaces will be evenly distributed
                // Every slot will get (totalSpaces / numOfSlots) spaces
                // The remainder spaces will be allocated to slots that are closest to the left
                else{
                    int numOfAdditionalSpaces = L - currlen;
                    int numOfSlots = workingList.size() - 1;
                    
                    int quotient = numOfAdditionalSpaces / numOfSlots;
                    int remainder = numOfAdditionalSpaces % numOfSlots;
                    
                    for(int index = 0; index < workingList.size(); ++index){
                        String sub = workingList.get(index);
                        element = element.concat(sub);
                        // Not the last string
                        if(index != workingList.size() - 1){
                            element = element.concat(" ");
                            // From the left, first (remainder) slots will be allocated with an extra space
                            if(remainder > 0){
                                --remainder;
                                int count = quotient + 1;
                                while(count > 0){
                                    element = element.concat(" ");
                                    --count;
                                }
                            }
                            // Not every slot could have an extra space
                            else{
                                int count = quotient;
                                while(count > 0){
                                    element = element.concat(" ");
                                    --count;
                                }
                            }
                        }
                    }
                }
                
                // Add string to the result
                ret.add(element);
                // Reset currlen and working list
                currlen = 0;
                workingList.clear();
            }
            // Valid string is not formed yet. Proceed to the next iteration
            else{
                workingList.add(currWord);
                // If this is not the last word, a space will surely be allocated
                if(i != words.length - 1){
                    currlen += 1;
                }
            }
            
            ++i;
        }
        
        // Process the last element
        String lastElement = new String();
        if(!workingList.isEmpty()){
            while(!workingList.isEmpty()){
                lastElement = lastElement.concat(workingList.get(0));
                if(workingList.size() > 1){
                    lastElement = lastElement.concat(" ");
                }
                else{
                    while(currlen < L){
                        ++currlen;
                        lastElement = lastElement.concat(" ");
                    }
                }
                workingList.remove(0);
            }
            ret.add(lastElement);
        }
        
        return ret;
        
    }
}
