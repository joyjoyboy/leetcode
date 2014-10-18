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

    int recur(TreeNode* node){
        if(!node)   return 0;
        int left = recur(node->left);
        int right = recur(node->right);
        return (left > right) ? left + 1 : right + 1;
    }

    int maxDepth(TreeNode *root) {
        return recur(root);
    }
};
