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

    bool recur(TreeNode* left, TreeNode* right){
        if(!left && !right)     return true;
        if(!left && right)      return false;
        if(left && !right)      return false;
        
        if(left->val != right->val)     return false;
        else{
            return (recur(left->left, right->right) && recur(left->right, right->left));
        }
    }

    bool isSymmetric(TreeNode *root) {
        if(!root)                       return true;
        if(!root->left && !root->right) return true;
        if(root->left && !root->right)  return false;
        if(!root->left && root->right)  return false;

        TreeNode* left = root->left;
        TreeNode* right = root->right;
        
        return recur(left, right);

    }
};
