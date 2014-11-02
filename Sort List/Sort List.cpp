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

    ListNode* merge(ListNode* first, ListNode* second){

        if(first == NULL)           return second;
        else if(second == NULL)     return first;

        ListNode* tmpResult = NULL;

        if(first->val > second->val){
            tmpResult = second;
            tmpResult->next = merge(first, second->next);
        }
        else{
            tmpResult = first;
            tmpResult->next = merge(first->next, second);
        }
        
        return tmpResult;
    }

    ListNode* sort(ListNode* start, unsigned int len){
        if(!len)
            return NULL;
        else if(len == 1)
            return start;

        // Split the list            
        ListNode* split = start;
        unsigned int count = len / 2;
        while(count--){
            split = split->next;
        }

        // Initialize and sort first half of the list
        count = len / 2;
        ListNode* temp = start;
        while(--count){
            temp = temp->next;
        }
        temp->next = NULL;
        start = sort(start, len / 2);

        // Initialize and sort the second half of the list
        count = len - (len / 2);
        temp = split;
        while(--count){
            temp = temp->next;
        }
        temp->next = NULL;
        split = sort(split, len - (len / 2));

        ListNode* result = merge(start, split);
        return result;
    }

    ListNode *sortList(ListNode *head) {
        unsigned int len = 0;
        ListNode* tmp = head;
        for(; tmp != NULL; ++len){
            tmp = tmp->next;
        }
        return sort(head, len);
    }
};
