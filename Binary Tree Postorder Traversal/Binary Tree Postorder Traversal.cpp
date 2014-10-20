/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
     bool comp(int i, int j){
        return (i > j);
    }
    
class Solution {
public:

    void recur(std::vector<int>& res, TreeNode* node){
        if(node == NULL)    return;

        
        recur(res, node->left);
                recur(res, node->right);
        res.push_back(node->val);
    }
    

    vector<int> postorderTraversal(TreeNode *root) {
        std::vector<int> res;
        res.clear();
        recur(res, root);
        //std::sort(res.begin(), res.end(), comp);
        return res;
    }
};
