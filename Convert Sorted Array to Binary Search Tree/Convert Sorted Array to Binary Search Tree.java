/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        if(len == 0){
            return null;
        }
        int val = num[len / 2];
        TreeNode newNode = new TreeNode(val);
        
        if(len / 2 <= 0){
            newNode.left = null;
        }
        else{
            int[] newNum = Arrays.copyOfRange(num, 0, len / 2);
            newNode.left = sortedArrayToBST(newNum);
        }
        
        if(len / 2 + 1 >= len){
            newNode.right = null;
        }
        else{
            int[] newNum = Arrays.copyOfRange(num, len / 2 + 1, len);
            newNode.right = sortedArrayToBST(newNum);
        }
        
        return newNode;
    }
}
