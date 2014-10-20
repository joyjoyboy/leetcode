public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(numRows == 0){
            return ret;
        }
        
        while(numRows-- > 0){
            if(ret.size() == 0){
                List<Integer> firstElement = new ArrayList<Integer>();
                firstElement.add(1);
                ret.add(firstElement);
            }
            else{
                List<Integer> prevElement = ret.get(ret.size() - 1);
                List<Integer> nextElement = new ArrayList<Integer>();
                nextElement.add(1);
                for(int i = 0; i < prevElement.size() - 1; ++i){
                    nextElement.add(prevElement.get(i) + prevElement.get(i + 1));
                }
                nextElement.add(1);
                ret.add(nextElement);
            }
        }
        
        return ret;
    }
}
