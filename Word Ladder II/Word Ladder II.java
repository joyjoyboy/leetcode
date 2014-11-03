public class Solution {
    
    public class TreeNode{
        public String str;
        public List<TreeNode> next;
        public int depth;
        
        public TreeNode(String s){
            str = new String(s);
            next = new ArrayList<TreeNode>();
            depth = 0;
        }
        
    };
    
    public void recur(List<List<String>> res, List<String> list, TreeNode head, String end){
        if(head == null){
            return;
        }
        
        if(head.str.equals(end)){
            list.add(head.str);
            List<String> element = new ArrayList<String>(list);
            res.add(element);
            list.remove(list.size() - 1);
        }
        else{
            list.add(head.str);
            for(TreeNode x : head.next){
                recur(res, list, x, end);
            }
            list.remove(list.size() - 1);
        }
        return;
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        
// This is a previous version that did not pass the test due to time limit
// The ridiculous thing is, for small inputs, this version runs much faster than the current version
// Which should be way much faster
// PARADOX
/*
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> curr = new ArrayList<String>();
        
        curr.add(start);
        currSet.add(start);
        
        while(!result.isEmpty()){
            // result for the next iteration
            List<List<String>> newResult = new ArrayList<List<String>>();
            
            for(List<String> list : result){
                // Get the last string
                String s = list.get(list.size() - 1);
                if(s.equals(end)){
                    newResult.clear();
                    for(List<String> l : result){
                        if(l.get(l.size() - 1).equals(end)){
                            newResult.add(new ArrayList<String>(l));
                        }
                    }
                    return newResult;
                }
                
                for(int i = 0; i < s.length(); ++i){
                    char[] c = s.toCharArray();
                    // Try to replace each character with every possible option
                    for(char a = 'a'; a <= 'z'; ++a){
                        if(c[i] == a){
                            continue;
                        }
                        c[i] = a;
                        String comp = String.valueOf(c);
                        // Valid word
                        if(dict.contains(comp) && !list.contains(comp)){
                            List<String> newList = new ArrayList<String>(list);
                            newList.add(comp);
                            newResult.add(newList);
                        }
                    }
                }
            }
            
            result = newResult;
        }
        
        return result;        
*/
        List<List<String>> ret = new ArrayList<List<String>>();
        
        List<String> curr = new LinkedList<String>();
        Map<String, TreeNode> map = new HashMap<String, TreeNode>();
        curr.add(start);
        TreeNode currNode = new TreeNode(start);
        TreeNode head = currNode;
        String s = curr.get(0);
        map.put(s, currNode);
        
        boolean terminate = false;
        
        do{
            curr.remove(0);
                
            for(int i = 0; i < s.length(); ++i){
                char[] c = s.toCharArray();
                // Try to replace each character with every possible option
                for(char a = 'a'; a <= 'z'; ++a){
                    if(c[i] == a){
                        continue;
                    }
                    c[i] = a;
                    String comp = String.valueOf(c);
                    
                    // Terminate condition triggered when a solution has been found
                    // No more irrelavant result will be put in working list
                    if(terminate){
                        if(!end.equals(comp)){
                            continue;
                        }
                    }
                    // Valid word
                    if(dict.contains(comp)){
                        
                        if(end.equals(comp)){
                            terminate = true;
                        }
                        
                        if(!map.containsKey(comp)){
                            TreeNode newNode = new TreeNode(comp);
                            newNode.depth = currNode.depth + 1;
                            currNode.next.add(newNode);
                            curr.add(comp);
                            map.put(comp, newNode);
                        }
                        else{
                            TreeNode newNode = map.get(comp);
                            if(newNode.depth == currNode.depth + 1){
                                currNode.next.add(newNode);
                            }
                        }
                    }
                }
            }
            
            if(!curr.isEmpty()){
                s = curr.get(0);
                currNode = map.get(s);
            }
        }while(!curr.isEmpty());
        
        List<String> list = new ArrayList<String>();
        recur(ret, list, head, end);
        return ret;
        
    }
}
