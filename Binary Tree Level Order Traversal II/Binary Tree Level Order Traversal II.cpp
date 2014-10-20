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
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        std::vector<std::vector<int> >  res;
        
        if(!root)   return res;
        
        std::vector<TreeNode*>    curr_level;
        curr_level.push_back(root);
        
        while(!curr_level.empty()){
            std::vector<int>    container;
            std::vector<TreeNode*>  next_level;
            for(unsigned int i = 0; i < curr_level.size(); ++i){
                container.push_back(curr_level[i]->val);
                if(curr_level[i]->left)             next_level.push_back(curr_level[i]->left);
                if(curr_level[i]->right)       next_level.push_back(curr_level[i]->right);
            }
            res.push_back(container);
            curr_level = next_level;
        }
        
        for(unsigned int i = 0; i < res.size() / 2; ++i){
            std::vector<int>    tmp = res[i];
            res[i] = res[res.size() - 1 - i];
            res[res.size() - 1 - i] = tmp;
        }
        
        return res;
    }
};
