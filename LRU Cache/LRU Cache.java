public class LRUCache {
    
    class LLNode{
        
        int val;
        LLNode next;
        LLNode before;
        
        LLNode(){
            val = 0;
            next = null;
            before = null;
        }
        
        LLNode(int input){
            val = input;
            next = null;
            before = null;
        }
        
        LLNode(int input, LLNode nextNode, LLNode be4Node){
            val = input;
            next = nextNode;
            before = be4Node;
        }
    }
    
    // Store key -> value
    Map<Integer, Integer> map;
    // Store key -> LLNode
    Map<Integer, LLNode> lru;
    int cap;
    LLNode fakeHead;
    LLNode fakeEnd;
    
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, Integer>();
        lru = new HashMap<Integer, LLNode>();
        fakeHead = new LLNode();
        fakeEnd = new LLNode();
        fakeHead.next = fakeEnd;
        fakeEnd.before = fakeHead;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            LLNode getNode = lru.get(key);
            // Update getNode's position in Linkedlist
            getNode.before.next = getNode.next;
            getNode.next.before = getNode.before;
            getNode.next = fakeHead.next;
            fakeHead.next.before = getNode;
            getNode.before = fakeHead;
            fakeHead.next = getNode;
            return map.get(key);
        }
        else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(!map.containsKey(key) && (map.size() == cap)){
            // The LRU node needs to be discarded
            LLNode removedNode = fakeEnd.before;
            int removedNodeKey = fakeEnd.before.val;
            // removedNode is removed from Linkedlist
            removedNode.before.next = removedNode.next;
            removedNode.next.before = removedNode.before;
            // removedNode is removed from HashMap
            lru.remove(removedNodeKey);
            map.remove(removedNodeKey);
        }
        
        // Create LRU map entry if it is absent
        if(!map.containsKey(key)){
            LLNode newNode = new LLNode(key, fakeHead.next, fakeHead);
            fakeHead.next.before = newNode;
            fakeHead.next = newNode;
            lru.put(key, newNode);
        }
        
        // Target entry is updated || created
        map.put(key, value);
        // Linkedlist is updated
        LLNode targetNode = lru.get(key);
        // Remove targetNode from Linkedlist
        targetNode.before.next = targetNode.next;
        targetNode.next.before = targetNode.before;
        // targetNode is reinserted after fakeHead
        targetNode.next = fakeHead.next;
        fakeHead.next.before = targetNode;
        targetNode.before = fakeHead;
        fakeHead.next = targetNode;
    }
}
