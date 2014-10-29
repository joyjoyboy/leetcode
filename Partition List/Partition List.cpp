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
    ListNode *partition(ListNode *head, int x) {
        if(!head)       return NULL;
        ListNode* fakeHead = new ListNode(0);
        ListNode* slowPtr = fakeHead;
        slowPtr->next = head;
        ListNode* fastPtr = head;
        while(fastPtr){
            if(fastPtr->val >= x)        break;
            slowPtr = slowPtr->next;
            fastPtr = fastPtr->next;
        }
        if(!fastPtr)    return head;
        
        ListNode* beforePtr = fastPtr;
        ListNode* ptr = fastPtr->next;
        while(ptr){
            ListNode* nextPtr = ptr->next;
            if(ptr->val < x){
                slowPtr->next = ptr;
                ptr->next = fastPtr;
                slowPtr = ptr;
                beforePtr->next = nextPtr;
            }
            else{
                beforePtr = beforePtr->next;
            }
            ptr = nextPtr;
            
        }
        
        return fakeHead->next;
    }
};
