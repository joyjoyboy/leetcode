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

    TreeNode* recur(vector<int>& num, int left, int right){

        int mid = (left + right) / 2;
        TreeNode* newNode = new TreeNode(num[mid]);

        if(left == right){
            newNode->left = NULL;
            newNode->right = NULL;
        }
        else if(left == mid){
            newNode->left = NULL;
            newNode->right = recur(num, mid + 1, right);
        }
        else if(right == mid){
            newNode->left = recur(num, left, mid - 1);
            newNode->right = NULL;
        }
        else{
            newNode->left = recur(num, left, mid - 1);
            newNode->right = recur(num, mid + 1, right);
        }
        
        return newNode;
    }

    TreeNode *sortedArrayToBST(vector<int> &num) {
        if(num.empty())    return NULL;
        TreeNode* res = recur(num, 0, num.size() - 1);
        return res;
    }
};
