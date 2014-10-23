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
    int minDepth(TreeNode *root) {
        if(!root)       return 0;
        
        if(!root->left && !root->right){
            return 1;
        }
        else{
            int l = INT_MAX;
            int r = INT_MAX;
            if(root->left){
                l = minDepth(root->left) + 1;
            }
            if(root->right){
                r = minDepth(root->right) + 1;
            }
            return (l < r) ? l : r;
        }
    }
};
