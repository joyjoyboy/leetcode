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

    bool recur(TreeNode* p, TreeNode* q){
        if((!p && q) || (p && !q))  return false;
        if(!p && !q)            return true;
        if(p->val != q->val)    return false;
        return (recur(p->left, q->left) && recur(p->right, q->right));
    }

    bool isSameTree(TreeNode *p, TreeNode *q) {
        recur(p, q);
    }
};
