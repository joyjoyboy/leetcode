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
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {

        // Recursion is always the best weapon against lists
/*
        ListNode* head;
        if(!l1)     return l2;
        if(!l2)     return l1;
        
        if(l1->val <= l2->val){
            l1->next = mergeTwoLists(l1->next, l2);
            head = l1;
        }
        else{
            l2->next = mergeTwoLists(l1, l2->next);
            head = l2;
        }
        
        return head;
*/        
    ListNode* merged = NULL;
    ListNode** tail = &merged;

    while (list1 && list2) {
        if (list1->val < list2->val) {
            *tail = list1;
            list1 = list1->next;
        } else {
            *tail = list2;
            list2 = list2->next;
        }
        // Here's the key point
        // "tail" ptr points to current node's "next" ptr
        // If next time the "next" is no longer in its own list
        // "tail" will be dereferenced and the "next" ptr will be assigned to a new value
        tail = &((*tail)->next);
    }
    *tail = list1 ? list1 : list2;
    return merged;

    }
};
