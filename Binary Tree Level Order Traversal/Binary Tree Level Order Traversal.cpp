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
    vector<vector<int> > levelOrder(TreeNode *root) {
        std::vector<std::vector<int> > res;
        std::vector<TreeNode*> curr_level;
        std::vector<TreeNode*> next_level;
        
        if(!root)   return res;
        
        curr_level.push_back(root);
        std::vector<int> tmp;
        
        while(!curr_level.empty()){
            tmp.clear();
            for(unsigned int i = 0; i < curr_level.size(); ++i){
                tmp.push_back(curr_level[i]->val);
                if(curr_level[i]->left){
                    next_level.push_back(curr_level[i]->left);
                }
                if(curr_level[i]->right){
                    next_level.push_back(curr_level[i]->right);
                }
            }
            curr_level = next_level;
            next_level.clear();
            res.push_back(tmp);
        }
        return res;
    }
};
