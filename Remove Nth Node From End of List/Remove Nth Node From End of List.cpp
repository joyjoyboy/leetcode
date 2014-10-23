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
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        if(!head || !n){
            return head;
        }
        ListNode* fakeHead = new ListNode(0);
        fakeHead->next = head;
        ListNode* fast = head;
        ListNode* slow = fakeHead;
        // Steps that fastptr advances slowptr
        for(int i = 0; i < n - 1; ++i){
            fast = fast->next;
            if(!fast){
                return head;
            }
        }
        while(fast->next){
            slow = slow->next;
            fast = fast->next;
        }
        slow->next = slow->next->next;
        return fakeHead->next;
    }
};
