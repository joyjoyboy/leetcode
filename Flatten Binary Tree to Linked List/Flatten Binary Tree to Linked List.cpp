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

    void flatten(TreeNode *root) {
        if(!root)       return;
        
        std::stack<TreeNode*> stk;
        stk.push(root);
        while(!stk.empty()){
            TreeNode* curr = stk.top();
            stk.pop();
            if(curr->left){
                if(curr->right){
                    stk.push(curr->right);
                }
                curr->right = curr->left;
                stk.push(curr->left);
                curr->left = NULL;
            }
            else if(curr->right){
                stk.push(curr->right);
            }
            else{
                if(stk.empty()){
                    curr->right = NULL;
                }
                else{
                    curr->right = stk.top();
                }
            }
        }
        return;
    }
};
