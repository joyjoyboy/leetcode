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

    int recur(TreeNode* root, int accu){
        if(!root->left && !root->right){
            return accu;
        }
        else{
            int l = 0;
            int r = 0;
            if(root->left){
                l = recur(root->left, accu * 10 + root->left->val);
            }
            if(root->right){
                r = recur(root->right, accu * 10 + root->right->val);
            }
            return l + r;
        }
    }


    int sumNumbers(TreeNode *root) {
        if(!root)       return 0;
        
        return recur(root, root->val);
    }
};
