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

    int height(TreeNode* node){
        if(!node)   return 0;
        int left_height = 0;
        int right_height = 0;
        if(node->left)      left_height = height(node->left);
        if(node->right)     right_height = height(node->right);
        return (left_height > right_height) ? left_height + 1 : right_height + 1;
    }

    bool isBalanced(TreeNode *root) {
        if(!root)       return true;
        int height_diff = height(root->left) - height(root->right);
        if((height_diff > 1) || (height_diff < -1)){
            // Left and right subtrees have heights with a difference greater than 1
            return false;
        }
        return isBalanced(root->left) && isBalanced(root->right);
    }
};
