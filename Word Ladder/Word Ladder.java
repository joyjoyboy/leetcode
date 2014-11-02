public class Solution {

    public int ladderLength(String start, String end, Set<String> dict) {
        LinkedList<String> transfer = new LinkedList<String>();
        LinkedList<Integer> dist = new LinkedList<Integer>();
        
        if(start.equals(end)){
            return 1;
        }
        
        transfer.add(start);
        dist.add(1);
        
        while(!transfer.isEmpty()){
            String s = transfer.pop();
            Integer distance = dist.pop();
            
            for(int i = 0; i < s.length(); ++i){
                char[] temp = s.toCharArray();
                for(char a = 'a'; a <= 'z'; ++a){
                    if(temp[i] == a){
                        continue;
                    }
                    temp[i] = a;
                    String modified = String.valueOf(temp);
                    if(dict.contains(modified)){
                        if(modified.equals(end)){
                            return distance + 1;
                        }
                        transfer.add(modified);
                        dist.add(distance + 1);
                        dict.remove(modified);
                    }
                }
            }
        }
        return 0;
    }
    
}
