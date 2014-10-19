/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 
#define EXTRA 0
 
class Solution {
public:
    bool hasCycle(ListNode *head) {

// Use extra space
#ifdef EXTRA
        std::set<ListNode*> visited;
        
        while(head){
            if(visited.find(head) == visited.end()){
                visited.insert(head);
                head = head->next;
            }
            else
                return true;
        }
        
        return false;
        
// Use NO extra space
#else

        if(!head)   return false;
        ListNode* turtle = head;
        if(!turtle->next)   return false;
        ListNode* rabbit = turtle->next;
        
        while(!turtle && !rabbit){
            if(turtle == rabbit)    return true;
            else{
                turtle = turtle->next;
                rabbit = rabbit->next->next;
            }
        }
        
        return false;

#endif

    }
};
