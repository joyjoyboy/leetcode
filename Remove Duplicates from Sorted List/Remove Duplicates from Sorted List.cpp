/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        ListNode* ptr = head;
        ListNode* fastPtr = NULL;
        // Empty list
        if(!ptr)    return head;
        // fastPtr always points to ptr->next
        if(ptr->next)   fastPtr = ptr->next;
        // Compare ptr and ptr->next
        // If they've save values, link ptr to ptr->next->next
        while(fastPtr){
            if(ptr->val == fastPtr->val){
                // Not reaching the end yet
                if(fastPtr->next){
                    ptr->next = fastPtr->next;
                    fastPtr = fastPtr->next;
                }
                // Reaches the end
                else{
                    ptr->next = NULL;
                    fastPtr = NULL;
                    return head;
                }
            }
            else{
                ptr = ptr->next;
                fastPtr = fastPtr->next;
            }
        }
        return head;
    }
};
