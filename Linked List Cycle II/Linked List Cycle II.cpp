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
    ListNode *detectCycle(ListNode *head) {
        
        // Similar to the solution to Linked List Cycle I
        // slowptr will meet fastptr at some point on the cycle (meeting point)
        // Define X as the distance from head to the beginning point of cycle
        // Define Y as the distance from the beginning point of cycle to the meeting point on the cycle
        // Define C as the perimeter of the cycle
        // On the cycle, the distance from beginning point to meeting point is Y
        // And the distance from the meeting point to beginning point (a.k.a. ending point) is (C - Y)
        // The slowptr moves (X + kC + Y), and the fastptr moves (X + (k + n)C + Y), which is twice the distance the slowptr moves
        // 2X + 2kC + 2Y = X + (k + n)C + Y      =>      X = (n - k)C - Y
        // If slowptr and fastptr moves at the same speed, and slowptr starts from head while fastptr starts from meeting point
        // They will eventually meet at the beginning time, after X steps (which is exactly the same as C - Y)
        
        if(!head)           return NULL;
        
        ListNode* slowptr = head;
        ListNode* fastptr = head;
        do{
            slowptr = slowptr->next;
            fastptr = fastptr->next;
            if(fastptr){
                fastptr = fastptr->next;
            }
            else{
                break;
            }
        }while(fastptr && fastptr != slowptr);
        if(!fastptr)        return NULL;
        slowptr = head;
        while(slowptr != fastptr){
            slowptr = slowptr->next;
            fastptr = fastptr->next;
        }
        return slowptr;
    }
};
