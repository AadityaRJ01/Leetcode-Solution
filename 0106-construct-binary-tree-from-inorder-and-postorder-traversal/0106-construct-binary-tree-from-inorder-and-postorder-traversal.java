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
    private int postIndex;
    private Map<Integer,Integer> inOrderMap=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        postIndex=postorder.length-1;
        return helper(postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] postorder,int left,int right){
        if(left>right) return null;
        int rootValue=postorder[postIndex--];
        TreeNode root=new TreeNode(rootValue);
        int inOrderIndex=inOrderMap.get(rootValue);
        root.right=helper(postorder,inOrderIndex+1,right);
        root.left=helper(postorder,left,inOrderIndex-1);
        return root;
    }
}