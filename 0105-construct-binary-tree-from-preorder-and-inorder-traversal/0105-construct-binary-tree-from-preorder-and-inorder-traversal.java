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
    private int preOrderIndex=0;
    private Map<Integer,Integer> inOrderMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] preorder,int left,int right){
        if(left>right) return null;
        int rootValue=preorder[preOrderIndex++];
        TreeNode root=new TreeNode(rootValue);
        int inOrderIndex=inOrderMap.get(rootValue);
        root.left=helper(preorder,left,inOrderIndex-1);
        root.right=helper(preorder,inOrderIndex+1,right);
        return root;
    }
}