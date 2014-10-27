public class Solution {
    
    private void helper(List<List<Integer>> allRes, List<Integer> curr, int[] S, int currIndex){
        allRes.add(new ArrayList(curr));
        for(int i = currIndex; i < S.length; ++i){
            curr.add(S[i]);
            helper(allRes, curr, S, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] S) {
        List<Integer> curr = new ArrayList<Integer>();
        List<List<Integer>> allRes = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        helper(allRes, curr, S, 0);
        return allRes;
    }
}
