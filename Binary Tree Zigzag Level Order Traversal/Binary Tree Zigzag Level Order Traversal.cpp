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
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        std::list<TreeNode*> workingList;
        // false: from left to right
        // true: from right to left
        bool direction = false;
        std::vector<std::vector<int> > res;
        if(!root){
            // Empty input expects one-dimensional empty output
            //res.push_back(std::vector<int>());
            return res;
        }
        
        workingList.push_back(root);
        while(!workingList.empty()){
            std::list<TreeNode*> newList;
            std::vector<int> newElement;
            if(!direction){
                for(std::list<TreeNode*>::iterator it = workingList.begin(); it != workingList.end(); ++it){
                    TreeNode* curr = (*it);
                    newElement.push_back(curr->val);
                    if(curr->left)      newList.push_back(curr->left);
                    if(curr->right)     newList.push_back(curr->right);
                }
            }
            else{
                for(std::list<TreeNode*>::reverse_iterator it = workingList.rbegin(); it != workingList.rend(); ++it){
                    TreeNode* curr = (*it);
                    newElement.push_back(curr->val);
                    if(curr->right)     newList.push_front(curr->right);
                    if(curr->left)      newList.push_front(curr->left);
                }
            }
            direction = !direction;
            workingList = newList;
            newList.clear();
            res.push_back(newElement);
        }
        
        return res;
    }
};
