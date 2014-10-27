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
    ListNode *insertionSortList(ListNode *head) {
        unsigned int len = 0;
        ListNode* sortedHead = head;
        for(ListNode* tmp = head; tmp != NULL; tmp = tmp->next, len++);
        if((len == 0) || (len == 1))        return head;
        unsigned int sorted = 1;
        ListNode* unsortedHead = head->next;
        head->next = NULL;

        for(; sorted < len; ++sorted){

            // Locate the listNode that is going to be inserted
            ListNode* currentNode = unsortedHead;
            // Move unsorted head
            unsortedHead = unsortedHead->next;
            
            ListNode* greater = NULL;
            ListNode* smaller = NULL;
            ListNode* compare = sortedHead;
            for(unsigned int i = 0; i < sorted; ++i){
                if(currentNode->val < compare->val){
                    if(compare == sortedHead){
                        greater = compare;
                        currentNode->next = compare;
                        sortedHead = currentNode;
                    }
                    else{
                        greater = compare;
                        currentNode->next = compare;
                        smaller->next = currentNode;
                    }
                    break;
                }
                else{
                    smaller = compare;
                    compare = compare->next;
                }
            }
            if((smaller) && (!greater)){
                smaller->next = currentNode;
                currentNode->next = NULL;
            }
        }
        return sortedHead;
    }
};
