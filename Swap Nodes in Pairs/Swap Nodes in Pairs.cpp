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
    ListNode *swapPairs(ListNode *head) {
        if(!head)           return head;
        if(!head->next)     return head;
        ListNode* nextPair = head->next->next;
        ListNode* ret = head->next;
        head->next->next = head;
        head->next = swapPairs(nextPair);
        return ret;
    }
};
