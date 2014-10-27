/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        
        List<UndirectedGraphNode> workingList = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> newToOld = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        workingList.add(node);
        
        List<UndirectedGraphNode> newList = new ArrayList<UndirectedGraphNode>();
        while(!workingList.isEmpty()){
            UndirectedGraphNode currNode = workingList.get(0);
            workingList.remove(0);
            visited.add(currNode);
            UndirectedGraphNode newNode = new UndirectedGraphNode(currNode.label);
            oldToNew.put(currNode, newNode);
            newToOld.put(newNode, currNode);
            newList.add(newNode);
            for(UndirectedGraphNode n : currNode.neighbors){
                if(!visited.contains(n)){
                    workingList.add(n);
                }
            }
        }
        
        for(UndirectedGraphNode n : newList){
            UndirectedGraphNode original = newToOld.get(n);
            for(UndirectedGraphNode neighbor : original.neighbors){
                n.neighbors.add(oldToNew.get(neighbor));
            }
        }
        
        return oldToNew.get(node);
    }
}
