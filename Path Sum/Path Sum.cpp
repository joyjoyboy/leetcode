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

    bool recur(TreeNode* node, int sum, int comp){
        if(!node)   return false;
        
        sum += node->val;
        
        if(node->left && node->right){
            return recur(node->left, sum, comp) || recur(node->right, sum, comp);
        }
        else if(node->left){
            return recur(node->left, sum, comp);
        }
        else if(node->right){
            return recur(node->right, sum, comp);
        }
        else{
            if(sum == comp)     return true;
            else                return false;
        }
    }

    bool hasPathSum(TreeNode *root, int sum) {
        return recur(root, 0, sum);
    }
};
