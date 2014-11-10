class LRUCache{
public:

    class Entry{
        
        public:
        
        int key;
        Entry* before;
        Entry* next;
        
        Entry(int k){
            key = k;
            before = NULL;
            next = NULL;
        }
        
        ~Entry(){
            
        }
    };

    // key -> entry
    std::unordered_map<int, Entry*> entryMap;
    // key -> value
    std::unordered_map<int, int> cache;
    // For Accessing LinkedList
    Entry* listHead;
    Entry* listEnd;
    // Capacity
    int cap;

    LRUCache(int capacity) {
        cap = capacity;
        listHead = new Entry(0);
        listEnd = new Entry(0);
        listHead->next = listEnd;
        listEnd->before = listHead;
    }
    
    int get(int key) {
        if(cache.find(key) == cache.end()){
            return -1;
        }
        else{
            Entry* updatedEntry = entryMap[key];
            updatedEntry->before->next = updatedEntry->next;
            updatedEntry->next->before = updatedEntry->before;
            updatedEntry->next = listHead->next;
            updatedEntry->before = listHead;
            listHead->next->before = updatedEntry;
            listHead->next = updatedEntry;
            return cache[key];
        }
    }
    
    void set(int key, int value) {
        if(cache.find(key) == cache.end()){
            if(cap == cache.size()){
                // Remove the LRU entry
                int removedKey = listEnd->before->key;
                listEnd->before->before->next = listEnd;
                listEnd->before = listEnd->before->before;
                cache.erase(removedKey);
                entryMap.erase(removedKey);
            }
            Entry* newEntry = new Entry(key);
            listHead->next->before = newEntry;
            newEntry->next = listHead->next;
            listHead->next = newEntry;
            newEntry->before = listHead;
            entryMap.insert(std::make_pair(key, newEntry));
            cache.insert(std::make_pair(key, value));
        }
        else{
            // Update entry
            cache[key] = value;
            Entry* updatedEntry = entryMap[key];
            updatedEntry->before->next = updatedEntry->next;
            updatedEntry->next->before = updatedEntry->before;
            updatedEntry->next = listHead->next;
            updatedEntry->before = listHead;
            listHead->next->before = updatedEntry;
            listHead->next = updatedEntry;
        }
    }
};
