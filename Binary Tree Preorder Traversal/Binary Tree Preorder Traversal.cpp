/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
#define RECUR 0 
 
class Solution {
public:


// Trivial recursive solution

#ifdef RECUR
    void recur(std::vector<int>& res, TreeNode* node){
        if(node){
            res.push_back(node->val);
            recur(res, node->left);
            recur(res, node->right);
        }
        else
            return;
    }

    vector<int> preorderTraversal(TreeNode *root) {
        std::vector<int> res;
        recur(res, root);
        return res;
    }
    
// Iterative solution

#else

    vector<int> preorderTraversal(TreeNode *root) {
        if(!root)
            return NULL;
        
        std::vector<int> res;
        std::stack<TreeNode*> s;
        s.push(root);
        
        while(!s.empty()){
            TreeNode* curr = s.top();
            s.pop();
            res.push_back(curr->val);
            if(curr->right)     s.push(curr->right);
            if(curr->left)      s.push(curr->left);
        }
        
        return res;
    }

#endif

};
