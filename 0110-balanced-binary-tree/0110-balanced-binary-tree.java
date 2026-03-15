/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfHeight(root)!=-1;
    }

    public int dfHeight(TreeNode root){
        if(root==null) return 0;
        int lHeight=dfHeight(root.left);
        if(lHeight==-1){
            return -1;
        }

        int rHeight=dfHeight(root.right);
        if(rHeight==-1){
            return -1;
        }
        if(Math.abs(lHeight-rHeight)>1){
            return -1;
        }
        return Math.max(lHeight,rHeight)+1;
    }
}