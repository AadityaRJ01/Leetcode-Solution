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
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new ArrayList<>());
        return res;
    }
    private void dfs(TreeNode node,int target,List<Integer> path){
        if(node==null){
            return;
        }
        path.add(node.val);
        if(node.left==null && node.right==null){
            if(target==node.val){
                res.add(new ArrayList<>(path));
            }
        }
        dfs(node.left,target-node.val,path);
        dfs(node.right,target-node.val,path);
        path.remove(path.size()-1);
    }
}