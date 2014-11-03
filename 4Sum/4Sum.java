public class Solution {
    
    // Recursive search will cause time limit exceeding
    /*
    private void recur(List<List<Integer>> res, List<Integer> solution, int[] num, int index, int target){
        if(solution.size() == 4){
            int sum = 0;
            int i = 0;
            while(i < 4){
                sum += solution.get(i);
                ++i;
            }
            if(sum == target){
                res.add(new ArrayList<Integer>(solution));
            }
            return;
        }
        for(int i = index; i < num.length; ++i){
            solution.add(num[i]);
            recur(res, solution, num, index + 1, target);
            solution.remove(solution.size() - 1);
        }
        
        return;
    }
    */
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(num.length < 4){
            return res;
        }
        
        Arrays.sort(num);
        // Recursive solution cannot past the test
        //recur(res, sol, num, 0, target);
        
        
        // Search a + b + c + d == target
        // Start from d
        for(int d = 0; d < num.length; ++d){
            
            int threeSum = target - num[d];
            for(int c = d + 1; c < num.length; ++c){
                
                int twoSum = threeSum - num[c];
                int a = c + 1;
                int b = num.length - 1;
                // NOTE: d < c < a < b
                while(a < b){
                    if(num[a] + num[b] == twoSum){
                        if(res.isEmpty()){
                            List<Integer> sol = new ArrayList<Integer>();
                            sol.add(num[d]);
                            sol.add(num[c]);
                            sol.add(num[a]);
                            sol.add(num[b]);
                            res.add(sol);
                        }
                        else{
                            boolean skip = false;
                            for(List<Integer> prev : res){
                                if(prev.get(0) == num[d] && prev.get(1) == num[c] && prev.get(2) == num[a] && prev.get(3) == num[b]){
                                    skip = true;
                                }
                            }
                            if(!skip){
                                List<Integer> sol = new ArrayList<Integer>();
                                sol.add(num[d]);
                                sol.add(num[c]);
                                sol.add(num[a]);
                                sol.add(num[b]);
                                res.add(sol);
                            }
                        }
                        ++a;
                        --b;
                    }
                    else if(num[a] + num[b] < twoSum){
                        ++a;
                    }
                    else{
                        --b;
                    }
                }
            }
        }
        
        return res;
    }
}
