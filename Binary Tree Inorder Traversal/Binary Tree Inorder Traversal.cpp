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

#ifdef RECUR

    void recur(std::vector<int>& res, TreeNode* node){
        if(!node)   return;
        recur(res, node->left);
        res.push_back(node->val);
        recur(res, node->right);
    }

#endif

    vector<int> inorderTraversal(TreeNode *root) {

#ifdef RECUR
        std::vector<int> res;
        recur(res, root);
        return res;
#else
        if(!root)   return std::vector<int>();
        std::vector<int> res;
        std::stack<TreeNode*> s;
        s.push(root);
        TreeNode* prev = NULL;
        
        // When curr is prev's child, the tree is been traversed downward
        
        // When curr is prev's parent, the tree is been traversed upward
        // Pre-order traversal requires pushing curr first, then prev
        
        while(!s.empty()){
            TreeNode* curr = s.top();
            s.pop();
            // Traverse down the tree            
            if(prev == NULL || (curr == prev->left) || (curr == prev->right)){
                if(curr->right)     s.push(curr->right);
                if(curr->left){
                    s.push(curr);
                    s.push(curr->left);
                }
                else{
                    res.push_back(curr->val);
                }
            }
            // Traverse up the tree
            else{
                res.push_back(curr->val);
            }
            
            prev = curr;
        }

        return res;

#endif
        
    }
};
