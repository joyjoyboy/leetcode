/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:

    static ListNode* lNode;

    // Inclusive indices
    TreeNode* recur(ListNode* head, int left, int right){
        
        if(left > right)        return NULL;
        
        int mid = left + right;
        mid /= 2;
        
        TreeNode* l = recur(head, left, mid - 1);
        TreeNode* curr = new TreeNode(Solution::lNode->val);
        lNode = lNode->next;
        TreeNode* r = recur(head, mid + 1, right);
        
        curr->left = l;
        curr->right = r;
        
        return curr;
    }

    TreeNode *sortedListToBST(ListNode *head) {
        ListNode* l = head;
        int len = 0;
        while(l != NULL){
            l = l->next;
            ++len;
        }
        lNode = head;
        return recur(head, 0, len - 1);
    }
};

ListNode* Solution::lNode = NULL;
