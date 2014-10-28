public class Solution {
    
    private void recur(List<List<Integer>> ret, List<Integer> solution, int[] num, int level){
        int size = num.length;
        
        for(int i = level; i < size; ++i){
            solution.add(num[i]);
            ret.add(new ArrayList<Integer>(solution));
            if(i != (size - 1)){
                recur(ret, solution, num, i + 1);
                while(num[i] == num[i + 1]){
                    ++i;
                    if(i == (size - 1)){
                        break;
                    }
                }
            }
            solution.remove(solution.size() - 1);
        }
        
        return;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        
        List<Integer> set = new ArrayList<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        ret.add(set);
        Arrays.sort(num);
        recur(ret, set, num, 0);
        
        return ret;
    }
}
